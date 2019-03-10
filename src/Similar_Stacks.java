//import unit4.collectionsLib.Node;
//import unit4.collectionsLib.Stack;

public class Similar_Stacks {

//    public static void printList(Node<Integer> myList){
//        for(Node<Integer> crnt = myList; crnt!=null; crnt=crnt.getNext()){
//            System.out.print(crnt.getValue() + ", ");
//        }
//    }
//
//    public static Node<Integer> generateList(int length, int maxNum){
//        int num = (int)(Math.random()*maxNum+1);
//        Node<Integer> myList = new Node<Integer>(num);
//        int count = 2;
//        for(Node<Integer> crnt = myList; count<length; crnt=crnt.getNext()){
//            num = (int)(Math.random()*maxNum+1);
//            crnt.setNext(new Node<Integer>(num));
//            count++;
//        }
//        return myList;
//    }
//
//
//    public static boolean isSimilar(Stack<Integer> s1,Stack<Integer> s2){
//        Node<Integer> myList = new Node<Integer>(s1.pop());
//        for(Node<Integer> crnt1 = myList; !s1.isEmpty(); crnt1 = crnt1.getNext()){
//            crnt1.setNext(new Node<Integer>(s1.pop()));
//        }
//        Node<Integer> crnt2 = myList
//        while(!s2.isEmpty()){
//
//        }
//
//
//
//        if(myList!=null){
//            return false;
//        }
//    }
//
//    public static void main(String[] args) {
//        Stack<Integer> s1 = new Stack();
//        s1.push(3);
//        s1.push(5);
//        s1.push(9);
//        s1.push(6);
//        Stack<Integer> s2 = new Stack();
//        s2.push(3);
//        s2.push(9);
//        s2.push(5);
//        s2.push(6);
//        System.out.println(isSimilar(s1,s2));
//    }
}
