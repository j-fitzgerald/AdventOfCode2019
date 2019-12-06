package IntCodesInterpreter.Operations;
import IntCodesInterpreter.Operations.OperationModes.Modes;
import IntCodesInterpreter.Operations.OperationModes.OperationModes;
import Memory.MemCodes;

public class AddOp implements  Operations {

    int address;
    Operations noun;
    Operations verb;
    Operations destination;
    int sum;
    String myString = "";
    String valString = "";

    public AddOp(int address){
        this.address = address;
        noun = MemCodes.opsList[address + 1];
        verb = MemCodes.opsList[address + 2];
    }

    public AddOp(int address, Operations noun, Operations verb, Operations destination){
        this.address = address;
        this.noun = noun;
        this.verb = verb;
        this.destination = destination;

    }

    @Override
    public void read() {
//        this.sum = MemCodes.opsList[MemCodes.opsList[address + 1].getValue()].getValue() + MemCodes.opsList[MemCodes.opsList[address + 2].getValue()].getValue();
//        this.sum = MemCodes.opsList[OperationModes.currentMode.deReference(address+1)].getValue() + MemCodes.opsList[OperationModes.currentMode.deReference(address+2)].getValue();
////        MemCodes.opsList[MemCodes.opsList[address + 3].getValue()] = this;
//        MemCodes.opsList[OperationModes.currentMode.deReference(address + 3)] = this;
//        myString = "Sum of addresses " + noun.toString() + " + " + verb.toString();
//        valString = MemCodes.opsList[noun.getValue()].valString() + " + " + MemCodes.opsList[verb.getValue()].valString();

        this.sum = MemCodes.opsList[MemCodes.opsList[noun.deReference()].getValue()].getValue() + MemCodes.opsList[MemCodes.opsList[verb.deReference()].getValue()].getValue();
        MemCodes.opsList[destination.deReference()] = this;
        myString = "Sum of addresses " + noun.toString() + " + " + verb.toString();
        valString = MemCodes.opsList[noun.getValue()].valString() + " + " + MemCodes.opsList[verb.getValue()].valString();
    }

    @Override
    public String toString() {
        return "(" + myString + ")";
    }

    public int getValue(){
        return sum;
    }

    public String valString(){
        return valString;
    }

    public int advance(){
        return 4;
    }

    Modes mode;
    @Override
    public void setMode(Modes mode){
        this.mode = mode;
    }

    /**
     * In IMMEDIATE mode - gets the value in that index
     * in POSITION mode - gets the value that the index is pointing to
     * @return
     */
    public int deReference(){
        return mode.deReference(getValue());
    }
}
