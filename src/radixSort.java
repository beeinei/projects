
//Done!
import unit4.collectionsLib.Queue;
public class radixSort {

    public static int maxDigitNumber(int[] arr){ //לסדר לפי תור
        int num = 0;
        int digits;
        for(int i=0; i<arr.length; i++){
            num = Math.max(arr[i], num);
        }
        for(digits=0; num!=0; digits++){
            num=num/10;
        }
        return digits;
    }

    public static void radixSort(int[] arr){
        Queue<Integer>[] queues = new Queue[10];
        Queue temp = new Queue();
        for(int i=0; i<arr.length; i++){
            temp.insert(arr[i]);
        }
        for(int i=0; i<queues.length; i++){
            queues[i] = new Queue();
        }
        int num;
        int a;
        int max = maxDigitNumber(arr);
        for(int j=0; j<max; j++) {
            for (int i = 0; i < arr.length; i++) {
                a = (int) temp.remove();
                num = (int) ((a/(Math.pow(10, j))) % 10);
                queues[num].insert(a);
            }
            for (int i = 0; i < queues.length; i++) {
                while (!queues[i].isEmpty()) {
                    temp.insert(queues[i].remove());
                }
            }
        }
        for(int i = 0; !temp.isEmpty(); i++){
            arr[i] = (int)temp.remove();
        }
    }

    public static void printArr(int[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args)
    {
        int[] arr = new int[10];
        int num;
        for(int i=0; i<arr.length; i++){
            num = (int)(Math.random()*10+1);
            System.out.print(num + " ");
            arr[i] = num;
        }
        System.out.println("");
        radixSort(arr);
        printArr(arr);
    }
}
