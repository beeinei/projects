package Other;

import unit4.turtleLib.Turtle;

import java.awt.*;

public class test {

    public static void test1(int n) {
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }

    public static void test2(int n) {
        for (int i = 10; i < n; i++) {
            if (n % i == 0) {

            }
        }
    }

    //public static void main(String[] args) {
    // test1(417);
    //}

    public static void main(String[] args) {
        Turtle t = new Turtle();
        int width = t.getScreenWidth();
        int height = t.getScreenHeight();
        t.tailDown();
        t.moveForward(100);
        //t.turnRight(90);
        //t.moveBackward(width/2);
        System.out.println("Trtl loc: x=" + t.getXLocation() + " y=" + t.getYLocation());
        //System.out.println("Screen Limits: Width: " + t.getScreenWidth() + ", Height: " + t.getScreenHeight());

        //System.out.println("How many points would you like to have?");
        int length = 3;
        //reader.nextInt();
        Point[] points = new Point[length];
        System.out.println("Trtl loc: x=" + t.getXLocation() + " y=" + t.getYLocation());
        System.out.println("-----");
        for (int i = 0; i < (points.length - 1 - 1); i++) {
            points[i] = new Point((int) (Math.random() * 100), (int) (Math.random() * 100));
            if (i == 0) {
                //move(t,points[i]);
                t.tailDown();
                System.out.println(points[i]);
                System.out.println("Trtl loc: x=" + t.getXLocation() + " y=" + t.getYLocation());
                System.out.println("-----");
            } else {
                while (points[i].getY() == points[i - 1].getY() && points[i].getX() == points[i - 1].getX()) {
                    points[i] = new Point((int) (Math.random() * 100), (int) (Math.random() * 100));
                }
                //move(t,points[i]);
                System.out.println(points[i]);
                System.out.println("Trtl loc: x=" + t.getXLocation() + " y=" + t.getYLocation());
                System.out.println("-----");
            }
        }
        //move(t,pZero);
        //points[points.length-1] = new Point((int)(Math.random()*100), (int)(Math.random()*100));
        //move(t,points[points.length-1]);
        System.out.println("Trtl loc: x=" + t.getXLocation() + " y=" + t.getYLocation());
        //move(t,points[0]);
        System.out.println("-----");
        System.out.println(points[0]);
        System.out.println("Trtl loc: x=" + t.getXLocation() + " y=" + t.getYLocation());
        System.out.println("-----");

        //System.out.println(t.getHeading() + "  " + (Math.toDegrees(Math.atan2(deltaY, deltaX))));
        //System.out.println("incline = " + incline);
        //double angle = Math.abs(Math.toDegrees(Math.atan(incline)));
        //System.out.println("angle = " + (90-angle));
        //System.out.println("angle = " + (90-angle));
        //double steps = Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
        //System.out.println("steps = " + steps);
        //t.turnRight(90-angle);
        //t.moveForward(steps);
        //t.turnLeft(90-angle);
    }

}

     /*for (int i = 0; i < points.length - 1; i++) {
        points[i] = new Point((int)(Math.random()*t.getScreenWidth()),(int)(Math.random()*t.getScreenHeight()));
    }
    Point smallest = points[0];
    int smallestI = -1;
        for(int i = 0; i < points.length; i++){
        if(points[i].getY()<smallest.getY()){
            swap(points,smallestI,i);
        }
        if(points[i].getY()==smallest.getY()){
            if(points[i].getX()<smallest.getX()){
                swap(points,smallestI,i);
            }
        }
    }*/



/*
        boolean found = false;
        for(int i = 0; i<this.contacts.length && !found; i++) {
            if(contacts[i].getName().equals(name)){
                contacts[i].setPhoneNumber(phone);
                found = true;
            }
        }
        if(!found){
            contacts = new Other.Contact[contacts.length+1];
            contacts[contacts.length-1] = new Other.Contact(name, phone);
        }
        */





        /*for(int i = 0; i<(contacts.length-1) && notFound; i++) {
            if(contacts[i].getName().equals(name)){
                contactIndex = i;
                found = true;
            }
        }
        Other.Contact[] contacts2 = new Other.Contact[contacts.length-1];
        for(int j = 0; j<this.contacts.length; j++) {
            if(j<contactIndex)

        }
        contacts = contacts2;
        */
