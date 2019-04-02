package processor.instruction;

import processor.instruction.types.Ins;
import processor.instruction.types.Instructions_type;

public abstract class Parser {

    public static Ins parse(char[] binary) {
        Ins ins = null;
        switch (getKind(binary)) {
            case R_type:
                return new Ins(binary, Instructions_type.R_type);
            case J_type:
                return new Ins(binary, Instructions_type.J_type);
            case I_type:
                return new Ins(binary, Instructions_type.I_type);
        }
        return ins;
    }

    public static Instructions_type getKind(char[] binary) {
        char[] OP = new char[6];
        System.arraycopy(binary, 0, OP, 0, 6);
        switch (convert(OP)) {//max 63(14)
            case (0)://add - sub - and - or - nor - sll - srl - slt
                return Instructions_type.R_type;
            case (35)://lw
            case (43)://sw
            case (12)://andi
            case (13)://ori
            case (4)://beq
            case (5)://bnq
                return Instructions_type.I_type;
            case (2)://j
                return Instructions_type.J_type;
            default:
                return Instructions_type.J_type;
        }
    }

    public static int convert(char[] binary) {
        int ans = 0;
        for (int i = binary.length; i > -1; i--) {
            if (binary[i] == 1) {
                ans += (2 * i);
            }
        }
        return ans;
    }

}
