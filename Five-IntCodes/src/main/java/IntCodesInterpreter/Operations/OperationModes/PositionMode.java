package IntCodesInterpreter.Operations.OperationModes;

import Memory.MemCodes;

public class PositionMode implements Modes{


    @Override
    public int deReference(int val) {
        return MemCodes.opsList[val].getValue();
    }
}
