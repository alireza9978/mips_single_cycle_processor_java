package processor.memory;

public class Register {

    private char[] data;

    Register() {
        data = new char[32];
        reset();
    }

    public char[] getData() {
        return data;
    }

    public void setData(char[] data) {
        this.data = data;
    }

    public void reset() {
        for (int i = 0; i < 32; i++)
            data[i] = 0;
    }
}
