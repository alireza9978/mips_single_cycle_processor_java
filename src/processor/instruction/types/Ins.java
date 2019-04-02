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
    private char[] ins31_26Char;
    private char[] ins25_21Char;
    private char[] ins20_16Char;
    private char[] ins15_11Char;
    private char[] ins10_6Char;
    private char[] ins5_0Char;
    private char[] ins15_0Char;

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
        ins25_21Char = temp;

        temp = new char[5];
        System.arraycopy(binary, 11, temp, 0, 5);//12 to 16
        ins20_16 = Parser.convert(temp);
        ins20_16Char = temp;

        temp = new char[5];
        System.arraycopy(binary, 16, temp, 0, 5);//17 to 21
        ins15_11 = Parser.convert(temp);
        ins15_11Char = temp;

        temp = new char[5];
        System.arraycopy(binary, 21, temp, 0, 5);//22 to 26
        ins10_6 = Parser.convert(temp);
        ins10_6Char = temp;

        temp = new char[6];
        System.arraycopy(binary, 26, temp, 0, 6);//27 to 32
        ins5_0 = Parser.convert(temp);
        ins5_0Char = temp;

        temp = new char[16];
        System.arraycopy(binary, 16, temp, 0, 16);//offset
        ins15_0 = Parser.convert(temp);
        ins15_0Char = temp;
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

    public char[] getIns31_26Char() {
        return ins31_26Char;
    }

    public char[] getIns25_21Char() {
        return ins25_21Char;
    }

    public char[] getIns20_16Char() {
        return ins20_16Char;
    }

    public char[] getIns15_11Char() {
        return ins15_11Char;
    }

    public char[] getIns10_6Char() {
        return ins10_6Char;
    }

    public char[] getIns5_0Char() {
        return ins5_0Char;
    }

    public char[] getIns15_0Char() {
        return ins15_0Char;
    }
}
