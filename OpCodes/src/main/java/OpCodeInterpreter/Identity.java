package OpCodeInterpreter;

public class Identity implements OpCodeInterpreter{
    int index;
    String myString = "";
    public Identity(int index){
        this.index = index;
    }
    @Override
    public void readNext(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Identity operation index: " + index;
    }
}
