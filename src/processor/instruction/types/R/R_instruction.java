package processor.instruction.types.R;

import processor.instruction.Parser;

public enum R_instruction {

    ADD, SUB, AND, OR, SLT, SLL;

    public static R_instruction getInstruction(char[] binary) {
        switch (Parser.convert(binary)) {
            case (0):
                return SLL;
            case (32):
                return ADD;
            case (34):
                return SUB;
            case (36):
                return AND;
            case (37):
                return OR;
            case (42):
                return SLT;
            default:
                return ADD;
        }
    }

}
