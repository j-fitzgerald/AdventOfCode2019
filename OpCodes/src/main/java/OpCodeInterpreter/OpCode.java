package OpCodeInterpreter;

import Memory.MemoryItem;

public class OpCode {

    public static int[] opCode;
    public static MemoryItem[] itemList;
    OneCodeInterpreter oneCode = new OneCodeInterpreter();
    TwoCodeInterpreter twoCode = new TwoCodeInterpreter();
    NineNineCodeInterpreter nineNineCode = new NineNineCodeInterpreter();

    int size = 4;

    public OpCode(){

    }

    public void setOpCode(int[] code){
         opCode = code;
         itemList = new MemoryItem[opCode.length];
    }

    public void readCode(){
        int index=0;

        while (index < opCode.length){
            itemList[index] = new MemoryItem(index);
            switch(opCode[index]){
                case(1):
                    itemList[index].setOpCode(oneCode);
//                    oneCode.readNext(index);
                    itemList[index].read();
                    index += size;
                    break;
                case(2):
                    itemList[index].setOpCode(twoCode);
//                    twoCode.readNext(index);
                    itemList[index].read();
                    index += size;
                    break;
                case(99):
                    nineNineCode.readNext(index);
                    System.out.println("99 reached... to string:");
                    System.out.println(itemList[0].toString());
                    return;
                default:
                    System.out.println("Unknown code: " + opCode[index]);
                    System.exit(opCode[index]);
            }
        }
    }

}
