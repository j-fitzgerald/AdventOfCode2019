package Operations;

import Memory.Memory;

public class IdentityOp implements Operations{
    int address;
    int value;
    String valString;

    public IdentityOp(int address, int value){
        this.address = address;
//        this.value = value;
        this.value = Memory.asInt[address];
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
}
