package processor;

public class Multiplexer {

    public Multiplexer() {
    }

    public char[] cycle(char[] one, char[] two, boolean select) {
        if (!select) {
            return one;
        } else
            return two;
    }

    public int cycle(int one, int two, boolean select) {
        if (!select) {
            return one;
        } else
            return two;
    }

}
