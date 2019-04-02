package processor.memory;

import java.util.ArrayList;

//instructions are here
public class InstructionsFile {

    private ArrayList<Register> registers = new ArrayList<>();

    public void load(ArrayList<Register> registers) {
        this.registers = registers;
    }

    public char[] read(int index) {
        if (index < registers.size()) {
            return registers.get(index).getData();
        }
        return null;
    }


}
