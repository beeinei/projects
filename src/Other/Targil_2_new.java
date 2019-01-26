package Other;
import java.awt.Point;
import java.util.Scanner;

import unit4.turtleLib.*;

public class Targil_2_new {

   /*
   public static boolean outOfBounds(Turtle t, Point p){
        if (p.getX()>(t.getScreenWidth()-1) || p.getX()<((t.getScreenWidth()-1)*(-1))){
            return true;
        }
        else if (p.getY()>(t.getScreenHeight()-1)){
            return true;
        }
        else {
            return false;
        }
    }
    */

    public static void move(Turtle t, Point p)
    {
        double deltaX = p.getX()-t.getXLocation();
        double deltaY = p.getY()-t.getYLocation();
        double heading = t.getHeading();
        //double incline = deltaY/deltaX;
        double steps = Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
        t.turnRight(heading);
        if ((deltaX!=0) && (deltaY!=0)) {
            t.turnLeft((Math.toDegrees(Math.atan2(deltaY, deltaX))) - 90.0);
            t.moveForward(steps);
        } else if (deltaX == 0 && deltaY != 0) {
            t.moveForward(deltaY);
        } else if (deltaX != 0 && deltaY == 0) {
            t.turnRight(90.0);
            t.moveForward(deltaX);
        }
    }

    public static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        Turtle t = new Turtle();
        System.out.println("Trtl loc: x=" + t.getXLocation() + " y=" + t.getYLocation());

        Point p = new Point(100000, 100000);
        //while (outOfBounds(t,p)) {p.setLocation((int)(Math.random()*t.getScreenWidth()), (int)(Math.random()*t.getScreenHeight()));}

        t.tailDown();
        System.out.println("Point loc: x=" + p.getX() + " y=" + p.getY());
        move(t,p);
        System.out.println("Trtl loc: x=" + t.getXLocation() + " y=" + t.getYLocation());
    }
}
