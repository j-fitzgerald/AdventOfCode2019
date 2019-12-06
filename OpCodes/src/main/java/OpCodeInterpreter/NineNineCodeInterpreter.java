package OpCodeInterpreter;

import java.util.List;

public class NineNineCodeInterpreter implements OpCodeInterpreter {
    @Override
    public void readNext(int index) {
        System.out.println("99 encountered, stop");
    }
}
