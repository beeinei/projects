package Other;
import unit4.collectionsLib.BinNode;
public class Tree
{
    public static boolean isOperator(char ch){
        if((ch=='+')||(ch=='-')||(ch=='*')||(ch=='/')){
            return true;
        }else{
            return false;
        }
    }

    public static int lastOperator(String s){ //returns index of last operator. If none, returns -1
        char ch;
        if(s.length()==0){
            return -1;
        }else if(s.length()==1){
            ch = s.charAt(0);
            if(isOperator(ch)==true){
                return 0;
            }
        }else{
            int openers = 0;
            int closers = 0;
            for(int i=0; i<(s.length()-2); i++){
                ch = s.charAt(i);
                if(ch==')'){
                    closers++;
                }else if(ch=='('){
                    openers++;
                }
                if((openers-closers==1) && (isOperator(s.charAt(i))==true)){ //(4*1)
                    return i;
                }
            }
        }
        return -1;
    }


    public static BinNode<Character> buildExpressionTree(BinNode<Character> root, String str){
        if(str.isEmpty()) {
            return new BinNode(null, 'X', null);
        } else if (lastOperator(str)==-1){
            // If is a single digit
            return new BinNode(null, str.charAt(0), null);
        } else{
            // If is an expression
            int lOp = lastOperator(str);
            root.setValue(str.charAt(lOp));
            root.setLeft(
                    buildExpressionTree(new BinNode<Character>(null,'X',null), str.substring(1,lOp))
            ); //a template
            root.setRight(
                    buildExpressionTree(new BinNode<Character>(null,'X',null), str.substring(lOp+1, str.length()-1))
            ); //a template
            return root;
        }
    }

    public static void printNodes(BinNode<Character> bn) {
        if(bn!=null){
            System.out.println(bn.getValue() + " ");
            printNodes(bn.getLeft());
            printNodes(bn.getRight());
        }
    }

    public static void main(String[] args)
    {
        BinNode<Character> root = new BinNode<Character>(null, 'X', null);
        printNodes(buildExpressionTree(root, "(((4*1)+8)-(9/3))"));
    }

}