package processor.instruction.types.R;

import processor.instruction.Parser;

public class R_type {

    private int op;
    private int destinationRegisterNumber;
    private int sourceOneRegisterNumber;
    private int sourceTwoRegisterNumber;
    private int shiftAmount;
    private int instruction;
//
//    public R_type(char[] binary) {
//        char[] temp = new char[5];
//        System.arraycopy(binary, 6, temp, 0, 5);//6 to 11
//        destinationRegisterNumber = Parser.convert(temp);
//        System.arraycopy(binary, 11, temp, 0, 5);//12 to 16
//        sourceOneRegisterNumber = Parser.convert(temp);
//        System.arraycopy(binary, 16, temp, 0, 5);//17 to 21
//        sourceTwoRegisterNumber = Parser.convert(temp);
//        System.arraycopy(binary, 21, temp, 0, 5);//22 to 27
//        shiftAmount = Parser.convert(temp);
//        temp = new char[6];
//        System.arraycopy(binary, 26, temp, 0, 6);//27 to 32
//        instruction = R_instruction.getInstruction(temp);
//    }

    public R_type(int op, int destinationRegisterNumber, int sourceOneRegisterNumber,
                  int sourceTwoRegisterNumber, int shiftAmount, int instruction) {
        this.op = op;
        this.destinationRegisterNumber = destinationRegisterNumber;
        this.sourceOneRegisterNumber = sourceOneRegisterNumber;
        this.sourceTwoRegisterNumber = sourceTwoRegisterNumber;
        this.shiftAmount = shiftAmount;
        this.instruction = instruction;
    }

    public int getDestinationRegisterNumber() {
        return destinationRegisterNumber;
    }

    public int getSourceOneRegisterNumber() {
        return sourceOneRegisterNumber;
    }

    public int getSourceTwoRegisterNumber() {
        return sourceTwoRegisterNumber;
    }

    public int getShiftAmount() {
        return shiftAmount;
    }

    public int getOp() {
        return op;
    }

    public char[] covert() {
        char[] ins = new char[32];
        System.arraycopy(Parser.convertToBinarySize(op, 6), 0, ins, 0, 6);
        System.arraycopy(Parser.convertToBinarySize(destinationRegisterNumber, 5), 0, ins, 6, 5);
        System.arraycopy(Parser.convertToBinarySize(sourceOneRegisterNumber, 5), 0, ins, 11, 5);
        System.arraycopy(Parser.convertToBinarySize(sourceTwoRegisterNumber, 5), 0, ins, 16, 5);
        System.arraycopy(Parser.convertToBinarySize(shiftAmount, 5), 0, ins, 21, 5);
        System.arraycopy(Parser.convertToBinarySize(instruction, 6), 0, ins, 26, 6);
        return ins;
    }

}
