package KunalKushwaha.CP4Arrays.Leetcode.Easy;

/*
1217. Minimum Cost to Move Chips to The Same Position

We have n chips, where the position of the ith chip is position[i].

We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:

position[i] + 2 or position[i] - 2 with cost = 0.
position[i] + 1 or position[i] - 1 with cost = 1.
Return the minimum cost needed to move all the chips to the same position.

Example 1:

Input: position = [1,2,3]
Output: 1
Explanation: First step: Move the chip at position 3 to position 1 with cost = 0.
Second step: Move the chip at position 2 to position 1 with cost = 1.
Total cost is 1.

Example 2:

Input: position = [2,2,2,3,3]
Output: 2
Explanation: We can move the two chips at position  3 to position 2. Each move has cost = 1. The total cost = 2.
Example 3:

Input: position = [1,1000000000]
Output: 1

Constraints:
1 <= position.length <= 100
1 <= position[i] <= 10^9
 */

//Youtube video
//https://www.youtube.com/watch?v=FPgC3RfHMBI

/*
The question statement is a bit confusing. The chips array is basically any chip which is at some position and that position is given to us in the
 form of an array. So in case of 2,2,2,3,3 there are 5 chips. 3 chips are at position 2 and 2 chips are at position 3. So our aim is to move all
 the chips to single position and in this case position 2 or position 3.

The logic here is that the minimum number of odd values and even values that are given in chips array will be result in minimum cost.
Moving element at odd to even position will cost 1 and even to odd position will cost 1. Whereas moving odd to odd position costs 0 and
even to even position also costs 0.

Eg: 1 1 2 2 2 4 4

Here, there are 2 chips which are at position 1, 3 chips at position 2 and 2 chips at position 4.
Our aim is to move all the chips to one position and in this case all 1's will move to position 2 with a cost of 1 (1 is 1 unit away from 2)
 and all 4's can move to position 2 with a cost of 0 (4 is 2 units left from 2).
Also, all 1's can move to position 4 with a cost of only 1 (1 + 2units +1unit) and all 2's can move to position 4 with cost of 0.
So the answer is 2.
 */

/*
Optimize code : Just remember one thing , odd-even index are always at neighbour right ?(means after even index always odd index come and vice-versa).

Intuition* :
1.The chips at even index can be shifted to any even index with cost 0. right ?
2.The chips at odd index can be shifted to any odd index with cost 0 . right ?(because taking 2-step move cost 0 )

if you agree with my both statement, then shift all chips to any even and odd index position which are neighbour with cost 0 till now.

Now we have two tower on adjacent odd-even position ,

one tower of the chips at even index
one tower of the chips at odd index
we need to shift one tower to other tower . so take minimum of both tower which cost minimum cost of movement.
 */

public class P23MinimumCostChips {
    public static void main(String[] args) {
        int[] position = {2,2,2,3,3};
        System.out.println(minCostToMoveChips(position));
    }
    public static int minCostToMoveChips(int[] position) {
        int evenPosTowerChips = 0;
        int oddPosTowerChips = 0;
        for (int i : position) {
            if (i % 2 == 0) {
                evenPosTowerChips++;
            } else {
                oddPosTowerChips++;
            }
        }
        return Math.min(oddPosTowerChips, evenPosTowerChips);
    }
}
