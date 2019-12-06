package IntCodesInterpreter.Operations;

import IntCodesInterpreter.Operations.OperationModes.Modes;
import Memory.MemCodes;

public class PushOp implements Operations {

    Operations noun;
    Operations inputOp;
    Operations destination;
    int output;
    int source;
    int destinationAddress = -1; //?

    /**
     * Push an input to the specified address
     * @param address
     */
    public PushOp(int address){
        source = MemCodes.opsList[MemCodes.opsList[address+1].getValue()].getValue();
        inputOp = MemCodes.opsList[MemCodes.opsList[address+1].getValue()];
//        noun = MemCodes.opsList[destinationAddress];
        noun = new IdentityOp(inputOp.getValue());
        MemCodes.output = noun;
//        output = MemCodes.opsList[destinationAddress].getValue();
    }

    public PushOp(int address, Operations noun, Operations destination){
        this.noun = noun;
        this.destination = destination;
//        source = MemCodes.opsList[MemCodes.opsList[address+1].getValue()].getValue();
//        inputOp = MemCodes.opsList[MemCodes.opsList[address+1].getValue()];
//        noun = MemCodes.opsList[destinationAddress];
//        noun = new IdentityOp(inputOp.getValue());
//        MemCodes.output = noun;
//        output = MemCodes.opsList[destinationAddress].getValue();
    }

    @Override
    public void read() {
//        noun = inputOp;
//        MemCodes.output = noun;
        destination = noun;
    }

    @Override
    public int getValue() {
        return output;
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
