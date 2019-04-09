package processor;

import processor.ALU.ALU;
import processor.controllers.ALUControl;
import processor.controllers.Control;
import processor.controllers.ProgramCounter;
import processor.instruction.Parser;
import processor.instruction.types.Ins;
import processor.memory.InstructionsFile;
import processor.memory.MemoryFile;
import processor.memory.Register;
import processor.memory.RegisterFile;

import java.util.ArrayList;

public class MIPS {

    private ProgramCounter pc;
    private InstructionsFile instructionsFile;
    private Control control;
    private ALU alu;
    private ALUControl aluControl;
    private MemoryFile memoryFile;

    public MIPS(int memorySize) {
        pc = new ProgramCounter();
        instructionsFile = new InstructionsFile();
        control = new Control();
        alu = new ALU();
        aluControl = new ALUControl();
        memoryFile = new MemoryFile(memorySize);
        reset();
    }

    public void runNext() {
        //load instruction
        int pcTemp = pc.getPointer();
//        System.out.println("pointer" + pcTemp);
        Ins ins = Parser.parse(instructionsFile.read(pcTemp));
        if (ins == null)
            return;
//        System.out.println(ins);
//        System.out.println("   ");
//
//        Register register = new Register();
//        register.setData(instructionsFile.read(pcTemp));
//        register.setData(Register.reverse(register.getData()));
//        Ins tempIns = Parser.parse(register.getData());
//        System.out.println(tempIns);

        //make controller output ready
        control.load(ins.getOp());
//        logControl();
        int writeRegister = new Multiplexer().cycle(ins.getIns20_16(), ins.getIns15_11(), control.isRegDest());

        //read from register file
        char[] readOne = RegisterFile.getInstance().read(ins.getIns25_21());
        char[] readTwo = RegisterFile.getInstance().read(ins.getIns20_16());
//        System.out.println("read one " + Parser.convert(readOne));
//        System.out.println("read two " + Parser.convert(readTwo));


        //sign extending
        char[] signExtended = new char[32];
        System.arraycopy(ins.getBinary(), 16, signExtended, 16, 16);
        char ex = ins.getBinary()[16];
        for (int i = 0; i < 16; i++) {
            signExtended[i] = ex;
        }

        //alu controller working
        aluControl.cycle(ins.getIns5_0Char(),  control.isALUOp0(),control.isALUOp1());

        //alu working
        char[] aluSecondInput = new Multiplexer().cycle(readTwo, signExtended, control.isALUsrc());
        alu.cycle(readOne, aluSecondInput, aluControl.getWork());
//        System.out.println("alu ans " + Parser.convert(alu.getResult()));
//        System.out.println("alu work " + aluControl.getWork());
        //read or write in memory
        memoryFile.cycle(alu.getResult(), readTwo, control.isMemWrite(), control.isMemRead());

        //write data
        char[] writeData = new Multiplexer().cycle(alu.getResult(), memoryFile.getReadData(), control.isMemtoReg());
        RegisterFile.getInstance().write(writeRegister, writeData, control.isRegWrite());

        //set pc
        int temp = (Parser.convert(signExtended) << 2) + pc.getPointerWithoutAdd();
        int newPointer = new Multiplexer().cycle(pc.getPointer(), temp,
                control.isBranch() && alu.isZero());
        pc.setPointer(newPointer);
    }

    public void loadInstruction(ArrayList<Register> ins) {
        instructionsFile.load(ins);
    }

    public void reset() {
        pc.reset();
        instructionsFile.reset();
        alu.reset();
        RegisterFile.getInstance().reset();
        memoryFile.reset();
    }

    public MemoryFile getMemoryFile() {
        return memoryFile;
    }

    public void logInstruction() {
        instructionsFile.log();
    }

    public void logMemory() {
        memoryFile.log();
    }

    public void logRegisterFile() {
        RegisterFile.getInstance().log();
    }

    public void logControl() {
        System.out.println(control.toString());
    }

    public void log() {
        logRegisterFile();
        logInstruction();
        logMemory();
    }

}
