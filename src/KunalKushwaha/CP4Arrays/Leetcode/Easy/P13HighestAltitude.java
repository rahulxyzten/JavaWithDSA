package KunalKushwaha.CP4Arrays.Leetcode.Easy;
/*
1732. Find the Highest Altitude

There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.

You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i and i + 1 for all (0 <= i < n). Return the highest altitude of a point.


Example 1:

Input: gain = [-5,1,5,0,-7]
Output: 1
Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
Example 2:

Input: gain = [-4,-3,-2,-1,4,3,2]
Output: 0
Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.


Constraints:

n == gain.length
1 <= n <= 100
-100 <= gain[i] <= 10
 */

/*
Starting at point 0 with altitude 0.
After the first step, the altitude becomes 0 + (-5) = -5.
After the second step, the altitude becomes -5 + 1 = -4.
After the third step, the altitude becomes -4 + 5 = 1.
After the fourth step, the altitude becomes 1 + 0 = 1.
After the fifth step, the altitude becomes 1 + (-7) = -6.
 */

public class P13HighestAltitude {
    public static void main(String[] args) {
        int[] gain = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println(largestAltitude(gain));

    }

    public static int largestAltitude(int[] gain) {
        int maxaltitude = 0;
        //maxaltitude is 0 in the starting u have to see
        //if a number is greater than max u change the maxaltitude
        int altitude = 0;
        for (int i = 0; i < gain.length; i++) {
            altitude += gain[i];
//            if(altitude > maxaltitude){
//                maxaltitude = altitude;
//            }
            maxaltitude = Math.max(maxaltitude, altitude);
        }
        return maxaltitude;
    }
}
