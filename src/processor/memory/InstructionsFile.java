package processor.memory;

import java.util.ArrayList;

//instructions are here
public class InstructionsFile {

    private ArrayList<Register> registers = new ArrayList<>();

    public void load(ArrayList<Register> registers) {
        this.registers.addAll(registers);
    }

    public char[] read(int index) {
        if (index < registers.size()) {
            return registers.get(index).getData();
        }
        return null;
    }

    public void reset() {
        registers = new ArrayList<>();
    }

    public void log() {
        System.out.println("Instruction file");
        for (Register register : registers) {
            System.out.println(register.toString());
        }
    }

}
