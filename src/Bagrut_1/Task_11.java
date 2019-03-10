package Bagrut_1;
import unit4.collectionsLib.Stack;
import unit4.collectionsLib.BinNode;

public class Task_11 {
    public static void leaves(BinNode<Integer> t, Stack<Integer> s){
        if(t==null){
            System.out.println("ERROR t is empty");
        }else{
            if(!(t.hasLeft()||t.hasRight())){
                s.push(t.getValue());
            }else if(t.hasRight()){
                leaves(t.getRight(), s);
            }else{
                leaves(t.getLeft(), s);
            }
            System.out.println(s.toString());
        }
    }

    public static boolean stam(BinNode<Integer> t1, BinNode<Integer> t2){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        leaves(t1,s1);
        leaves(t2,s2);
        int a;
        int b;
        while(s1.isEmpty()||s2.isEmpty()){
            a = s1.pop();
            b = s2.pop();
            if(s1.isEmpty()||s2.isEmpty()){
                if(!(s1.isEmpty()&&s2.isEmpty())){
                    return false;
                }
            }else{
                if(a!=b){
                    return false;
                }
            }
        }
        return true;
    }


}
