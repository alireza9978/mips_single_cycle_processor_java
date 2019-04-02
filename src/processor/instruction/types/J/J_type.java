package processor.instruction.types.J;

import processor.instruction.Parser;

public class J_type {

    //only support jump in j type instructions
    private int immediate;
    private int op;

//    public J_type(char[] binary) {
//        super(binary, Instructions_type.J_type);
//        char[] temp = new char[28];
//        System.arraycopy(binary, 6, temp, 2, 26);
//        temp[0] = 0;
//        temp[1] = 0;
//        immediate = Parser.convert(temp);
//    }


    public J_type(int immediate, int op) {
        this.immediate = immediate;
        this.op = op;
    }

    public int getImmediate() {
        return immediate;
    }

    public int getOp() {
        return op;
    }

    public char[] covert() {
        char[] ins = new char[32];
        System.arraycopy(Parser.convertToBinarySize(op, 6), 0, ins, 0, 6);
        System.arraycopy(Parser.convertToBinarySize(immediate, 26), 0, ins, 6, 26);
        return ins;
    }

}
