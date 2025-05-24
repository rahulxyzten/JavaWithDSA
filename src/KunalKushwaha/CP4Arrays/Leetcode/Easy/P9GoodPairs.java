package KunalKushwaha.CP4Arrays.Leetcode.Easy;
/*
1512. Number of Good Pairs

Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.



Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0


Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
 */

import java.util.HashMap;

public class P9GoodPairs {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println(numIdenticalPairs(nums));

    }

    //Optimal approach T(C) = O(N) and S(C) = O(N)
    //Explanation
    /*Imagine this problem like, There is a gathering organized by some guy, the guest list is [1,2,3,1,1,3].
    The problem with the guest is they only handshake with like minded people. (Like minded here is basically the digit should be same ,
    for example, 1 will handshake with 1 only, 2 will handshake with 2 only and so on)

    So, finally we just need to count number of handshakes in the gathering.

    (To distinguish , multiple 1's and 3's , a,b,c,d... letters are used)

    🔥 the day of arrival 🔥

    one by one guests are arriving at the gathering

    ✅ first guest: 1

    ✅ second guest: 2
    (at this moment, in gathering hall we have 1 (2 is about to enter) , since they are not like minded they wont shake hands)

    ✅ third guest:3
    (at this moment, in gathering hall we have 1 ,2 (3 is about to enter), since they are not like minded they wont shake hands)

    ✅ fourth guest : 1
    (at this moment, fourth guest will see in gathering hall , there is one like minded guy ie(1) , so he will handshake with him)
    therefore totalHandShake = 1

    ✅ fifth guest : 1
    (at this moment, fifth guest will see in gathering hall, there are two like minded guys ie(1,1) , so he will handshake with them)
    therefore totalHandShake = 1(last handshake between 1a-1b ) + 2(current handshake between 1a-1c, 1b-1c) = 3

    ✅ sixth guest : 3
    (at this moment, sixth guest will see in gathering hall, there is one like minded guy ie(3) , so he will handshake with him)
    therefore totalHandShake = 3(last handshake) + 1(3a-3b) = 4 */
    public static int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            int count = mp.getOrDefault(num, 0);
            ans += count;
            mp.put(num, count + 1);
        }
        return ans;
    }


    //Brute force approach T(C) = O(N^2) and S(C) = O(1)
//    public static int numIdenticalPairs(int[] nums) {
//        int c = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] == nums[j]) {
//                    c++;
//                }
//            }
//
//        }
//
//        return c;
//    }
}
