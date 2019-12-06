package Memory;

import IntCodesInterpreter.Operations.AddOp;
import IntCodesInterpreter.Operations.MultOp;
import IntCodesInterpreter.Operations.OperationModes.ImmediateMode;
import IntCodesInterpreter.Operations.OperationModes.Modes;
import IntCodesInterpreter.Operations.OperationModes.OperationModes;
import IntCodesInterpreter.Operations.OperationModes.PositionMode;
import IntCodesInterpreter.Operations.Operations;
import IntCodesInterpreter.Operations.PullOp;
import IntCodesInterpreter.Operations.PushOp;

public class ParseCode {

    static int pointer = 0;

    public static void parse(int address, int[] input){
        while(pointer < input.length) {
            String asString = String.valueOf(input[pointer] + 100000); // + 10000 guarantees all OpCode Modes are filled rather than dealing with lengths
            String modeCodes = asString.substring(0, asString.length() - 2);
            Operations[] op = makeOp(address, input, modeCodes);
        }
    }

    private static Operations[] makeOp(int address, int[] input, String modeCodes){
        int i = input[pointer] % 100; // get the first 2 digits for the opCode
        Operations[] result = null;
        switch(i) {
            case (1):
                result = new Operations[4];
                Operations noun = MemCodes.opsList[pointer + 1];
                noun.setMode(determineMode(modeCodes.charAt(3)));
                Operations verb = MemCodes.opsList[pointer + 2];
                verb.setMode(determineMode(modeCodes.charAt(2)));
                Operations destination = MemCodes.opsList[pointer + 3];
                destination.setMode(determineMode(modeCodes.charAt(1)));
                result[0] = new AddOp(address, noun, verb, destination);
                result[0].read();
                break;
            case(2):
                result = new Operations[4];
                noun = MemCodes.opsList[pointer + 1];
                noun.setMode(determineMode(modeCodes.charAt(3)));
                verb = MemCodes.opsList[pointer + 2];
                verb.setMode(determineMode(modeCodes.charAt(2)));
                destination = MemCodes.opsList[pointer + 3];
                destination.setMode(determineMode(modeCodes.charAt(1)));
                result[0] = new MultOp(address, noun, verb, destination);
                result[0].read();
                break;
            case(3):
                result = new Operations[2];
                destination = MemCodes.opsList[pointer + 1];
                noun = MemCodes.input;
                result[0] = new PullOp(address, noun, destination);
                break;
            case(4):
                result = new Operations[2];
                destination = MemCodes.output;
                noun = MemCodes.opsList[pointer + 1];
                result[0] = new PushOp(address, noun, destination);
                break;
            case(99):
                pointer = input.length;
                return null;
            default:
                System.out.println("Warning, invalid code: " + i);
        }
        pointer += result[0].advance();
        return result;
    }

    static Modes determineMode(int i){
        if (i == 1){
            return new ImmediateMode();
        }
        else
            return new PositionMode();
    }
}
