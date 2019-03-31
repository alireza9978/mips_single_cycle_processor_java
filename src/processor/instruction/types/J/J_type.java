package processor.instruction.types.J;

import processor.instruction.Parser;
import processor.instruction.types.Ins;
import processor.instruction.types.Instructions_type;

public class J_type extends Ins {

    //only support jump in j type instructions
    private int immediate;

    public J_type(char[] binary) {
        super(binary, Instructions_type.J_type);
        char[] temp = new char[28];
        System.arraycopy(binary, 6, temp, 2, 26);
        temp[0] = 0;
        temp[1] = 0;
        immediate = Parser.convert(temp);
    }

    public int getImmediate() {
        return immediate;
    }
}
