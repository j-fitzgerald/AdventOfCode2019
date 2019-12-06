package OpCodeInterpreter;

import java.util.List;

public interface OpCodeInterpreter {



    void readNext(int index);

    default void onError(int index){
        System.out.println("Error parsing code " + printCode(OpCode.opCode));
    }

    default String printCode(int[] code){
        StringBuilder builder = new StringBuilder();
        for (int i : code){
            builder.append(i + ":");
        }
        return builder.toString();
    }


}
