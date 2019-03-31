package processor.instruction.types;

public abstract class Ins {

    private char[] binary;
    private Instructions_type type;

    public Ins(char[] binary, Instructions_type type) {
        this.binary = binary;
        this.type = type;
    }

    public char[] getBinary() {
        return binary;
    }

    public Instructions_type getType() {
        return type;
    }

}
