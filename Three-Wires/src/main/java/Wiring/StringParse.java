package Wiring;

public class StringParse {
    public static  int STEPS = 500;

    static void getArr(String string, Wire w){
        String[] split = string.split(",");
        executeAll(split, w);
    }

    private static void executeAll(String[] s, Wire w){
        for (String command : s){
            if (w.steps > STEPS){
                return;}
            execute(command, w);
        }
    }

    private static void execute(String s, WireHash w){
        int dist = Integer.valueOf(s.substring(1));
        if (s.startsWith("R")){
            w.moveRight(dist);
        }
        else if (s.startsWith("L")){
            w.moveLeft(dist);
        }
        else if (s.startsWith("D")){
            w.moveDown(dist);
        }
        else if (s.startsWith("U")){
            w.moveUp(dist);
        }
        else
            System.out.println("INVALID COMMAND " + s);
    }

    static void getArr(String string, WireHash w){
        String[] split = string.split(",");
        executeAll(split, w);
    }

    private static void executeAll(String[] s, WireHash w){
        for (String command : s){
            execute(command, w);
        }
    }

    private static void execute(String s, Wire w){
        int dist = Integer.valueOf(s.substring(1));
        if (s.startsWith("R")){
            w.moveRight(dist);
        }
        else if (s.startsWith("L")){
            w.moveLeft(dist);
        }
        else if (s.startsWith("D")){
            w.moveDown(dist);
        }
        else if (s.startsWith("U")){
            w.moveUp(dist);
        }
        else
            System.out.println("INVALID COMMAND " + s);
    }
}
