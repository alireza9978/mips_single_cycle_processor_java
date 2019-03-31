package processor.memory;

//cpu 32 register
public class RegisterFile {

    private Register[] datas;
    private static RegisterFile instance = null;

    private RegisterFile() {
        datas = new Register[32];
        for (int i = 0; i < 32; i++)
            datas[i] = new Register();
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
}
