package processor.ALU;

import processor.instruction.Parser;

public class ALU {

    private boolean zero;
    private char[] result;

    public ALU() {
        zero = true;
        result = new char[32];
    }

    public void cycle(char[] inputOne, char[] inputTwo, ALU_abilities work) {
        switch (work) {
            case Add:
                result = Parser.convertToBinary(Parser.convert(inputOne) + Parser.convert(inputTwo));
                break;
            case Sub:
                result = Parser.convertToBinary(Parser.convert(inputOne) - Parser.convert(inputTwo));
                break;
            case Or:
                for (int i = 0; i < 32; i++) {
                    if (inputOne[i] == 1 || inputTwo[i] == 1) {
                        result[i] = 1;
                    } else {
                        result[i] = 0;
                    }
                }
                break;
            case And:
                for (int i = 0; i < 32; i++) {
                    if (inputOne[i] == 1 && inputTwo[i] == 1) {
                        result[i] = 1;
                    } else {
                        result[i] = 0;
                    }
                }
                break;
            case Slt:
                result = Parser.convert(inputOne) < Parser.convert(inputTwo) ? Parser.convertToBinary(1) : Parser.convertToBinary(0);
                break;
            case Nor:
                for (int i = 0; i < 32; i++) {
                    if (!(inputOne[i] == 1 || inputTwo[i] == 1)) {
                        result[i] = 1;
                    } else {
                        result[i] = 0;
                    }
                }
                break;
        }
        zero = Parser.convert(result) == 0;
    }

    public boolean isZero() {
        return zero;
    }

    public char[] getResult() {
        return result;
    }
}
