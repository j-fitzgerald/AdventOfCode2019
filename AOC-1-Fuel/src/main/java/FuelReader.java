import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FuelReader {

    public static void main(String[] args) {

        FuelReader reader = new FuelReader();
        reader.readFromFile();
    }

    String path="src/main/resources/fuelData";
    double divisor = 3.0;
    int subtractBy = 2;

    public FuelReader(){}

    public void readFromFile(){
        // Read a fuel level
        try(Stream<String> asStream = Files.lines(Paths.get(path))){
            double finalTotal = asStream
                .map(fuel -> fuelReader(Double.valueOf(fuel)))
                .reduce(0d, (total, fuel) -> fuel + total);
            System.out.println(finalTotal);
        }
        catch (IOException e){
            System.out.println("file not found");
        }

    }

    /**
     * Recursive call, fuel costs have fuel costs, have fuel costs
     * if fuel mass is below 9 then its cost is 0 and can be skipped
     * @param val
     * @return
     */
    public double fuelReader(double val){
        double cost = (Math.floor(val / divisor));
        cost -= subtractBy;
        if (cost < 9) { return cost; }
        else { return cost + fuelReader(cost); }
    }

}
