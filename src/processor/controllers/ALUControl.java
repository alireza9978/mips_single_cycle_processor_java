package processor.controllers;

import processor.ALU.ALU_abilities;
import processor.instruction.Parser;

import javax.xml.ws.handler.LogicalHandler;

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
                    break;
                case 2:
                    work = ALU_abilities.Sub;
                    break;

                case 4:
                    work = ALU_abilities.And;
                    break;

                case 5:
                    work = ALU_abilities.Or;
                    break;

                case 10:
                    work = ALU_abilities.Slt;
                    break;

                default:
                    System.err.println("ALU controller Error");
                    for (char c : ins)
                        System.err.print("" + c);
                    System.err.println("up = " + inputUp);
                    System.err.println("low = " + inputLow);
            }
        }
    }

    public ALU_abilities getWork() {
        return work;
    }
}
