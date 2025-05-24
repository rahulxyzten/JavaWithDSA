package KunalKushwaha.CP4Arrays.Leetcode.Easy;
/*
https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
 */

import java.util.Arrays;

public class P18MatrixRotation {
    public static void main(String[] args) {
//        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
//        int[][] target = {{1,1,1},{0,1,0},{0,0,0}};
//        int[][] mat = {{0,1},{1,1}};
//        int[][] target = {{1,0},{0,1}};

        int[][] mat = {{0, 0, 0}, {0, 0, 1}, {0, 0, 1}};
        int[][] target = {{0, 0, 0}, {0, 0, 1}, {0, 0, 1}};
        System.out.println(findRotation(mat, target));

    }


    public static boolean findRotation(int[][] mat, int[][] target) {
        if (Arrays.deepEquals(mat, target))
            return true;

        int n = mat.length;
        int[][] res = mat;
        for (int k = 0; k < 3; k++) {
            int[][] temp = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = res[n - 1 - j][i];
                }
            }
            res = temp;
            if (Arrays.deepEquals(target, res)) {
                return true;
            }
        }

        return false;
    }
//    public static boolean findRotation(int[][] mat, int[][] target) {
//        if (Arrays.deepEquals(mat, target)) return true;
//
//        int n = mat.length;
//        int[][] res = new int[n][n];
//
//        for (int k = 0; k < 3; k++) {
//            //For the first interval the if cond is fail and in else the res matrix allocate the mat matrix
//            if (k > 0) {
//                // Rotate the res matrix by 90 degrees
//                int[][] temp = new int[n][n];
//                for (int i = 0; i < n; i++) {
//                    for (int j = 0; j < n; j++) {
//                        temp[i][j] = res[n - 1 - j][i];
//                    }
//                }
//                res = temp;
//            } else {
//                res = mat;
//            }
//            if (Arrays.deepEquals(target, res)) {
//                return true;
//            }
//        }
//
//        return false;
//    }

//    public static boolean findRotation(int[][] mat, int[][] target) {
////        if(mat == target) return true;
//        //above line doesn't check both the array perfectly os
//        //you go for Array.deeEquals Method
//        if (Arrays.deepEquals(target,mat)){
//            return true;
//        }
//        int n = mat.length;
//        int[][] res1 =new int[n][n];
//        for (int i = 0; i < n; i++) { //clockwise 90
//            for (int j = 0; j < n; j++) {
//                res1[i][j] = mat[n-1-j][i];
//            }
//        }
//        if (Arrays.deepEquals(target,res1)){
//            return true;
//        }
//        int[][] res2 =new int[n][n];
//        for (int i = 0; i < n; i++) { //clockwise 180
//            for (int j = 0; j < n; j++) {
//                res2[i][j] = res1[n-1-j][i];
//            }
//        }
//        if (Arrays.deepEquals(target,res2)){
//            return true;
//        }
//        int[][] res3 =new int[n][n];
//        for (int i = 0; i < n; i++) {//clockwise 270
//            for (int j = 0; j < n; j++) {
//                res3[i][j] = res2[n-1-j][i];
//            }
//        }
//        if (Arrays.deepEquals(target,res3)){
//            return true;
//        }
//
//
//        return false;
//    }


}
