package processor.instruction.types.I;

import processor.instruction.Parser;

public enum I_instruction {

    LW, SW, ANDI, ORI, BEQ, BNQ;

    public static I_instruction getInstruction(char[] binary) {
        switch (Parser.convert(binary)) {
            case (35)://lw
                return LW;
            case (43)://sw
                return SW;
            case (12)://andi
                return ANDI;
            case (13)://ori
                return ORI;
            case (4)://beq
                return BEQ;
            case (5)://bnq
                return BNQ;
            default:
                return LW;
        }
    }

    }
