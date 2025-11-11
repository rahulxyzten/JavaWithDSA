package TakeYouforward.Array.LeetCode.Medium;
//problem
/*
121. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
 */

public class P11BestTimeBuySellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }


    /*Optimal Solution*/
    //T(C) = O(n), S(C) = O(1)
    public static int maxProfit(int[] prices) {
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxPro = Math.max(maxPro, price - minPrice);
        }

        return maxPro;
    }


    /*Brute or Better Approach*/
    //T(C) = O(n^2), S(C) = O(1)
    //This code fails some test cases because it's T(C) = O(n^2)
//    public static int maxProfit(int[] prices) {
//        int maxPro = 0;
//        int n = prices.length;
//
//        for (int i = 0; i < n; i++) {
//            for (int j =  i + 1; j < n ; j++) {
//                if (prices[j] > prices[i]){
//                    maxPro = Math.max(maxPro, prices[j] - prices[i]);
//                }
//            }
//        }
//
//        return maxPro;
//    }


    /*
    My code out of 212 testcases 154 passed because
     prices = {2,4,1}
     my o/p = 0
     expected output = 2
    */
//    public static int maxProfit(int[] prices) {
//        int n = prices.length;
//        int min = Integer.MAX_VALUE;
//        int minIndex = 0;
//        for (int i = 0; i < n; i++) {
//           if (prices[i] < min){
//               min = prices[i];
//               minIndex = i;
//           }
//        }
//        int result = 0;
//        for (int i = minIndex; i < n; i++) {
//            result = Math.max(result,(prices[i] - prices[minIndex]));
//        }
//
//
//        return result;
//    }
}
