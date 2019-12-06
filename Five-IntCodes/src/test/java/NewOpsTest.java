import IntCodesInterpreter.Operations.IdentityOp;
import Memory.MemCodes;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class NewOpsTest {

    @Test
    public void ioTest(){
        IdentityOp i = new IdentityOp( 55);
        MemCodes.input = i;
        int[] asInt = new int[]{3,0,4,0,99};
        MemCodes mem = new MemCodes();
        mem.makeMemory(asInt);
        mem.makeOps();
        assertEquals(55, MemCodes.output.getValue());
    }
}
