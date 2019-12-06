package Memory;


import IntCodesInterpreter.Operations.AddOp;
import IntCodesInterpreter.Operations.IdentityOp;
import IntCodesInterpreter.Operations.MultOp;
import IntCodesInterpreter.Operations.Operations;
import IntCodesInterpreter.Operations.PullOp;
import IntCodesInterpreter.Operations.PushOp;

public class MemCodes {
    public static Operations[] opsList;
    public static int[] asInt;
    public static Operations input;
    public static Operations output;

    public void makeMemory(int[] intList){
        asInt = intList;
        opsList = new Operations[asInt.length];
        for(int i = 0; i<intList.length; i++){
            opsList[i] = new IdentityOp(i, asInt[i]);
        }
    }

    public void makeOps(){
        Operations op;
        for(int i = 0; i < asInt.length; ){
            switch(opsList[i].getValue()){
                case(1):
                    op = new AddOp(i);
                    op.read();
                    i += op.advance();
                    break;
                case(2):
                    op = new MultOp(i);
                    op.read();
                    i += op.advance();
                    break;
                case(3):
                    op = new PullOp(i);
                    op.read();
                    i += op.advance();
                    break;
                case(4):
                    op = new PushOp(i);
                    op.read();
                    i += op.advance();
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

    public void makeOpsParsed(){
        ParseCode.parse(0, asInt);
    }
}
