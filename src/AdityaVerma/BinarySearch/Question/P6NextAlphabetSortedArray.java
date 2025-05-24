package AdityaVerma.BinarySearch.Question;
//Find the next alphabet in sorted char array

public class P6NextAlphabetSortedArray {
    public static void main(String[] args) {
        char[] arr = {'a', 'c', 'f', 'g', 'i', 'h'};
        char key = 'h';
        System.out.println(nextAlphabet(arr, key));
    }

    public static char nextAlphabet(char[] arr, char key) {
        char result = '#';
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                start = mid + 1;
            } else if (arr[mid] > key) {
                result = arr[mid];
                end = mid - 1;
            } else {//else if(arr[mid] < key){
                start = mid + 1;
            }
        }
        return result;
    }
}
