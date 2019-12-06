package OpCodeInterpreter;

import Memory.MemoryItem;

public class TwoCodeInterpreter implements  OpCodeInterpreter{

    String myString = "";
    @Override
    public void readNext(int index) {

        int[] code = OpCode.opCode;
        int total = code[code[index + 1]] * code[code[index + 2]];


        // store in position 3
        System.out.println("Index " + code[index + 3] + " has been set to "+ total + "\n\tthe product of indices " + code[index + 1] + "\t" + code[index + 2]);
        code[code[index + 3]] = total;
        OpCode.itemList[code[index+3]].setOpCode(this);
        myString = "Product of addresses " + code[index+1]+ " * " + code[index+2];
    }

    public String toString(){
        return myString;
    }

}
