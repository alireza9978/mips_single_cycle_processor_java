package processor.instruction.types.I;

import processor.instruction.Parser;
import processor.instruction.types.Ins;
import processor.instruction.types.Instructions_type;

public class I_type extends Ins {

    private I_instruction instruction;
    private int destinationRegisterNumber;
    private int baseRegisterNumber;
    private int offset;

    public I_type(char[] binary) {
        super(binary, Instructions_type.I_type);
        char[] temp = new char[6];
        System.arraycopy(binary, 0, temp, 0, 6);//OP
        instruction = I_instruction.getInstruction(temp);

        temp = new char[16];
        System.arraycopy(binary, 16, temp, 0, 16);//offset
        offset = Parser.convert(temp);

        temp = new char[5];
        System.arraycopy(binary, 6, temp, 0, 5);//base
        baseRegisterNumber = Parser.convert(temp);

        System.arraycopy(binary, 12, temp, 0, 5);//rs
        destinationRegisterNumber = Parser.convert(binary);
    }

    public I_instruction getInstruction() {
        return instruction;
    }

    public int getDestinationRegisterNumber() {
        return destinationRegisterNumber;
    }

    public int getBaseRegisterNumber() {
        return baseRegisterNumber;
    }

    public int getOffset() {
        return offset;
    }
}
