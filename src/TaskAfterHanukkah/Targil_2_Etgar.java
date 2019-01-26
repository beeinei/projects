package TaskAfterHanukkah;

import unit4.turtleLib.Turtle;

import java.awt.*;
import java.util.Scanner;

public class Targil_2_Etgar {

    public static void swap(Point[] arr, int a, int b){
        Point temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        Turtle t = new Turtle();
        t.tailDown();
        System.out.println("How many points would you like to have?");
        int length = reader.nextInt();
        Point[] points = new Point[length];

        //1
        System.out.println("//1");
        for (int i = 0; i<(points.length); i++) {
            points[i] = new Point((int)(Math.random()*10), (int)(Math.random()*10));
            System.out.println(points[i]);
            if(points[i].getY()<points[0].getY()){
                swap(points,0, i);
            }else if(points[i].getY()==points[0].getY()){
                if(points[i].getX()>points[0].getX()){
                    swap(points,0, i);
                }
            }
        }
        System.out.println("----");
        for (int i = 0; i<(points.length); i++) {
            System.out.println(points[i]);
        }

        //2
        System.out.println("");
        System.out.println("//2");
        double[] inclines = new double[length];
        for (int i = 0; i<(points.length); i++) {
            System.out.println(points[i]);
            inclines[i]=(points[i].getY()-points[0].getY())/(points[i].getX()-points[0].getX());
        }

        //3
        System.out.println("");
        System.out.println("//3");
        Point temp;
        for (int i = 1; i < length + 1; i++) {
            for (int j = 2; j < (length - i + 1); j++) {
                if ((inclines[i - 1] - inclines[0]) > (inclines[i] - inclines[0])) {
                    swap(points, i - 1, i);
                }
            }
        }
    }
}
