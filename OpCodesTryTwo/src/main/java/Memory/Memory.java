package Memory;

import Operations.Operations;
import Operations.IdentityOp;
import Operations.AddOp;
import Operations.MultOp;


public class Memory {
    public static Operations[] opsList;
    public static int[] asInt;

    public void makeMemory(int[] intList){
        asInt = intList;
        opsList = new Operations[asInt.length];
        for(int i = 0; i<intList.length; i++){
            opsList[i] = new IdentityOp(i, asInt[i]);
        }
    }

    public void makeOps(){
        Operations op;
        for(int i = 0; i < asInt.length; i += 4){
            switch(opsList[i].getValue()){
                case(1):
                    op = new AddOp(i);
                    op.read();
                    break;
                case(2):
                    op = new MultOp(i);
                    op.read();
                    break;
                case(99):
//                    System.out.println("99 end");
//                    System.out.println(opsList[0].toString());
                    return;
                default:
                    System.out.println("Unknown op");
                    i -= 3;
            }

        }
        System.out.println(opsList[0].toString());
    }
}
