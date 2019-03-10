package Bagrut_1;

import unit4.collectionsLib.BinNode;
import java.util.Stack;

public class Task_12 {

/*
    public static Stack<Integer> scanTochit(BinNode<Stack<Integer>> t) {
        if (!t.hasLeft() && !t.hasRight())
        else{ return scanTochit(t.getLeft()) + t.getValue() + scanTochit(t.getRight()); }
    }
*/

    //public static Stack<Integer> doSomthing (BinNode<Integer> bt){}
    //public static void doSomthing (BinNode<Integer> bt, Stack<Integer> que) { if (bt != null) { } }


    public static int calcStackVal(Stack<Integer> stk) {
        int sum;
        if(stk.size()==1){
            sum = stk.peek();
        }else if(stk.size()==2){
            int a = stk.pop();
            int b = stk.pop();
            stk.push(b);
            stk.push(a);
            sum = a + b;
            stk.push(sum);
        }else if(stk.isEmpty()){
            sum = 0;
            stk.push(sum);
        }else{
            int a = stk.pop();
            int b = stk.pop();
            int c = stk.pop();
            stk.push(c);
            stk.push(b);
            stk.push(a);
            sum = a + b + c;
            stk.push(sum);
        }
        return sum;
    }


    /*
    public static Stack<Integer> method(BinNode<Stack<Integer>> t){
        Stack<Integer> stk = new Stack<>();
        if(!t.hasRight() && !t.hasLeft()){
            stk.push(calcStackVal(t.getValue()));
            return stk;
        }else{

        }
    }
    */
    
}
