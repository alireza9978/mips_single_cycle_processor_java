package processor.controllers;

import processor.instruction.Parser;

public class Control {

    private boolean RegDest;
    private boolean Branch;
    private boolean MemRead;
    private boolean MemtoReg;
    private boolean ALUOp1;
    private boolean ALUOp0;
    private boolean MemWrite;
    private boolean ALUsrc;
    private boolean RegWrite;
//    private boolean Jump;


    public Control() {
    }

    public void load(char[] instruction) {
        int temp = Parser.convert(instruction);

        //jump = (temp == 2);
        RegDest = temp == 0;
        Branch = (temp == 4);
        MemWrite = (temp == 43);
        ALUsrc = ((temp != 0) && (temp != 4) && (temp != 5));// != BEQ BNE
        MemtoReg = (temp == 35);// == LW
        RegWrite = (temp != 43) && (temp != 4) && (temp != 5) && (temp != 2);
        MemRead = (temp == 35);
        ALUOp0 = (temp == 0);
        ALUOp1 = (temp == 4);
    }


    public boolean isRegDest() {
        return RegDest;
    }

    public boolean isBranch() {
        return Branch;
    }

    public boolean isMemRead() {
        return MemRead;
    }

    public boolean isMemtoReg() {
        return MemtoReg;
    }

    public boolean isALUOp1() {
        return ALUOp1;
    }

    public boolean isALUOp0() {
        return ALUOp0;
    }

    public boolean isMemWrite() {
        return MemWrite;
    }

    public boolean isALUsrc() {
        return ALUsrc;
    }

    public boolean isRegWrite() {
        return RegWrite;
    }

    @Override
    public String toString() {
        return "Control{" +
                "RegDest=" + RegDest +
                ", Branch=" + Branch +
                ", MemRead=" + MemRead +
                ", MemtoReg=" + MemtoReg +
                ", ALUOp1=" + ALUOp1 +
                ", ALUOp0=" + ALUOp0 +
                ", MemWrite=" + MemWrite +
                ", ALUsrc=" + ALUsrc +
                ", RegWrite=" + RegWrite +
                '}';
    }
}
