package IntCodesInterpreter.Operations;
import IntCodesInterpreter.Operations.OperationModes.ImmediateMode;
import IntCodesInterpreter.Operations.OperationModes.Modes;
import Memory.MemCodes;

public class IdentityOp implements Operations{
    int address;
    int value;
    String valString;

    public IdentityOp(int value){
        this.address = -1;
        this.value = value;
//        this.value = MemCodes.asInt[address];
        valString = String.valueOf(value);
    }

    public IdentityOp(int address, int value){
        this.address = address;
//        this.value = value;
        this.value = MemCodes.asInt[address];
        valString = String.valueOf(value);
    }

    @Override
    public String toString() {
        return ("" + address);
    }

    @Override
    public void read() {

    }

    public int getValue(){
        return value;
    }

    public String valString(){
        return valString;
    }

    public int advance(){
        return 1;
    }

    Modes mode = new ImmediateMode();
    @Override
    public void setMode(Modes mode){
        this.mode = mode;
    }

    public int deReference(){
        return mode.deReference(getValue());
    }
}
