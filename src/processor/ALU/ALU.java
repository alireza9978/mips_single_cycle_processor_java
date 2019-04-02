package processor.ALU;

public class ALU {

    private boolean zero;
    private char[] result;

    public ALU() {
        zero = true;
        result = new char[32];
    }

    public void cycle(char[] inputOne, char[] inputTwo, ALU_abilities work) {
        //todo complete here
    }

    public boolean isZero() {
        return zero;
    }

    public char[] getResult() {
        return result;
    }
}
