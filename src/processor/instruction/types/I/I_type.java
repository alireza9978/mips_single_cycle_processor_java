package processor.instruction.types.I;

import processor.instruction.Parser;

public class I_type {

    private int op;
    private int destinationRegisterNumber;
    private int baseRegisterNumber;
    private int offset;


//    public I_type(char[] binary) {
//        super(binary, Instructions_type.I_type);
//        char[] temp = new char[6];
//        System.arraycopy(binary, 0, temp, 0, 6);//OP
//        instruction = I_instruction.getInstruction(temp);
//
//        temp = new char[16];
//        System.arraycopy(binary, 16, temp, 0, 16);//offset
//        offset = Parser.convert(temp);
//
//        temp = new char[5];
//        System.arraycopy(binary, 6, temp, 0, 5);//base
//        baseRegisterNumber = Parser.convert(temp);
//
//        System.arraycopy(binary, 12, temp, 0, 5);//rs
//        destinationRegisterNumber = Parser.convert(binary);
//    }


    public I_type(int op, int destinationRegisterNumber, int baseRegisterNumber, int offset) {
        this.op = op;
        this.destinationRegisterNumber = destinationRegisterNumber;
        this.baseRegisterNumber = baseRegisterNumber;
        this.offset = offset;
    }

    public int getOp() {
        return op;
    }

    public int getDestinationRegisterNumber() {
        return destinationRegisterNumber;
    }

    public int getBaseRegisterNumber() {
        return baseRegisterNumber;
    }

    public int getOffset() {
        return offset;
    }

    public char[] covert() {
        char[] ins = new char[32];
        System.arraycopy(Parser.convertToBinarySize(op, 6), 0, ins, 0, 6);
        System.arraycopy(Parser.convertToBinarySize(destinationRegisterNumber, 5), 0, ins, 6, 5);
        System.arraycopy(Parser.convertToBinarySize(baseRegisterNumber, 5), 0, ins, 11, 5);
        System.arraycopy(Parser.convertToBinarySize(offset, 16), 0, ins, 16, 16);
        return ins;
    }

}
