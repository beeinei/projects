package Other;

import java.awt.Point;
import unit4.turtleLib.Turtle;

import java.util.Scanner;
import java.util.Random;
import java.awt.Color;

public class run {
    // *טיוטה חסרת משמעות
    public static double hight = 780;
    public static double width = 420;



    public static void main(String[] args) {
        //crazy(true);
        //shapeCreator(7,100);
        Point a = new Point(0,0);
        Point b = new Point(50,50);
        System.out.println(Math.toDegrees(dif(a,b)+90));
    }

    //tz = מספר הצלעות
    public static void shapeCreator(int tz, double length) {
        String start = " draw it! enter number of sides and length! ";
        System.out.println(start);
        String notGood = "thats too big! try again! for restart enter -1!";
        Scanner input = new Scanner(System.in);
        double rad = Math.sqrt(length * length / (2 - Math.cos((180 * (tz - 2) / tz))));
        while (rad > hight) {
            System.out.println(notGood);
            double a = input.nextDouble();
            if (a == -1) {
                System.out.println(start);
                tz = input.nextInt();
                length = input.nextDouble();
                rad = Math.sqrt(length * length / (2 - Math.cos((180 * (tz - 2) / tz))));

            } else {
                length = a;
                rad = Math.sqrt(length * length / (2 - Math.cos((180 * (tz - 2) / tz))));
            }
        }
        Turtle a = new Turtle();
        a.tailUp();
        a.turnLeft(90);
        double deg = (180.0 * (tz - 2)) / tz;
        System.out.println("the turtle created a shape with " + tz + " sides, and itd rad is " + rad);
        a.moveForward(rad);
        a.turnRight(90);
        a.turnRight(90.0 - (deg / 2));
        a.tailDown();
        for (int i = 0; i < tz; i++) {
            a.moveForward(length);
            a.turnRight(180.0 - deg);
        }
    }

    public static void aagoto(Turtle t, Point a) {
        double dx = a.getX() - t.getXLocation();
        double dy = a.getY() - t.getYLocation();
        double idi = t.getHeading();
        double leng = Math.sqrt(dx * dx + dy * dy);
        t.turnRight(idi);
        System.out.println(leng + "    " + t.getHeading());
        if (dx != 0 && dy != 0) {
            if (dx > 0) {
                t.turnLeft((57.29578 * Math.atan2(dy, dx)) - 90.0);
                System.out.println(t.getHeading() + "  " + (57.29578 * Math.atan2(dy, dx)));
            } else if (dx < 0) {
                t.turnLeft((57.29578 * Math.atan2(dy, dx)) - 90.0);
                System.out.println(t.getHeading() + "  " + (57.29578 * Math.atan2(dy, dx)));
            }
            t.moveForward(leng);
        } else if (dx == 0 && dy != 0) {
            t.moveForward(dy);
        } else if (dx != 0 && dy == 0) {
            t.turnRight(90.0);
            t.moveForward(dx);
        }

    }

    public static double dif(Point a, Point b) {
        double dx = b.getX() - a.getX();
        double dy = b.getY() - a.getY();
        double d = 0;
        if (dx != 0 && dy != 0) {
            if (dx > 0) {
                d = ((57.29578 * Math.atan2(dy, dx)) - 90.0);
            } else if (dx < 0) {
                d = ((57.29578 * Math.atan2(dy, dx)) - 90.0);
            }
        } else if (dx == 0 && dy != 0) {
            if(dy>0){
                d = 0;
            }
            else{
                d = 180;
            }
        } else if (dx != 0 && dy == 0) {
            if(dx>0){
                d = -90;
            }
            else{
                d = 90;
            }
        }
        return d;

    }
    static Point[] bubbleSort(Point[] arr) {
        int n = arr.length;
        Point temp = arr[1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 2; j < (n - i + 1); j++) {
                if (dif(arr[j-1], arr[0]) > dif(arr[j], arr[0])) {
                    // swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        return arr;

    }


    public static void crazy(boolean a) {

        Scanner input = new Scanner(System.in);
        System.out.println("How many points do you want?");
        Point[] p = new Point[input.nextInt()];
        Random rand = new Random();
        for (int i = 0; i < p.length; i++) {
            p[i] = new Point();
            p[i].setLocation((rand.nextDouble() * (hight * 2)) - hight, (rand.nextDouble() * (width * 2)) - width);
        }
        double min = 450;
        int pos = p.length - 1;
        for (int i = 0; i < p.length; i++) {
            if (p[i].getY() < min) {
                min = p[i].getY();
                pos = i;
            }
            if (p[i].getY() == min) {
                if (p[i].getX() < p[pos].getX()) {
                    min = p[i].getY();
                    pos = i;
                }

            }
        }
        Point temp = p[0];
        p[0] = p[pos];
        p[pos] = temp;

        Turtle t = new Turtle();
        t.setFullSceen();
        Color[] color = { Color.GREEN, Color.blue, Color.red, Color.orange, Color.cyan };
        t.tailUp();

        aagoto(t, p[0]);
        t.tailDown();
        p = bubbleSort(p);
        int j = 0;
        for (int i = 0; i < p.length - 1; i++) {
            t.setTailColor(color[j]);
            aagoto(t, p[i + 1]);
            if (j < 4) {
                j++;
            } else {
                j = 0;
            }
        }
        aagoto(t, p[0]);
    }



    public static double gethight() {
        return hight;
    }

    public static void sethight(int hight) {
        run.hight = hight;
    }


}