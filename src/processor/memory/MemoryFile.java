package processor.memory;

import processor.instruction.Parser;

//system memory
public class MemoryFile {

    private char[] readData;
    private Register[] memory;

    public MemoryFile(int size) {
        memory = new Register[size];
        for (int i = 0; i < size; i++) {
            memory[i] = new Register();
        }
        reset();
    }

    public void cycle(char[] address, char[] writeData, boolean memWrite, boolean memRead) {
        int number = Parser.convert(address);
        if (memRead) {
            readData = memory[number].getData();
        }
        if (memWrite) {
            memory[number].setData(writeData);
        }
    }

    public void setData(int number, char[] data) {
        memory[number].setData(data);
    }

    public char[] getReadData() {
        return readData;
    }

    public void reset() {
        for (int i = 0; i < memory.length; i++) {
            memory[i].reset();
        }
    }

    public void log() {
        System.out.println("memory File " + memory.length);
        for (Register register : memory) {
            System.out.println(register.toString());
        }
    }

}
