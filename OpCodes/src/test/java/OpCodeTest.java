import OpCodeInterpreter.OpCode;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OpCodeTest {
    OpCode opCode = new OpCode();
    String oc = "1,2,3,4,99";
    int[] ocInt = new int[]{1,0,0,0,99};

    @Before
    public void setUp(){
        opCode.setOpCode(ocInt);
    }

    @Test
    public void testCode(){
        opCode.setOpCode(ocInt);
        opCode.readCode();
        assertTrue(equal(new int[]{2,0,0,0,99},(opCode.opCode)));
    }

    @Test
    public void testCodeTwo(){
        opCode.setOpCode(new int[]{2,3,0,3,99});
        opCode.readCode();
        assertTrue(equal(new int[]{2,3,0,6,99},(opCode.opCode)));
    }

    @Test
    public void testCodeThree(){
        opCode.setOpCode(new int[]{2,4,4,5,99,0});
        opCode.readCode();
        assertTrue(equal(new int[]{2,4,4,5,99,9801}, (opCode.opCode)));
    }

    @Test
    public void testCodeFour(){
        opCode.setOpCode(new int[]{1,1,1,4,99,5,6,0,99});
        opCode.readCode();
        assertTrue(equal(new int[]{30,1,1,4,2,5,6,0,99}, (opCode.opCode)));
    }

    @Test
    public void testCodeFive(){
        opCode.setOpCode(new int[]{1,9,10,3,2,3,11,0,99,30,40,50});
        opCode.readCode();
        assertTrue(equal(new int[]{3500,9,10,70,
                2,3,11,0,
                99,
                30,40,50}, (opCode.opCode)));
    }

    String alarmCode = "1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,19,1,19,10,23,2,13,23,27,1,5,27,31,2,6,31,35,1,6,35,39,2,39,9,43,1,5,43,47,1,13,47,51,1,10,51,55,2,55,10,59,2,10,59,63,1,9,63,67,2,67,13,71,1,71,6,75,2,6,75,79,1,5,79,83,2,83,9,87,1,6,87,91,2,91,6,95,1,95,6,99,2,99,13,103,1,6,103,107,1,2,107,111,1,111,9,0,99,2,14,0,0";

    @Test
    public void testCodeAlarm(){
        opCode.setOpCode(new int[]{1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,19,1,19,10,23,2,13,23,27,1,5,27,31,2,6,31,35,1,6,35,39,2,39,9,43,1,5,43,47,1,13,47,51,1,10,51,55,2,55,10,59,2,10,59,63,1,9,63,67,2,67,13,71,1,71,6,75,2,6,75,79,1,5,79,83,2,83,9,87,1,6,87,91,2,91,6,95,1,95,6,99,2,99,13,103,1,6,103,107,1,2,107,111,1,111,9,0,99,2,14,0,0});
        try {
            opCode.readCode();
        }
        catch(Exception e) {
            System.out.println("Expect Alarm + state0-- " + OpCode.opCode[0]);
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("No Alarm " + OpCode.opCode[0]);

    }
    @Test
    public void testCodeAlarmZ(){
        opCode.setOpCode(new int[]{1,66,35,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,19,1,19,10,23,2,13,23,27,1,5,27,31,2,6,31,35,1,6,35,39,2,39,9,43,1,5,43,47,1,13,47,51,1,10,51,55,2,55,10,59,2,10,59,63,1,9,63,67,2,67,13,71,1,71,6,75,2,6,75,79,1,5,79,83,2,83,9,87,1,6,87,91,2,91,6,95,1,95,6,99,2,99,13,103,1,6,103,107,1,2,107,111,1,111,9,0,99,2,14,0,0});
        try {
            opCode.readCode();
        }
        catch(Exception e) {

            return;
        }
        System.out.println("No Alarm " + OpCode.opCode[0]);
        System.out.println(OpCode.opCode[0]);

    }
    public boolean equal(int[] expected, int[] actual){
        if (expected.length != actual.length) return false;
        for (int i =0; i < expected.length; i++){
            if (expected[i] != actual[i]){
                System.out.println("Index " + i + " is incorrect + " + expected[i] + " " + actual[i]);
                return false;
            }
        }
        return  true;
    }
}
