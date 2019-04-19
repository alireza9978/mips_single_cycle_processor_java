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
    temp = number - temp;
    $3 = temp & number
    $4 = temp | number
    $5 = $4 < $3
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


        //add
        temp = new Register();
        r_type = new R_type(0, 1
                , 2, 1, 0, 32);
        temp.setData(r_type.covert());
        ins.add(temp);

        //sub
        temp = new Register();
        r_type = new R_type(0, 1
                , 2, 2, 0, 34);
        temp.setData(r_type.covert());
        ins.add(temp);

        //sw
        temp = new Register();
        i_type = new I_type(43, 0,
                1, 5);
        temp.setData(i_type.covert());
        ins.add(temp);

        //and
        temp = new Register();
        r_type = new R_type(0, 1
                , 2, 3, 0, 36);
        temp.setData(r_type.covert());
        ins.add(temp);

        //or
        temp = new Register();
        r_type = new R_type(0, 1
                , 2, 4, 0, 37);
        temp.setData(r_type.covert());
        ins.add(temp);

//        slt
        temp = new Register();
        r_type = new R_type(0, 3
                , 4, 5, 0, 42);
        temp.setData(r_type.covert());
        ins.add(temp);

        //lw
        temp = new Register();
        i_type = new I_type(35, 0,
                8, 10);
        temp.setData(i_type.covert());
        ins.add(temp);

        MIPS mips = new MIPS(50);
        mips.loadInstruction(ins);
        mips.getMemoryFile().setData(10, Parser.convertToBinary(1));
//        mips.logInstruction();
//        mips.log();

        for (int i = 0; i < ins.size(); i++) {
//            System.out.println("run " + i);
            mips.runNext();
//            mips.logRegisterFile();
        }
        mips.log();
    }

}
