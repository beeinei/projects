package Tirgul_IntNode;

//Done
public class Task_12 {

    public static void printList(IntNode myList){
        for(IntNode crnt = myList; crnt!=null; crnt=crnt.getNext()){
            System.out.print(crnt.getValue() + " ");
        }
    }

    //assuming myList != null
    public static boolean isBalanced(IntNode myList) {
        int sum = 0;
        int numOfNums = 0;
        for(IntNode i = myList; i!=null; i = i.getNext()){
            sum = sum + i.getValue();
            numOfNums++;
        }
        int avg = sum/numOfNums;
        //System.out.println(avg);
        int small = 0;
        int big = 0;
        for(IntNode i = myList; i!=null; i = i.getNext()){
            if(i.getValue()<avg){
                small++;
            }
            else if(i.getValue()>avg){
                    big++;
                }
            }
        return (small == big);
    }

    public static void main(String[] args) {
        IntNode myList = new IntNode(4);
        IntNode crnt = myList;

        //test
        int stam = 10;
        for(int i=1; i<stam; i++){
            int tmp;
            if(i<(0.5*stam)){
                tmp=4;
            }else{
                tmp=6;
            }
            crnt.setNext(new IntNode(tmp));
            crnt = crnt.getNext();
        }

        printList(myList);
        System.out.println(isBalanced(myList));
    }

}
