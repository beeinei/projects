package Tirgul_IntNode;

import java.util.Scanner;

public class Task_6 {

    public static IntNode noSeqList(IntNode myList) {
        IntNode crnt = myList;
        while (crnt != null) {
            IntNode temp = crnt;
            while (temp.getNext() != null) {
                if (crnt == temp.getNext()) {
                    temp.setNext(temp.getNext().getNext());
                }
                temp = temp.getNext();
            }
            crnt = crnt.getNext();
        }
        IntNode m = myList;
        System.out.println("the new list: ");
        while (m != null) {
            System.out.print(m.getValue() + ", ");
            m = m.getNext();
        }
        return m;
    }

    public static void printList(IntNode myList){
        boolean stop = false;
        for(IntNode crnt = myList; !stop; crnt=crnt.getNext()){
            System.out.print(crnt.getValue() + ", ");
            if(crnt.getNext()==null){
                System.out.print(crnt.getValue());
                stop = true;
            }
        }
    }

        /*Other.Tirgul_IntNode curr = myList;
        Other.Tirgul_IntNode newList = new Other.Tirgul_IntNode(curr.getValue());
        Other.Tirgul_IntNode output = newList;
        while (curr.getNext() != null) {
            if (curr.getValue() == curr.getNext().getValue()) {
                curr = curr.getNext();
            } else {
                newList.setNext(new Other.Tirgul_IntNode(curr.getValue(), curr.getNext()));
                newList = newList.getNext();
                curr = curr.getNext();
            }
        }
        return output;
    }
        /*
        Other.Tirgul_IntNode newList;
        Other.Tirgul_IntNode output = newList;
        Other.Tirgul_IntNode crnt = myList;
        Other.Tirgul_IntNode newCrnt = newList;
        /*while (crnt.getNext() == null) {
            if (crnt.getNext().getValue() != crnt.getValue()) {
                newCrnt.setNext(crnt.getNext());
                crnt = crnt.getNext();
                newCrnt = newCrnt.getNext();
                //newCrnt.setNext(crnt.getNext());
                //newCrnt = newCrnt.getNext();
            }
            crnt.setNext(crnt.getNext());
        }
        return newList;*/

        /*
        Other.Tirgul_IntNode newList = new Other.Tirgul_IntNode(myList.getValue());
        Other.Tirgul_IntNode crnt = myList;
        Other.Tirgul_IntNode newCrnt = newList;
        while(crnt.getNext() == null){
            if(crnt.getNext().getValue() != crnt.getValue()){
                newCrnt.setNext(crnt.getNext());
                newCrnt = newCrnt.getNext();
            }
            crnt.setNext(crnt.getNext());
        }
        return newList;
        */

    public static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {

        IntNode myList = new IntNode((int)(Math.random()*2));
        //Other.Tirgul_IntNode myList = new Other.Tirgul_IntNode(1);
        IntNode crnt = myList;
        //System.out.print(crnt.getValue());
        for(int i=0; i<10; i++){
            crnt.setNext(new IntNode((int)(Math.random()*2)));
            //crnt.setNext(new Other.Tirgul_IntNode(1));
            crnt = crnt.getNext();
        }
        printList(myList);
        printList(noSeqList(myList));

        /*
            crnt.setNext(new Other.Tirgul_IntNode((int)(Math.random()*10)));
            //crnt.setNext(new Other.Tirgul_IntNode(1));
            crnt = crnt.getNext();
            */
        System.out.println("");
        //System.out.println("noSeqList = " + noSeqList(myList));
        //System.out.println("seqNum = " + seqNum(myList, 1));
        //System.out.println("seqNum = " + seqNum(myList, 6));
        }
    }