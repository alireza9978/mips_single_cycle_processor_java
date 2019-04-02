package processor.controllers;

public class ProgramCounter {

    private int pointer;

    public ProgramCounter() {
        reset();
    }

    public int getPointer() {
        int temp = pointer;
        pointer++;
        return temp;
    }

    public int getPointerWithoutAdd() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public void reset(){
        pointer = 0;
    }

}
