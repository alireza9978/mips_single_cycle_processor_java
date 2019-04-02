package processor.memory;

//cpu 32 register
public class RegisterFile {

    private Register[] datas;
    private static RegisterFile instance = null;

    private RegisterFile() {
        datas = new Register[32];
        for (int i = 0; i < 32; i++)
            datas[i] = new Register();
        reset();
    }

    public static RegisterFile getInstance() {
        if (instance == null) {
            instance = new RegisterFile();
            return instance;
        } else return instance;
    }

    public Register getData(int index) {
        return datas[index];
    }

    public void write(int index, char[] writeData, boolean regWrite) {
        if (regWrite) {
            datas[index].setData(writeData);
        }
    }

    public char[] read(int read) {
        return datas[read].getData();
    }

    public void reset() {
        for (int i = 0; i < 32; i++)
            datas[i].reset();
    }

}
