import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenTest {

    int MIN = 372304;
    int MAX = 847060;

    // digit 1 - 3-8
    // digits 2-6 - 3-9

    int[] pass = new int[6];
    int total = 0;

    @Test
    public void genPass(){
        int min = 3;
        pass = new int[] {3,7,2,3,0,5};
        for (int i = min; i < 10; i++){
            if (!inRange()) { break;}
            genNext(0,min);
        }
        System.out.println("TOTAL : " + total);
    }

    void genNext(int index, int min){
        if (index == 6){ return;}
        for (int i = min; i < 10; i++){
            pass[index] = i;
            min = i;
            if (index == 5){
                if (isValid()){
                    total ++;
                    System.out.println(toString());
                }
            }
            else{genNext(index+1, min);}
        }
    }

    @Test
    public void extraDoubleTest(){
        pass = new int[]{1,1,2,2,3,3};
        assertTrue(extraDouble());

        pass = new int[]{1,2,3,4,4,4};
        assertFalse(extraDouble());

        pass = new int[]{1,1,1,1,2,2};
        assertTrue(extraDouble());

        pass = new int[]{1,1,2,2,2,2};
        assertTrue(extraDouble());

        pass = new int[]{7,7,7,7,7,7};
        assertFalse(extraDouble());
    }


    @Test
    public void doubleTest(){
        pass = new int[]{1,1,2,3,4,5};
        assertTrue(containsDouble());

        pass = new int[]{1,0,2,3,3,5};
        assertTrue(containsDouble());

        pass = new int[]{1,6,2,3,4,5};
        assertFalse(containsDouble());
    }

    @Test
    public void increasingTest(){
        pass = new int[]{1,1,2,3,4,5};
        assertTrue(increasing());

        pass = new int[]{1,0,2,3,3,5};
        assertFalse(this::increasing);

        pass = new int[]{1,6,2,3,4,5};
        assertFalse(increasing());
    }

    @Test
    public void inRangeTest(){
        pass = new int[]{1,1,2,3,4,5};
        assertFalse(inRange());

        pass = new int[]{9,9,9,9,9,9};
        assertFalse(inRange());

        pass = new int[]{5,5,5,5,5,5};
        assertTrue(inRange());
    }


    boolean containsDouble(){
        for (int i = 0; i<pass.length -1; i++){
            if (pass[i] == pass[i+1]){ return true;}
        }
        return false;
    }

    boolean extraDouble(){
        boolean d = false;
        for (int i = 0; i<pass.length -1; i++){
            if (pass[i] == pass[i+1] ){
                if (i+2 >= pass.length || pass[i] != pass[i+2]) {
                    d = true;
                    return d;
                }
                int j = i;
////                while (j < pass.length) {
//                    if (pass[i] != pass[j]) {
//                        break;
//                    }
//                    j++;
//                }

                while (i < pass.length && pass[i] == pass[j]) {
                    i++;
                }

                i--;
//                i++;
            }
        }
        return d;
    }

    boolean increasing(){
        for (int i = 0; i<pass.length -1; i++){
            if (pass[i] > pass[i+1]){ return false;}
        }
        return true;
    }

    boolean inRange(){
        int result = convertToInt();
        if (result < MIN || result > MAX){ return false;}
        return true;
    }

    int convertToInt(){
        int res =0;
        for (int i = 0; i<pass.length; i++){
            res += pass[i]*Math.pow(10,(5-i));
        }
        return res;
    }

    boolean isValid(){
        return increasing() && inRange() && extraDouble();
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < pass.length; i++){
            builder.append(pass[i]);
        }
        return builder.toString();
    }
}
