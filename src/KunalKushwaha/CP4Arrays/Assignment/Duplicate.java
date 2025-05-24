package KunalKushwaha.CP4Arrays.Assignment;

import java.util.Arrays;

//public class Duplicate {
//    public static void main(String[] args) {
//        int[] nums = {2, 2, 1, 1, 1, 2, 2};
//
//        int[] duplicateElements = findDuplicateElements(nums);
//
//        System.out.print("Duplicate elements: ");
//        for (int num : duplicateElements) {
//            System.out.print(num + " ");
//        }
//    }
//
//    public static int[] findDuplicateElements(int[] nums) {
//        int n = nums.length;
//        int[] duplicateElements = new int[n];
//        int count = 0;
//
//        for (int i = 0; i < n; i++) {
//            boolean isDuplicate = false;
//            for (int j = i + 1; j < n; j++) {
//                if (nums[i] == nums[j]) {
//                    isDuplicate = true;
//                    break;
//                }
//            }
//            if (isDuplicate) {
//                boolean isAlreadyAdded = false;
//                for (int k = 0; k < count; k++) {
//                    if (duplicateElements[k] == nums[i]) {
//                        isAlreadyAdded = true;
//                        break;
//                    }
//                }
//                if (!isAlreadyAdded) {
//                    duplicateElements[count++] = nums[i];
//                }
//            }
//        }
//
//        int[] result = new int[count];
//        System.arraycopy(duplicateElements, 0, result, 0, count);
//        return result;
//    }
//}


public class Duplicate {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2, 3};

        int[] duplicateElements = findDuplicateElements(nums);

        System.out.print("Duplicate elements: ");
        for (int num : duplicateElements) {
            System.out.print(num + " ");
        }
    }

    public static int[] findDuplicateElements(int[] nums) {
        Arrays.sort(nums);  // Sort the array first

        int n = nums.length;
        int[] duplicateElements = new int[n];
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                duplicateElements[count++] = nums[i];
                while (i < n - 1 && nums[i] == nums[i + 1]) {
                    i++;  // Skip consecutive duplicates
                }
            }
        }

        int[] result = Arrays.copyOf(duplicateElements, count);
        return result;
    }
}
