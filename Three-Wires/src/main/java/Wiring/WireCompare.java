package Wiring;


import java.awt.*;

public class WireCompare {
    Wire wire1;
    Wire wire2;
    public WireCompare(Wire wire1, Wire wire2){
        this.wire1 = wire1;
        this.wire2 = wire2;
    }

    static Point resultPoint = new Point();
/*
    public static int compare2d(Wire wire1, Wire wire2){
        int minDistance = 1000000;
        for (Point p : wire1.points){
            if (p.x == 50 && p.y == 50) {
                System.out.println("0,0 - skipping");
                continue; }
            if (wire2.as2d[p.x][p.y]){
//                System.out.println("Intersection at " + p.toString());
                int xDist = Math.abs(p.x - Wire.SIZE / 2 );
                int yDist = Math.abs(p.y - Wire.SIZE / 2);
                int totalDist = xDist + yDist;
                if (totalDist < minDistance){
                    minDistance = totalDist;
                    resultPoint = new Point(p);
                    System.out.println("new min distance " + minDistance);
                }
            }

        }
        return minDistance;
    }*/
    public static int compare2dSteps(Wire wire1, Wire wire2){
        int steps = 1000000;
        for (Point p : wire1.points){
//            if (p.x == Wire.SIZE / 2 && p.y == Wire.SIZE / 2) {
//                System.out.println("0,0 - skipping");
//                continue;
//            }
            if (wire2.as2d[p.x][p.y] == null) {
                continue;
            }
            if (wire2.as2d[p.x][p.y].steps != 0
                    && wire1.as2d[p.x][p.y].dir != wire2.as2d[p.x][p.y].dir) {
//                System.out.println("Intersection at " + p.toString());
                int totalSteps;
                totalSteps = wire1.as2d[p.x][p.y].steps + wire2.as2d[p.x][p.y].steps;
                if (totalSteps < steps) {
                    steps = totalSteps;
                    resultPoint = new Point(p);
                    System.out.println("new min steps " + steps);
                }
            }
        }
        return steps;
    }

    public static int compare2dHashSteps(WireHash wire1, WireHash wire2){
        int steps = 1000000;
        for (Point p : wire1.asMap.keySet()){
            if (p.x == Wire.SIZE / 2 && p.y == Wire.SIZE / 2) {
                System.out.println("0,0 - skipping");
                continue; }
            if (wire2.asMap.get(p).steps != 0
                    && wire1.asMap.get(p).dir != wire2.asMap.get(p).dir) {
                int totalSteps;
                totalSteps = wire1.asMap.get(p).steps + wire2.asMap.get(p).steps;
                if (totalSteps < steps){
                    steps = totalSteps;
                    resultPoint = new Point(p);
                    System.out.println("new min distance " + steps);
                }
            }

        }
        return steps;
    }

/*    public static int compare2dSteps(Wire wire1, Wire wire2){
        int steps = 1000000;
        for (Point p : wire1.points){
            if (p.x == Wire.SIZE / 2 && p.y == Wire.SIZE / 2) {
                System.out.println("0,0 - skipping");
                continue; }
            if (wire2.as2d[p.x][p.y] != 0){
//                System.out.println("Intersection at " + p.toString());
                int totalSteps;
                totalSteps = wire1.as2d[p.x][p.y] + wire2.as2d[p.x][p.y];
                if (totalSteps < steps){
                    steps = totalSteps;
                    resultPoint = new Point(p);
                    System.out.println("new min distance " + steps);
                }
            }

        }
        return steps;
    }*/
}
