import processor.MIPS;
import processor.instruction.Parser;
import processor.instruction.types.I.I_type;
import processor.instruction.types.R.R_type;
import processor.memory.Register;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Register> ins = new ArrayList<>();

/*

    int number = 0;
    number += 3;
    int temp = 20;
    number = number + temp;
 */
        Register temp = new Register();
        R_type r_type = new R_type(0, 0
                , 0, 1, 0, 32);
        temp.setData(r_type.covert());
        ins.add(temp);

        temp = new Register();
        I_type i_type = new I_type(8, 0,
                1, 3);
        temp.setData(i_type.covert());
        ins.add(temp);


        temp = new Register();
        i_type = new I_type(8, 0,
                2, 20);
        temp.setData(i_type.covert());
        ins.add(temp);


        temp = new Register();
        r_type = new R_type(0, 1
                , 2, 1, 0, 32);
        temp.setData(r_type.covert());
        ins.add(temp);


        MIPS mips = new MIPS(50);
        mips.loadInstruction(ins);
        mips.getMemoryFile().setData(10, Parser.convertToBinary(1));
//        mips.logInstruction();
//        mips.log();

        for (int i = 0; i < 4; i++) {
//            System.out.println("run " + i);
            mips.runNext();
//            mips.logRegisterFile();
        }
        mips.log();
    }

}
