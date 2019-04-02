package processor.memory;

//system memory
public class MemoryFile {

    char[] readData;

    public MemoryFile() {
        reset();
    }

    public void cycle(char[] address, char[] writeData, boolean memWrite, boolean memRead) {

    }

    public char[] getReadData() {
        return readData;
    }

    public void reset() {

    }

}
