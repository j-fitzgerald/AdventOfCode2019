package IntCodesInterpreter.Operations;

import IntCodesInterpreter.Operations.OperationModes.Modes;
import IntCodesInterpreter.Operations.OperationModes.OperationModes;
import Memory.MemCodes;

public class PullOp implements Operations {
    Operations noun;
    int input;
    Operations destination;
    int inputAdd = 0; //?
    int dest;

    /**
     * Pull an input to the specified address
     * @param address
     */
    public PullOp(int address){
        dest = MemCodes.opsList[address+1].getValue();
//        noun = MemCodes.opsList[inputAdd];
//        input = MemCodes.opsList[inputAdd].getValue();
        noun = MemCodes.input;
        input = noun.getValue();
    }

    public PullOp(int address, Operations noun, Operations destination){
        this.destination = destination;
//        noun = MemCodes.opsList[inputAdd];
//        input = MemCodes.opsList[inputAdd].getValue();
        this.noun = noun;
        input = noun.getValue();
    }


    @Override
    public void read() {
        destination = noun;
    }

    @Override
    public int getValue() {
        return input;
    }

    @Override
    public String valString() {
        return null;
    }

    public int advance(){
        return 2;
    }

    Modes mode;
    @Override
    public void setMode(Modes mode){
        this.mode = mode;
    }

    public int deReference(){
        return mode.deReference(getValue());
    }
}
