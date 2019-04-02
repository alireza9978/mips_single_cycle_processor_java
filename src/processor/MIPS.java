package processor;

import processor.ALU.ALU;
import processor.controllers.Control;
import processor.controllers.ProgramCounter;
import processor.instruction.Parser;
import processor.instruction.types.Ins;
import processor.memory.InstructionsFile;
import processor.memory.MemoryFile;
import processor.memory.RegisterFile;

public class MIPS {

    private ProgramCounter pc;
    private InstructionsFile instructionsFile;
    private Control control;
    private RegisterFile registerFile;
    private ALU alu;
    private MemoryFile memoryFile;

    public MIPS() {
        pc = new ProgramCounter();
        instructionsFile = new InstructionsFile();
        control = new Control();
    }

    public void runNext() {
        Ins ins = Parser.parse(instructionsFile.read(pc.getPointer()));
        if (ins == null)
            return;
        control.load(ins.getOp());

    }

}
