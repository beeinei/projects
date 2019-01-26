package Other;

import java.util.Arrays;

public class moreTask1 {

    public static int locInArray1A(int[] sArray, int n) {
        for (int i = 0; i < (sArray.length - 1); i++) {
            if (sArray[i] == n) {
                return i;
            }
        }
        return (-1);
    } //קולטת מערך ממויין ומחזירה אינדקס של מספר שלם נתון

    public static void swap(int[] arr, int i, int j) { //swaps 2 ints in array. i,j = indexes
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort1B(int arr[]) {
        for (int i = (arr.length - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j + 1]) { //אם איבר גדול מהאיבר שאחריו, החלף
                    swap(arr, j, j + 1);
                }
            }
        }
    }//ממיינת מערך בסדר יורד

    public static int smallest2A(int[] arr) //המרתי את הקלט למערך כדי שלמשתמש תהיה שליטה על כמות המספרים שהוא מחליט להכניס כקלט
    {
        int output = arr[0]; //המספר שאותו נשווה בלולאה הבאה לשאר המספרים במערך. המשתנה בסופו של דבר יכיל את המספר הכי קטן במערך
        for (int i = 1; i < (arr.length - 1); i++) //i=1: אין טעם לבדוק את arr[0], כבר בדקנו אותו קודם
        {
            if (arr[i] < output) {
                output = arr[i];
            }
        }
        return output;
    }//מוצאת את המספר הקטן ביותר במערך נתון

    public static void smallest2Bb(int[] arr) {
        sort1B(arr);
        System.out.println(arr[arr.length - 1] + ", " + arr[arr.length - 2] + ", " + arr[arr.length - 3]);
    } //(שנמצאים בסופו) הפעולה ממיינת את המערך בסדר יורד ומדפיסה את 3 המספרים הכי קטנים

    public static void smallest2Ba(int[] arr) {
        sort1B(arr);
        System.out.println(arr[arr.length - 1] + ", " + arr[arr.length - 2]);
    } //(שנמצאים בסופו) הפעולה ממיינת את המערך בסדר יורד ומדפיסה את 2 המספרים הכי קטנים


    public static void main(String[] args) {
        //Other.test regular functions
        int[] sArr = new int[]{-19, -1, -1, 7, 35, 56, 1003}; //sorted array
        int[] arr = new int[]{19, -7, -1, 0, 0, 17, 3, 55, -6, 1003};
        System.out.println("locInArray1A = " + locInArray1A(sArr, -1) + ", " + locInArray1A(sArr, 0) + ", ");
        System.out.println();
        System.out.println("smallest2A = " + smallest2A(arr));

        //Other.test etgar functions
        System.out.println();
        System.out.println("sort1B(arr) = ");
        sort1B(arr);
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
        System.out.println();
        System.out.println("smallest2Ba(arr) = ");
        smallest2Ba(arr);
        System.out.println();
        System.out.println("smallest2Bb(arr) = ");
        smallest2Bb(arr);
    }
}

/*
    public static void sort2A(int[] arr) {
        for (int i = arr.length-1; i>0; i--) {
            for (int j=0; j<i; j++) { //עבור על כל המערך
                if(arr[j] < arr[j+1]){
                    swap(arr, j, j+1); //תחליף את המספר הקטן והגדול
                }
            }
        }
    }


    public static void smallest2B(int arr[], int count){
        if(count==1){
            smallest2A(arr);
        }
        else{
            count--;
            int[] newArr = new int[arr.length-1]
            for (int i=0;i<arr.length;i++){
                if(arr[i]=)
            }
            //smallest2B(Arrays.copyOfRange(arr,0, (arr.length - 2)));
        }
    }


    */
