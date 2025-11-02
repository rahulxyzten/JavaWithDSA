package AdityaVerma.BinarySearch.Question;

public class P1FirstLastOccurrence {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,4,4,4,4,4,4,4,4,5,9,10,14,15,20,30,40,45,70};
        int[] arr = {92, 90, 89, 89, 89, 89, 89, 89, 89, 89, 89, 89, 70, 48, 44, 33, 21, 7, 4, 2, 1};
        int element = 89;
        System.out.println("The first occurrence is " + firstOccurrence(arr, element));
        System.out.println("The last occurrence is " + lastOccurrence(arr, element));
    }

    static int firstOccurrence(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (element == arr[mid]) {
                result = mid;
                end = mid - 1;
            }
            //Ena sadhabele aag aag k thelba nehita pachh pachh k thelba first aau last ta paibarlagai
            else {
                if (isAsc) {
                    if (element > arr[mid]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (element > arr[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
            //In above is else only one is executed
        }

        return result;
    }

    static int lastOccurrence(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (element == arr[mid]) {
                result = mid;
                start = mid + 1;
            } else {
                if (isAsc) {
                    if (element > arr[mid]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (element > arr[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }

        return result;
    }
}
