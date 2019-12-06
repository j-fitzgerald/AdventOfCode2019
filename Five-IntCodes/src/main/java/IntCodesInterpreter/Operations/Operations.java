package IntCodesInterpreter.Operations;

import IntCodesInterpreter.Operations.OperationModes.Modes;

public interface Operations {

    void read();

    int getValue();

    String valString();

    int advance();

    void setMode(Modes mode);

    public int deReference();
}
