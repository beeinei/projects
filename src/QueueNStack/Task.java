package QueueNStack;

import unit4.collectionsLib.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Task {

    public static Stack<Integer> getStringsLength(Stack<String> s){
        Stack<String> s2 = s; //to keep s from being cleared
        Stack<Integer> tmp = new Stack();
        Stack<Integer> output = new Stack();
        String curr;
        while (!s2.empty()) {
            curr = s.pop();
            tmp.push(curr.length());
        }
        while (!tmp.empty()) {
            output.push(tmp.pop());
        }
        return output;
    }

    public static boolean xZyZx(String str){
        System.out.println("Insert some chars!");
        char input;
        for(int i = 0; i<str.length(); i++){
            input = str.charAt(i);
            if(input != 'a' && input != 'b' && input != 'c' && input != 'Z') {
                return false;
            }
        }

        //--
        int indexOfZ1 = -1;
        int indexOfZ2 = -1;
        Stack<Character> section1 = new Stack<>();
        Queue<Character> section2 = new Queue<>();
        Stack<Character> section3 = new Stack<>();
        for(int i = 0; i<str.length(); i++) {
            if (str.charAt(i) == 'Z') {
                if (indexOfZ1 == -1) {
                    indexOfZ1 = i;
                }
                else if ((indexOfZ1 != -1) && (indexOfZ2 == -1)) {
                    indexOfZ2 = i;
                }
                else if ((indexOfZ1 != -1) && (indexOfZ2 != -1)) { //if there is more than 1 'Z'
                    return false;
                }
            }
        }
        if((indexOfZ1 == -1) || (indexOfZ2 == -1))
        {
            return false;
        }
        if((indexOfZ1+1 != (indexOfZ2-indexOfZ1)) || ((indexOfZ2-indexOfZ1) != (str.length()-indexOfZ2)))
        {
            return false;
        }

        for (int i = 0; i!=indexOfZ1; i++){
            section1.push(str.charAt(i));
        }
        for (int i = 1; !section1.isEmpty(); i++){
            char first = section1.pop();
            if(first!=str.charAt(i+indexOfZ1)){
                return false;
            }
            else{
                section2.insert(first);
            }
        }

        for (int i = indexOfZ2+1; i<str.length(); i++){
            section3.push(str.charAt(i));
        }
        for (int i = 0; !section3.isEmpty(); i++){
            char first = section3.pop();
            if(first!=section2.remove()){
                return false;
            }
        }
        return true;
    }

    public static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        //13
        System.out.println("-13- init");
        System.out.println("Insert strings. Space of Enter to separate, -1 to finish");
        Stack<String> stk = new Stack();
        String input = reader.next();
        while(!input.equals("-1")){
            stk.push(input);
            input = reader.next();
        }
        System.out.println(getStringsLength(stk).toString());
        System.out.println("-13- complete");
        System.out.println("-------");

        //21
        System.out.println("-21- init");
        System.out.println("Insert string");
        String str = reader.next();
        System.out.println("Is xZyZx = " + xZyZx(str));
        System.out.println("-21- complete");
    }

}
