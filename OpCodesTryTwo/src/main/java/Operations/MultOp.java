package Operations;
import Memory.Memory;
public class MultOp implements Operations {

    int address;
    Operations noun;
    Operations verb;
    int product;
    String myString;
    String valString;

    public MultOp(int address){
        this.address = address;
        noun = Memory.opsList[address + 1];
        verb = Memory.opsList[address + 2];
    }

    @Override
    public void read() {
        product = Memory.opsList[Memory.opsList[address + 1].getValue()].getValue() * Memory.opsList[Memory.opsList[address + 2].getValue()].getValue();
        Memory.opsList[Memory.opsList[address + 3].getValue()] = this;
        myString = "Product of addresses " + noun.toString() + " * " + verb.toString();
        valString = Memory.opsList[noun.getValue()].valString() + " + " + Memory.opsList[verb.getValue()].valString();
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
}
