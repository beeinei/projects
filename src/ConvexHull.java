import Tirgul_IntNode.IntNode;
import unit4.collectionsLib.Node;
import unit4.collectionsLib.Queue;
import unit4.turtleLib.Turtle;

import java.awt.Point;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ConvexHull
{

    public static int rnd(int n){
        return (int)(Math.random()*n);
    }

    public static Point top(Stack<Point> s){
        if(!s.isEmpty()){
            Point p = s.pop();
            s.push(p);
            return p;
        }
        return null;
    }

    public static Point nextToTop(Stack<Point> s){
        if(!s.isEmpty()){
            Point p1 = s.pop();
            if(!s.isEmpty()){
                Point p2 = s.pop();
                s.push(p2);
                s.push(p1);
                return p2;
            }
        }
        return null;
    }

    public static void printPArr(Point[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i].toString());
        }
    }

    public static boolean isObtuseAngle(Point a, Point b, Point c){
        double ab = distance(a,b);
        double ac = distance(a,c);
        double bc = distance(b,c);
        double angle = Math.acos((bc*bc + ab*ab - ac*ac)/(2*bc*ab));
        return (angle>=90);
    }

    public static void swap(Point[] arr, int index1, int index2){
        Point temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void bubbleSort(Point[] arr, double[] angles)
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (angles[j] > angles[j+1])
                {
                    double temp = angles[j];
                    angles[j] = angles[j+1];
                    angles[j+1] = temp;
                    //swap points
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void deleteNodeFromList(Node myList, Node n){ //mylist!=null
        Node temp;
        if (myList != null){
            for(Node crnt = myList; crnt.getNext()!=null; crnt = crnt.getNext()){
                temp = crnt.getNext();
                crnt.setNext(crnt.getNext().getNext());
                temp.setNext(null);
            }
        }
    }

    public static double polarAngle(Point a, Point b){
        Point c = new Point((int)b.getX(),(int)a.getY());
        double ac = c.getX()-a.getX();
        double ab = Math.sqrt((b.getX()-a.getX())*(b.getX()-a.getX()) + (b.getY()-a.getY())*(b.getY()-a.getY()));
        return Math.toDegrees(Math.acos(ac/ab));
    }

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

    public static void convexHull(Turtle t, Point[] arr){
        //1+2
        for(int i = 1; i<arr.length; i++){
            if(arr[0].getY() > arr[i].getY()){
                swap(arr,0,i);
            }
            if(arr[0].getY() == arr[i].getY()){
                if(arr[0].getX() > arr[i].getX()){
                    swap(arr,0,i);
                }
            }
        }

        double[] angle = new double[arr.length];
        for(int i = 0; i<arr.length; i++){
            if(i==0){
                angle[i] = 0;
            }else {
                angle[i] = polarAngle(arr[0], arr[i]);
            }
        }
        bubbleSort(arr, angle);
        //remove points with the same polar angle
        Queue<Point> pointQueue = new Queue<>();


        for (int i = 0; i < (angle.length-1); i++) {
            double angle1=angle[i], angle2=angle[i+1];
            while(angle1==angle2) {
                i++;
                angle2=angle[i];
            }
        }

        for(int i = 0; i<(arr.length-1); i++){
            if (angle[i]==angle[i+1]){
                if(distance(arr[0],arr[i])>(distance(arr[0],arr[i+1]))){
                    pointQueue.insert(arr[i]);
                    angle[i+1] = -1;
                    i++;
                }else{
                    pointQueue.insert(arr[i+1]);
                    angle[i] = -1;
                }
            }else{
                pointQueue.insert(arr[i]);
            }
        }
        Point stam; //because pop returns point and not void
        Stack<Point> s = new Stack<>();
        s.push(pointQueue.remove()); //p0
        s.push(pointQueue.remove()); //p1
        s.push(pointQueue.remove()); //p2
        for (int i = 3; i < arr.length; i++) {
            if(isObtuseAngle(nextToTop(s), top(s), arr[i])){
                s.push(arr[i]);
            }
        }

        move(t,arr[0]);
        t.tailDown();
        while(!s.isEmpty()){
            move(t,s.pop());
        }
    }

    public static double distance(Point a, Point b){
            if(b.getX()==a.getX()){
                return Math.abs(b.getY()-a.getY());
            }
            else if(b.getY()==a.getY()){
                return Math.abs(b.getX()-a.getX());
            }else {
                return Math.sqrt((b.getX() - a.getX()) * (b.getX() - a.getX()) + (b.getY() - a.getY()) * (b.getY() - a.getY()));
            }
    }


    public static Scanner reader = new Scanner(System.in);
    public static void main(String[] args)
    {
        Turtle t = new Turtle();
        Point[] arr = new Point[reader.nextInt()];
        for(int i = 0; i<arr.length; i++){
            arr[i] = new Point(rnd(100),rnd(100));
        }
        convexHull(t,arr);
        //System.out.println(angle(new Point(0,0), new Point(-3,-4)));

        /*
		System.out.println("Before ConvexHull:");
		printPArr(arr);

		System.out.println("---------");

		System.out.println("After ConvexHull:");
		convexHull(arr);
		printPArr(arr);




        //2
        double[] angles = new double[arr.length-1];
        for(int i = 1; i<arr.length; i++){
            Point a = arr[0];
            Point b = arr[i];
            Point c = new Point((int)b.getX(),(int)a.getY());
            double ac = c.getX()-a.getX();
            double ab = Math.sqrt((b.getX()-a.getX())*(b.getX()-a.getX()) + (b.getY()-a.getY())*(b.getY()-a.getY()));
            double angle = Math.acos(ac/ab);
            angles[i-1] = angle;
        }
        for(int i = 0; i<arr.length; i++){
            System.out.println(angles[i]);
        }
 		*/
    }

}