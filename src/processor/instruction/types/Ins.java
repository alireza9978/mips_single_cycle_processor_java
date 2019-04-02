package processor.instruction.types;

import processor.instruction.Parser;

public class Ins {

    private char[] binary;
    private char[] op;
    private Instructions_type type;

    private int ins31_26;
    private int ins25_21;
    private int ins20_16;
    private int ins15_11;
    private int ins10_6;
    private int ins5_0;
    private int ins15_0;

    public Ins(char[] binary, Instructions_type type) {
        this.binary = binary;
        this.type = type;
        op = new char[6];
        System.arraycopy(binary, 0, op, 0, 6);

        ins31_26 = Parser.convert(op);

        paresAsNumber();
    }


    private void paresAsNumber() {
        char[] temp = new char[5];
        System.arraycopy(binary, 6, temp, 0, 5);//6 to 11
        ins25_21 = Parser.convert(temp);
        System.arraycopy(binary, 11, temp, 0, 5);//12 to 16
        ins20_16 = Parser.convert(temp);
        System.arraycopy(binary, 16, temp, 0, 5);//17 to 21
        ins15_11 = Parser.convert(temp);
        System.arraycopy(binary, 21, temp, 0, 5);//22 to 27
        ins10_6 = Parser.convert(temp);
        System.arraycopy(binary, 27, temp, 0, 5);//28 to 32
        ins5_0 = Parser.convert(temp);
        temp = new char[16];
        System.arraycopy(binary, 16, temp, 0, 16);//offset
        ins15_0 = Parser.convert(temp);
    }


    public char[] getOp() {
        return op;
    }

    public char[] getBinary() {
        return binary;
    }

    public Instructions_type getType() {
        return type;
    }

    public int getIns31_26() {
        return ins31_26;
    }

    public int getIns25_21() {
        return ins25_21;
    }

    public int getIns20_16() {
        return ins20_16;
    }

    public int getIns15_11() {
        return ins15_11;
    }

    public int getIns10_6() {
        return ins10_6;
    }

    public int getIns5_0() {
        return ins5_0;
    }

    public int getIns15_0() {
        return ins15_0;
    }
}
