package processor.controllers;

import processor.ALU.ALU_abilities;
import processor.instruction.Parser;

public class ALUControl {

    private ALU_abilities work;

    public ALUControl() {
    }

    public void cycle(char[] ins, boolean inputUp, boolean inputLow) {
        if (!inputLow && !inputUp) {
            work = ALU_abilities.Add;
        }
        if (inputLow) {
            work = ALU_abilities.Sub;
        }
        if (inputUp) {
            char[] temp = new char[4];
            System.arraycopy(ins, 2, temp, 0, 4);
            int need = Parser.convert(temp);
            switch (need) {
                case 0:
                    work = ALU_abilities.Add;
                case 2:
                    work = ALU_abilities.Sub;
                case 4:
                    work = ALU_abilities.And;
                case 5:
                    work = ALU_abilities.Or;
                case 10:
                    work = ALU_abilities.Slt;

            }
        }
    }

    public ALU_abilities getWork() {
        return work;
    }
}
