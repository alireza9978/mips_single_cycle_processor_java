package processor.instruction.types.R;

import processor.instruction.Parser;
import processor.instruction.types.Ins;
import processor.instruction.types.Instructions_type;

public class R_type extends Ins {

    private int destinationRegisterNumber;
    private int sourceOneRegisterNumber;
    private int sourceTwoRegisterNumber;
    private int shiftAmount;
    private R_instruction instruction;

    public R_type(char[] binary) {
        super(binary, Instructions_type.R_type);
        char[] temp = new char[5];
        System.arraycopy(binary, 6, temp, 0, 5);//6 to 11
        destinationRegisterNumber = Parser.convert(temp);
        System.arraycopy(binary, 11, temp, 0, 5);//12 to 16
        sourceOneRegisterNumber = Parser.convert(temp);
        System.arraycopy(binary, 16, temp, 0, 5);//17 to 21
        sourceTwoRegisterNumber = Parser.convert(temp);
        System.arraycopy(binary, 21, temp, 0, 5);//22 to 27
        shiftAmount = Parser.convert(temp);
        temp = new char[6];
        System.arraycopy(binary, 26, temp, 0, 6);//27 to 32
        instruction = R_instruction.getInstruction(temp);
    }

    public int getDestinationRegisterNumber() {
        return destinationRegisterNumber;
    }

    public int getSourceOneRegisterNumber() {
        return sourceOneRegisterNumber;
    }

    public int getSourceTwoRegisterNumber() {
        return sourceTwoRegisterNumber;
    }

    public int getShiftAmount() {
        return shiftAmount;
    }

    public R_instruction getInstruction() {
        return instruction;
    }
}
