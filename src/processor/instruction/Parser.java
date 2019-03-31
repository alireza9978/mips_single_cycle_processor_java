package processor.instruction;

import processor.instruction.types.*;

public abstract class Parser {

    public static Ins parse(char[] binary) {
        switch (getKind(binary)) {
            case R_type:
                return new R_type(binary);
            case J_type:
                return new J_type(binary);
            case I_type:
                return new I_type(binary);
        }
        return null;
    }

    public static Instructions_type getKind(char[] binary) {

        return Instructions_type.I_type;
    }


}
