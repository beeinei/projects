package Tirgul_IntNode;

import java.util.Scanner;

public class Task_14 {

    public static void printList(IntNode myList){
        for(IntNode crnt = myList; crnt!=null; crnt=crnt.getNext()){
            if(crnt.getNext()==null){
                System.out.println(crnt.getValue());
            }else{
                System.out.print(crnt.getValue() + ",");
            }
        }
    }

    public static IntNode deleteLargest(IntNode myList) {
        IntNode beforeMaxNode = null;
        IntNode maxNode = myList;
        for (IntNode current = myList; current.getNext() != null; current = current.getNext()) {
            if (current.getNext().getValue() > maxNode.getValue()) {
                maxNode = current.getNext();
                beforeMaxNode = current;
            }
        }
        if (beforeMaxNode == null) {
            return myList.getNext();
        } else {
            beforeMaxNode.setNext(maxNode.getNext());
            maxNode.setNext(null);
            return myList;
        }
    }


    public static IntNode deleteNLargest(IntNode myList, int n){
        IntNode output = myList;
        for (int i = n; i > 0; i--) {
            output = deleteLargest(output);
        }
        return output;
    }

    private static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter list:");
        String in = reader.nextLine();
        IntNode list = null;
        while (!in.equals("")) {
            list = new IntNode(Integer.parseInt(in), list);
            in = reader.nextLine();
        }
        printList(list);
        System.out.println("Enter n:");
        int n = Integer.parseInt(reader.next());
        IntNode res = deleteNLargest(list, n);
        printList(res);
    }
}
