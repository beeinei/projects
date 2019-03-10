package Tirgul_IntNode;

//Done!
public class Task_6 {

    public static boolean inList(IntNode myList, int i){
        for(IntNode crnt = myList; crnt!=null; crnt=crnt.getNext()){
            if (crnt.getValue()==i){
                return true;
            }
        }
        return false;
    }

    public static IntNode noSeqList(IntNode myList) {
        IntNode alreadyHasList = new IntNode(myList.getValue());
        IntNode newCrnt = alreadyHasList;
        for(IntNode crnt = myList; crnt!=null; crnt=crnt.getNext()){
            //printList(alreadyHasList); System.out.println("");
            if(!inList(alreadyHasList,crnt.getValue())){
                newCrnt.setNext(new IntNode(crnt.getValue()));
                newCrnt = newCrnt.getNext();
            }
        }
        return alreadyHasList;
    }

    public static void printList(IntNode myList){
        for(IntNode crnt = myList; crnt!=null; crnt=crnt.getNext()){
            System.out.print(crnt.getValue() + ", ");
        }
    }

    public static IntNode generateList(int length, int maxNum){
        int num = (int)(Math.random()*maxNum+1);
        IntNode myList = new IntNode(num);
        int count = 2;
        for(IntNode crnt = myList; count<length; crnt=crnt.getNext()){
            num = (int)(Math.random()*maxNum+1);
            crnt.setNext(new IntNode(num));
            count++;
        }
        return myList;
    }

    public static void main(String[] args){
        IntNode myList = generateList(10, 10);
        printList(myList);
        System.out.println("");
        printList(noSeqList(myList));
    }
}
