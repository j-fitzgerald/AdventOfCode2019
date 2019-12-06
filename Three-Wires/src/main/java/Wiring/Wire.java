package Wiring;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wire {

    Point point =  new Point();
    static final int SIZE = 20000;
    public short steps = 0;

    List<Point> points = new ArrayList<>();
    StepCounter[][] as2d = new StepCounter[SIZE][SIZE];
//    short[][] as2d = new short[SIZE][SIZE];

    public Wire(){
        point.x = SIZE / 2 ;
        point.y = SIZE / 2;

//        for(StepCounter[] row: as2d){
//            Arrays.fill(row, (short)0);
//        }
    }

    public void moveRight(int dist){
        while (dist > 0) {
            steps ++;
            point.x += 1;
            points.add(new Point(point));
            if (as2d[point.x][point.y] == null || as2d[point.x][point.y].steps == 0){
                as2d[point.x][point.y] = new StepCounter(steps, (short)0);
            }
            dist --;
        }

//        if (as2d[point.x][point.y] == 0){
//            as2d[point.x][point.y] = steps;
//        }

    }

    public void moveLeft(int dist){
        while (dist > 0) {
            steps ++;
            point.x -= 1;
            points.add(new Point(point));
            if (as2d[point.x][point.y] == null || as2d[point.x][point.y].steps == 0){
                as2d[point.x][point.y] = new StepCounter(steps, (short)1);
            }
//            if (as2d[point.x][point.y] == 0){
//                as2d[point.x][point.y] = steps;
//            }
            dist--;
        }
    }

    public void moveUp(int dist){
        while (dist > 0){
            steps ++;
            point.y += 1;
            points.add(new Point(point));
            if (as2d[point.x][point.y] == null || as2d[point.x][point.y].steps == 0){
                as2d[point.x][point.y] = new StepCounter(steps, (short)2);
            }
//            if (as2d[point.x][point.y] == 0){
//                as2d[point.x][point.y] = steps;
//            }
            dist--;
        }

    }

    public void moveDown(int dist){
        while(dist > 0){
            steps ++;
            point.y -= 1;
            points.add(new Point(point));
            if (as2d[point.x][point.y] == null || as2d[point.x][point.y].steps == 0){
                as2d[point.x][point.y] = new StepCounter(steps, (short)3);
            }
//            if (as2d[point.x][point.y] == 0){
//                as2d[point.x][point.y] = steps;
//            }
            dist--;
        }

    }
}
