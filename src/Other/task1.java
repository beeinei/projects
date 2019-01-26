package Other;

public class task1 {

    public static int locInArray(int[] sArray, int n) {
        for(int i = 0; i<(sArray.length-1); i++) {
            if (sArray[i] == n) {
                return i;
            }
        }
        return (-1);
    }

    public static void sortInPlace(int[] arr, int startIndex, int endIndex) {
        int length = 1 + endIndex - startIndex;
        if (length < 2) {
            return;
        }

        int pivot = arr[endIndex];
        int target = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] > pivot) {
                //swap(arr);
            }
        }

        //sortInPlace(arr, 0, lowOnesIndex);
        //sortInPlace(arr, lowOnesIndex + 1, endIndex);
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }


    public static int smallest(int[] arr) //העברתי את הנתונים למערך כדי שלמשתמש תהיה שליטה על כמות המספרים שהוא מחליט להכניס כקלט
    {
        int output = arr[0]; //המספר שאותו נשווה בלולאה הבאה לשאר המספרים במערך. המשתנה בסופו של דבר יכיל את המספר הכי קטן במערך
        for (int i = 1; i<(arr.length-1); i++) //i=1: אין טעם לבדוק את arr[0], כבר בדקנו אותו קודם
        {
        if(arr[i]<output){
            output = arr[i];
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] sArr = new int[]{-19, -1, -1, 7, 35, 56, 1003};
        int[] arr = new int[]{19, -7, -1, 17, 3, 55, -6, 1003};
        System.out.println("locInArray = " + locInArray(sArr, -1) + ", " + locInArray(sArr, 0) + ", " + "smallest = " + smallest(arr));
        //locInArray(sArr, -1);
        //smallest(arr);
    }
}
