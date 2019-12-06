package Memory;

import OpCodeInterpreter.OpCodeInterpreter;

public class MemoryItem {
    int address;
    OpCodeInterpreter opCodeInterpreter;

    public MemoryItem(int i){
        this.address = i;
    }

    public void setOpCode(OpCodeInterpreter opCode){
        this.opCodeInterpreter = opCode;
    }

    public void read(){
        opCodeInterpreter.readNext(address);
    }

    public String toString(){
        return opCodeInterpreter.toString();
    }
}
