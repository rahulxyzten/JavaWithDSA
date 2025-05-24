package KunalKushwaha.CP4Arrays.Concept;
import java.util.Scanner;
import java.util.Arrays;

/* Not as much as good*/
//when there is not fixed row then
//arr[row].length is used for print the array
//        int[][] arr = new int[3][];
//        int[][] arr = {
//                {1, 2, 3}, // 0th index
//                {4, 5}, // 1st index
//                {6, 7, 8, 9} // 2nd index -> arr[2] = {6, 7, 8, 9}
//        };

public class MultiDimension {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);




        int[][] arr = new int[3][3];
        System.out.println(arr.length); // no of rows
        // input

        for (int row = 0; row < arr.length; row++) {
            // for each col in every row
            for (int col = 0; col < arr[row].length; col++) {
                //every time arr[row].length is given 3 because in the above [3] [3]
                arr[row][col] = in.nextInt();
            }
        }

        // output
//        for (int row = 0; row < arr.length; row++) {
//            // for each col in every row
//            for (int col = 0; col < arr[row].length; col++) {
//                System.out.print(arr[row][col] + " ");
//            }
//            System.out.println();
//        }

        // output
//        for (int row = 0; row < arr.length; row++) {
//            System.out.println(Arrays.toString(arr[row]));
//        }

        for(int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
