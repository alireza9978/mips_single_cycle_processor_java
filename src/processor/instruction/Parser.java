package processor.instruction;

import processor.instruction.types.Ins;
import processor.instruction.types.Instructions_type;
import processor.memory.Register;

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
        char[] data = Register.reverse(binary);
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                ans += (Math.pow(2 , (i)));
            }
        }
        return ans;
    }

    public static char[] convertToBinary(int no) {
        char[] container = new char[32];
        int i = 0;
        while (no > 0) {
            if (i > 31) {
                break;
            }
            container[i] = (char) (no % 2);
            i++;
            no = no / 2;
        }
        for (int j = 31; j >= i; i--) {
            container[j] = 0;
        }
        char[] reverse = new char[container.length];
        for (int k = 0, h = reverse.length - 1; k < reverse.length; k++, h--) {
            reverse[k] = container[h];
        }
        return reverse;
    }

    public static char[] convertToBinarySize(int no, int size) {
        char[] container = new char[size];
        int i = 0;
        while (no > 0) {
            if (i > size - 1) {
                break;
            }
            container[i] = (char) (no % 2);
            i++;
            no = no / 2;
        }
        for (int j = size - 1; j >= i; j--) {
            container[j] = 0;
        }
        char[] reverse = new char[size];
        for (int k = 0, h = reverse.length - 1; k < reverse.length; k++, h--) {
            reverse[k] = container[h];
        }
        return reverse;
    }

}
