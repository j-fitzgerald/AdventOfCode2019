import IntCodesInterpreter.Operations.Operations;
import Memory.MemCodes;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpsTests {

    MemCodes mem = new MemCodes();
    
    String oc = "1,2,3,4,99";
    int[] ocInt = new int[]{1,0,0,0,99};

    @Before
    public void setUp(){

    }

    @Test
    public void testCode(){
        mem.makeMemory(ocInt);
        mem.makeOpsParsed();
        assertTrue(equal(new int[]{2,0,0,0,99},(MemCodes.opsList)));
    }

    @Test
    public void testCodeTwo(){
        mem.makeMemory(new int[]{2,3,0,3,99});
        mem.makeOps();
        assertTrue(equal(new int[]{2,3,0,6,99},(MemCodes.opsList)));
    }

    @Test
    public void testCodeThree(){
        mem.makeMemory(new int[]{2,4,4,5,99,0});
        mem.makeOps();
        assertTrue(equal(new int[]{2,4,4,5,99,9801}, (MemCodes.opsList)));
    }

    @Test
    public void testCodeFour(){
        mem.makeMemory(new int[]{1,1,1,4,99,5,6,0,99});
        mem.makeOps();
        assertTrue(equal(new int[]{30,1,1,4,2,5,6,0,99}, (MemCodes.opsList)));

    }

    @Test
    public void testCodeFive(){
        mem.makeMemory(new int[]{1,9,10,3,2,3,11,0,99,30,40,50});
        mem.makeOps();
        assertTrue(equal(new int[]{3500,9,10,70,
                2,3,11,0,
                99,
                30,40,50}, (MemCodes.opsList)));
        System.out.println(MemCodes.opsList[0].toString());
    }


    @Test
    public void testCode6(){
        mem.makeMemory(new int[]{1,1,1,5,2,5,3,0,99});
        mem.makeOps();
        assertTrue(equal(new int[]{5,1,1,5,2,2,3,0,99}, (MemCodes.opsList)));
        System.out.println(MemCodes.opsList[0].toString());
    }


    String alarmCode = "1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,19,1,19,10,23,2,13,23,27,1,5,27,31,2,6,31,35,1,6,35,39,2,39,9,43,1,5,43,47,1,13,47,51,1,10,51,55,2,55,10,59,2,10,59,63,1,9,63,67,2,67,13,71,1,71,6,75,2,6,75,79,1,5,79,83,2,83,9,87,1,6,87,91,2,91,6,95,1,95,6,99,2,99,13,103,1,6,103,107,1,2,107,111,1,111,9,0,99,2,14,0,0";

    @Test
    public void testCodeAlarm(){
        mem.makeMemory(new int[]{1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,19,1,19,10,23,2,13,23,27,1,5,27,31,2,6,31,35,1,6,35,39,2,39,9,43,1,5,43,47,1,13,47,51,1,10,51,55,2,55,10,59,2,10,59,63,1,9,63,67,2,67,13,71,1,71,6,75,2,6,75,79,1,5,79,83,2,83,9,87,1,6,87,91,2,91,6,95,1,95,6,99,2,99,13,103,1,6,103,107,1,2,107,111,1,111,9,0,99,2,14,0,0});
        try {
            mem.makeOps();
        }
        catch(Exception e) {
            System.out.println("Expect Alarm + state0-- " + MemCodes.opsList[0]);
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("No Alarm " + MemCodes.opsList[0]);
        System.out.println("No Alarm " + MemCodes.opsList[0].valString());

    }

    @Test
    public void testCodeAlarmX(){
        mem.makeMemory(new int[]{1,66,35,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,19,1,19,10,23,2,13,23,27,1,5,27,31,2,6,31,35,1,6,35,39,2,39,9,43,1,5,43,47,1,13,47,51,1,10,51,55,2,55,10,59,2,10,59,63,1,9,63,67,2,67,13,71,1,71,6,75,2,6,75,79,1,5,79,83,2,83,9,87,1,6,87,91,2,91,6,95,1,95,6,99,2,99,13,103,1,6,103,107,1,2,107,111,1,111,9,0,99,2,14,0,0});
        try {
            mem.makeOps();
        }
        catch(Exception e) {
            System.out.println("Expect Alarm + state0-- " + MemCodes.opsList[0]);
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("No Alarm " + MemCodes.opsList[0]);
        assertEquals(19690720, MemCodes.opsList[0].getValue());

    }

    @Test
    public void testCodeZZZ(){
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {

                mem.makeMemory(new int[]{1, i, j, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 6, 1, 19, 1, 19, 10, 23, 2, 13, 23, 27, 1, 5, 27, 31, 2, 6, 31, 35, 1, 6, 35, 39, 2, 39, 9, 43, 1, 5, 43, 47, 1, 13, 47, 51, 1, 10, 51, 55, 2, 55, 10, 59, 2, 10, 59, 63, 1, 9, 63, 67, 2, 67, 13, 71, 1, 71, 6, 75, 2, 6, 75, 79, 1, 5, 79, 83, 2, 83, 9, 87, 1, 6, 87, 91, 2, 91, 6, 95, 1, 95, 6, 99, 2, 99, 13, 103, 1, 6, 103, 107, 1, 2, 107, 111, 1, 111, 9, 0, 99, 2, 14, 0, 0});
                try {
                    mem.makeOps();
                    if (MemCodes.opsList[0].getValue() == 19690720){
                        System.out.println(i + "\t" + j);
//                        fail();
                        System.out.println(i*100 + j + ":\t\t" + MemCodes.opsList[0].toString());
                    }
                } catch (Exception e) {

                }
//                System.out.println(i*100 + j + ":\t\t" + MemCodes.opsList[0].toString());
            }
        }

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

    public boolean equal(int[] expected, Operations[] actual){
        if (expected.length != actual.length) return false;
        for (int i =0; i < expected.length; i++){
            if (expected[i] != actual[i].getValue()){
                System.out.println("Index " + i + " is incorrect + " + expected[i] + " " + actual[i].getValue());
                return false;
            }
        }
        return  true;
    }
}
