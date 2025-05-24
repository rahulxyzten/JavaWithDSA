package AdityaVerma.Recursion.Questions;
//Sort an Array entirely on Recursion

import java.util.Vector;

public class P3SortArray {
    public static void main(String[] args) {
        Vector<Integer> arr = new Vector<>();
        arr.add(2);
        arr.add(3);
        arr.add(7);
        arr.add(6);
        arr.add(4);
        arr.add(5);
        arr.add(9);
        System.out.println(arr);
        sort(arr);
        System.out.println(arr);
    }

    public static void sort(Vector<Integer> arr) {
        if (arr.size() == 1) return;
        int temp = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        sort(arr);
        insert(arr, temp);
    }

    public static void insert(Vector<Integer> arr, int temp) {
        if (arr.size() == 0 || arr.get(arr.size() - 1) <= temp) {
            arr.add(temp);
            return;
        }
        int val = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        insert(arr, temp);
        arr.add(val);
    }

}
