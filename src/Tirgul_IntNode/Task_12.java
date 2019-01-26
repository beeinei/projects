package Tirgul_IntNode;

public class Task_12 {

    //assuming myList != null
    public static boolean isBalanced(IntNode myList) {
        int sum = 0;
        int numOfNums = 0;
        for(IntNode i = myList; i!=null; i = i.getNext()){
            sum = sum + i.getValue();
            numOfNums++;
        }
        int avg = sum/numOfNums;
        System.out.println(avg);
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
        IntNode myList = new IntNode((int)(Math.random()*10));
        //Other.Tirgul_IntNode myList = new Other.Tirgul_IntNode(1);
        IntNode crnt = myList;
        //System.out.print(crnt.getValue());
        for(int i=1; i<10; i++){
            int tmp;
            if(i<5){
                tmp=4;
            }else{
                tmp=6;
            }
            crnt.setNext(new IntNode(tmp));
            //crnt.setNext(new Other.Tirgul_IntNode(1));
            crnt = crnt.getNext();
            System.out.print(crnt.getValue() + " ");
        }
        System.out.println(isBalanced(myList));
    }

}
