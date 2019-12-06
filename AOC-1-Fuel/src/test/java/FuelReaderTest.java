import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FuelReaderTest {
    FuelReader fr = new FuelReader();

    @Test
    public void testValue(){
        String val = "1969";
        double total = fr.fuelReader(Double.valueOf(val));
        System.out.println(total);
        assertEquals(966L, total);

        val = "100756";
        total = fr.fuelReader(Double.valueOf(val));
        assertEquals(50346L, total);
    }
}
