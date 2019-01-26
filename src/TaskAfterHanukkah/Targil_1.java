package TaskAfterHanukkah;
import unit4.turtleLib.Turtle;

import java.util.Scanner;

public class Targil_1 {

    public static void createShape(Turtle t, int tz, int ltz){
        double angle = 180*(1-(2/tz));
        t.turnRight(90);
        for(int i = tz; i!=0; i--){
            t.moveForward(ltz);
            t.turnLeft(180-angle);
        }
        System.out.println("Shape created");
    }

    public static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        Turtle t = new Turtle();
        t.tailDown();
        System.out.println("insert num and length of tz (in integers)");
        createShape(t,reader.nextInt(),reader.nextInt());
    }

}
