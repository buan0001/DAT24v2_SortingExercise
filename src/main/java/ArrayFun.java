import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayFun {
    public static void main(String[] args){

        int[] firstArray = {1,2,3,4,5};
        int[] secondArray = {10,20,30,40,50};
        int[] thirdArray = {100,200,300,400,500};

        int[] mergedArray = merge(firstArray,secondArray, thirdArray);
        System.out.println("merged array:");
        System.out.println(Arrays.toString(mergedArray));
    }

    // combines two arrays, returns the new array
    public static int[] merge(int[]... numArrays) {

         int totalIndexes = 0;
        for (int[] arr : numArrays) {
            totalIndexes += arr.length;
        }

        int[] newArray = new int[totalIndexes];
        System.out.println(newArray.length);
        int indexCounter = 0;
        for (int[] arr : numArrays) {
            System.out.println(Arrays.toString(arr));
            for (int i = 0; i < arr.length; i++) {
                newArray[indexCounter] = arr[i];
                indexCounter++;
            }
        }


    return newArray;
//    public static int[] merge(int[] a1, int[] a2) {
//        int[] newArray = new int[a1.length + a2.length];
//        int indexCounter = 0;
//        List<int[]> args = new ArrayList<>();
//        for (int i = 0; i < a1.length; i++) {
//            newArray[i] = a1[i];
//            indexCounter++;
//        }
//
//    }
}}
