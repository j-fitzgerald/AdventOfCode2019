package OpCodeInterpreter;

import Memory.MemoryItem;

public class OneCodeInterpreter implements OpCodeInterpreter {

    String myString = "";

    @Override
    public void readNext(int index) {
        int[] code = OpCode.opCode;
        // sum positions 1 and 2
        int total = code[code[index + 1]] + code[code[index + 2]];

        // store in position 3
        System.out.println("Index " + code[index + 3] + " has been set to "+ total + "\n\tthe sum of indices " + code[index + 1] + "\t" + code[index + 2]);
        code[code[index + 3]] = total;
        OpCode.itemList[code[index+3]].setOpCode(this);
        myString = "Sum of addresses " + code[index+1]+ " + " + code[index+2];
    }


    public String toString() {return myString;}

}
