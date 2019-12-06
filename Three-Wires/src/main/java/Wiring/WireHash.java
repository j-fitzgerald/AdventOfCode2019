package Wiring;

import java.awt.*;
import java.util.HashMap;

public class WireHash {

    HashMap<Point, StepCounter> asMap = new HashMap<Point, StepCounter>();

    Point point =  new Point();
    static final int SIZE = 30000;
    public short steps = 0;

    public WireHash(){
        point.x = SIZE / 2 ;
        point.y = SIZE / 2;
    }

    public void moveRight(int dist){
        while (dist > 0) {
            steps ++;
            point.x += 1;
            StepCounter x = asMap.get(point);
            if (x == null){
                asMap.put(point, new StepCounter(steps, (short)0));
            }
            if (asMap.get(point).steps != 0){
                asMap.put(point, new StepCounter(steps, (short)0));
            }
            dist --;
        }
    }

    public void moveLeft(int dist) {
        while (dist > 0) {
            while (dist > 0) {
                steps++;
                point.x -= 1;
                StepCounter x = asMap.get(point);
                if (x == null){
                    asMap.put(point, new StepCounter(steps, (short)1));
                }
                if (asMap.get(point).steps != 0){
                    asMap.put(point, new StepCounter(steps, (short)1));
                }

                dist--;
            }
        }
    }

    public void moveUp(int dist){
            while (dist > 0) {
                steps ++;
                point.y += 1;
                StepCounter x = asMap.get(point);
                if (x == null){
                    asMap.put(point, new StepCounter(steps, (short)2));
                }
                if (asMap.get(point).steps != 0){
                    asMap.put(point, new StepCounter(steps, (short)2));
                }

                dist --;
            }
    }

    public void moveDown(int dist) {
        while (dist > 0) {
            steps++;
            point.y -= 1;
            StepCounter x = asMap.get(point);
            if (x == null){
                asMap.put(point, new StepCounter(steps, (short)3));
            }
            if (asMap.get(point).steps != 0){
                asMap.put(point, new StepCounter(steps, (short)3));
            }
            dist--;
        }
    }
}
