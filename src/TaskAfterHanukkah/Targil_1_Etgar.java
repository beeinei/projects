package TaskAfterHanukkah;

import unit4.turtleLib.Turtle;

import java.util.Scanner;

public class Targil_1_Etgar {

    public static Scanner reader = new Scanner(System.in);
    public static void metzulaMeshuchlal(Turtle t, int tz, double length) {
        String sInit = "How many points would you like to have?";
        String sError = "Oops! too much. Try again!";
        //--
        //System.out.println(sInit);
        double rAngle = Math.sqrt(length * length / (2 - Math.cos((180 * (tz - 2) / tz))));
        while (rAngle > t.getScreenHeight()) {
            System.out.println(sError);
            double a = reader.nextDouble();
            if (a == -1) {
                //init
                System.out.println(sInit);
                tz = reader.nextInt();
                length = reader.nextDouble();
                rAngle = Math.sqrt(length * length / (2 - Math.cos((180 * (tz - 2) / tz))));

            } else {
                length = a;
                rAngle = Math.sqrt(length * length / (2 - Math.cos((180 * (tz - 2) / tz))));
            }
        }
        Turtle a = new Turtle();
        a.tailUp();
        a.turnLeft(90);
        double deg = Math.toDegrees(rAngle);
        //System.out.println("rAngle = " + rAngle);
        System.out.println("Metzula Meshuchlal with " + tz + " sides!");

        //return
        a.moveForward(rAngle);
        a.turnRight(90);
        a.turnRight(90.0 - (deg / 2));
        a.tailDown();
        for (int i = 0; i < tz; i++) {
            a.moveForward(length);
            a.turnRight(180.0 - deg);
        }
    }

    public static void main(String[] args) {
        Turtle t = new Turtle();
        System.out.println("Enter numOfSides and Length");
        metzulaMeshuchlal(t,reader.nextInt(),reader.nextDouble());
    }

}
