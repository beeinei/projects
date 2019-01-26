package TaskAfterHanukkah;
import unit4.turtleLib.Turtle;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Targil_2 {

    public static void moveTo(Turtle t, Point p) {
        double deltaX = p.getX() - t.getXLocation();
        double deltaY = p.getY() - t.getYLocation();
        double tHeading = t.getHeading();
        double steps = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
        t.turnRight(tHeading);
        if (deltaX != 0 && deltaY != 0) {
                t.turnLeft(Math.toDegrees(Math.atan2(deltaY, deltaX)) - 90.0);
                System.out.println(t.getHeading() + "  " + Math.toDegrees(Math.atan2(deltaY, deltaX)));
            t.moveForward(steps);
        } else if (deltaX == 0 && deltaY != 0) {
            t.moveForward(deltaY);
        } else if (deltaX != 0 && deltaY == 0) {
            t.turnRight(90.0);
            t.moveForward(deltaY);
        }
    }

    public static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        Turtle t = new Turtle();
        t.tailDown();
        Point pZero = new Point(0,0);
        int count = 0;
        String sInit = "How many points would you like to have?";
        String sError = "Oops! too much. Try again!";
        Color[] colors = new Color[]{Color.red, Color.pink, Color.orange, Color.yellow, Color.green, Color.cyan, Color.blue, Color.magenta};
        System.out.println(sInit);
        Point[] points = new Point[reader.nextInt()];
        if(points.length<=0){
            System.out.println(sError);
        }
        for (int i = 0; i < points.length - 1; i++) {
            points[i] = new Point((int)(Math.random()*t.getScreenWidth()),(int)(Math.random()*t.getScreenHeight()));
        }
        moveTo(t, pZero);
        for (int i = 0; i < points.length - 1; i++) {
            t.setTailColor(colors[count]);
            moveTo(t, points[i + 1]);
            if (count < 4) {
                count++;
            } else {
                count = 0;
            }
        }
        moveTo(t, points[0]);
        /*
        System.out.println("How many points would you like to have?");
        Point[] points = new Point[reader.nextInt()];
        for (int i = 0; i<points.length; i++){
            //points[i]=new Point();
        }
        */

        System.out.println("Height= " + t.getScreenHeight());
        System.out.println("Width= " + t.getScreenWidth());

    }

}


        /*
        System.out.println("How many points would you like to have?");
        int input = reader.nextInt();
        Point[] points = new Point[input];
        for (int i = 0; i < points.length; i++) {
        points[i] = new Point((int)(Math.random()*10), (int)(Math.random()*10));
        }
        //System.out.println(Arrays.toString(points));
        Turtle t = new Turtle();
        t.setVisible(true);
        t.tailDown();
        double m = (points[0].getX()-t.getXLocation())/(points[0].getY()-t.getYLocation());
        t.turnRight(Math.atan(m));
        double deltaX=points[0].getX()-t.getXLocation();
        System.out.println(deltaX);
        double deltaY=points[0].getY()-t.getYLocation();
        System.out.println(deltaY);
        double stepsSqrd = Math.pow(deltaX, 2) + Math.pow(deltaY, 2);
        System.out.println(stepsSqrd);
        System.out.println("Trtl loc: x=" + t.getXLocation() + " y=" + t.getYLocation());
        t.moveForward(Math.sqrt(stepsSqrd));
        System.out.println("Trtl loc: x=" + t.getXLocation() + " y=" + t.getYLocation());
        /*
        for(int i = 1; i<points.length; i++){
            m = (points[i].getX()-t.getXLocation())/(points[i].getY()-t.getYLocation());
            t.turnRight(Math.atan(m));
            System.out.println("Trtl loc: x=" + t.getXLocation() + " y=" + t.getYLocation());
        }
        */
