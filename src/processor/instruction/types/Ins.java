package processor.instruction.types;

public abstract class Ins {

    private char[] binary;
    private char[] op;
    private Instructions_type type;

    public Ins(char[] binary, Instructions_type type) {
        this.binary = binary;
        this.type = type;
        op = new char[6];
        System.arraycopy(binary, 0, op, 0, 6);
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

}
