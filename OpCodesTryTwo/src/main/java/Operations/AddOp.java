package Operations;

import Memory.Memory;

public class AddOp implements  Operations {

    int address;
    Operations noun;
    Operations verb;
    int sum;
    String myString = "";
    String valString = "";

    public AddOp(int address){
        this.address = address;
        noun = Memory.opsList[address + 1];
        verb = Memory.opsList[address + 2];
    }

    @Override
    public void read() {
        this.sum = Memory.opsList[Memory.opsList[address + 1].getValue()].getValue() + Memory.opsList[Memory.opsList[address + 2].getValue()].getValue();
        Memory.opsList[Memory.opsList[address + 3].getValue()] = this;
        myString = "Sum of addresses " + noun.toString() + " + " + verb.toString();
        valString = Memory.opsList[noun.getValue()].valString() + " + " + Memory.opsList[verb.getValue()].valString();
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
}
