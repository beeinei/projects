package Tirgul_IntNode;

import java.util.Scanner;

public class Task_2 {


    public static int seqNum(IntNode myList, int a){
        IntNode crnt = myList;
        boolean isPrevious = false;
        int output = 0;

        while(crnt.getNext()!=null){
            if(crnt.getValue() == a){
                if(isPrevious == false)
                    output++;
                if(crnt.getNext().getValue() == a)
                    isPrevious = true;
            }
            else{
                isPrevious = false;
            }
            crnt=crnt.getNext();
        }
        return output;
    }

    public static Scanner reader = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("How many numbers would u like to have?");
        int length = reader.nextInt();
        System.out.println("Insert " + length + " numbers");
        IntNode myList = new IntNode(reader.nextInt());
        IntNode crnt = myList;
        for(int i=1; i<length; i++){
            crnt.setNext(new IntNode(reader.nextInt()));
            crnt = crnt.getNext();
        }
        for(crnt = myList; crnt.getNext()!=null; crnt=crnt.getNext()){
            System.out.print(crnt.getValue() + ", ");
        }
        if(crnt.getNext()==null){
            System.out.print(crnt.getValue());
        }
        System.out.println("");
        System.out.println("seqNum = " + seqNum(myList, 4));
    }

}
