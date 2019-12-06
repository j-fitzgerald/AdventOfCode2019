package IntCodesInterpreter.Operations;
import IntCodesInterpreter.Operations.OperationModes.Modes;
import IntCodesInterpreter.Operations.OperationModes.OperationModes;
import Memory.MemCodes;

public class MultOp implements Operations {

    int address;
    Operations noun;
    Operations verb;
    Operations destination;
    int product;
    String myString;
    String valString;

    public MultOp(int address){
        this.address = address;
        noun = MemCodes.opsList[address + 1];
        verb = MemCodes.opsList[address + 2];
    }

    public MultOp(int address, Operations noun, Operations verb, Operations destination){
        this.address = address;
        this.noun = noun;
        this.verb = verb;
        this.destination = destination;
    }

    @Override
    public void read() {
//        this.sum = MemCodes.opsList[MemCodes.opsList[address + 1].getValue()].getValue() + MemCodes.opsList[MemCodes.opsList[address + 2].getValue()].getValue();
//        this.product = MemCodes.opsList[OperationModes.currentMode.deReference(address+1)].getValue() * MemCodes.opsList[OperationModes.currentMode.deReference(address+2)].getValue();
////        MemCodes.opsList[MemCodes.opsList[address + 3].getValue()] = this;
//        MemCodes.opsList[OperationModes.currentMode.deReference(address + 3)] = this;
//        myString = "Product of addresses " + noun.toString() + " * " + verb.toString();
//        valString = MemCodes.opsList[noun.getValue()].valString() + " + " + MemCodes.opsList[verb.getValue()].valString();
//

        this.product = MemCodes.opsList[noun.deReference()].getValue() * MemCodes.opsList[verb.deReference()].getValue();
        MemCodes.opsList[destination.deReference()] = this;
        myString = "Sum of addresses " + noun.toString() + " + " + verb.toString();
        valString = MemCodes.opsList[noun.getValue()].valString() + " + " + MemCodes.opsList[verb.getValue()].valString();
    }

    @Override
    public String toString() {
        return "(" + myString + ")";
    }

    public int getValue(){
        return product;
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

    public int deReference(){
        return mode.deReference(getValue());
    }
}

