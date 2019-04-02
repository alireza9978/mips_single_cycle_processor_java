import processor.MIPS;
import processor.instruction.Parser;
import processor.instruction.types.I.I_type;
import processor.instruction.types.J.J_type;
import processor.instruction.types.R.R_type;
import processor.memory.Register;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Register> ins = new ArrayList<>();

        Register temp = new Register();
        R_type r_type = new R_type(0, 0
                , 19, 9, 2, 0);
        temp.setData(r_type.covert());
        ins.add(temp);

        temp = new Register();
        r_type = new R_type(0, 9
                , 22, 9, 0, 32);
        temp.setData(r_type.covert());
        ins.add(temp);

        temp = new Register();
        I_type i_type = new I_type(35, 9,
                8, 0);
        temp.setData(i_type.covert());
        ins.add(temp);

        temp = new Register();
        i_type = new I_type(5, 8,
                21, 2);
        temp.setData(i_type.covert());
        ins.add(temp);

        temp = new Register();
        i_type = new I_type(8, 19,
                19, 1);
        temp.setData(i_type.covert());
        ins.add(temp);

        temp = new Register();
        J_type j = new J_type(10, 2);
        temp.setData(j.covert());
        ins.add(temp);

        MIPS mips = new MIPS(50);
        mips.loadInstruction(ins);
        mips.getMemoryFile().setData(10, Parser.convertToBinary(1));
//        mips.log();

        for (int i = 0; i < 5; i++) {
            System.out.println("run " + i);
            mips.runNext();
            mips.logRegisterFile();
        }
        mips.log();
    }

}
