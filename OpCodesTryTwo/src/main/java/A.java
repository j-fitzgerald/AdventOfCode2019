import Memory.Memory;

public class A {
    public static void main(String[] args) {
        Memory mem = new Memory();
        int[] opCode = new int[]{1,1,1,4,99,5,6,0,99};
        mem.makeMemory(opCode);
        mem.makeOps();
    }
}
