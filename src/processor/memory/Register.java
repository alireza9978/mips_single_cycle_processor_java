package processor.memory;

public class Register {

    private char[] data;

    Register() {
        data = new char[32];
        for (int i = 0; i < 32; i++)
            data[i] = 0;
    }

    public char[] getData() {
        return data;
    }
}
