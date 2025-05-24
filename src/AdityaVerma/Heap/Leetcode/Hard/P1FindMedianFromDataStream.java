package AdityaVerma.Heap.Leetcode.Hard;
//Problem (Anuj Bhaiya Solution)
//LeetCode
/*
295. Find Median from Data Stream

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.


Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0


Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.


Follow up:

If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 */

//CodeStudio
/*
Median in a stream

Given that integers are read from a data stream. Your task is to find the median of the elements read so far.

Median is the middle value in an ordered integer list. If the size of the list is even there is no middle value. So the median is the floor of the average of the two middle values.

For example :
[2,3,4] - median is 3.
[2,3] - median is floor((2+3)/2) = 2.


Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 10
1 <= N <= 10^4
0 <= data <= 10^8
Where T is the number of test cases, N is the number of elements in the data stream.

Time Limit : 1 sec
Sample Input 1:
3
3
1 2 3
2
9 9
1
4
Sample Output 1:
1 1 2
9 9
4
Explanation for Sample Input 1:
For test case 1
After reading first element of stream , Median of [1] is 1
After reading second element of stream, Median of [1, 2]  = floor((1+2)/2)  = 1
After reading third element of stream, Median of [1,2,3] = 2
So the output will be 1 1 2.
Sample Input 2:
2
3
5 3 8
2
3 8
Sample Output 2:
5 4 5
3 5
Explanation for Sample Input 2:
For test case 1
After reading first element of stream, Median of [5] is 5
After reading second element of stream, Median of [5, 3]  = floor((5+3)/2)  = 4
After reading third element of stream, Median of [5,3,8] = 5 , it is the middle value of the sorted array
So the output will be 5 4 5.
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class P1FindMedianFromDataStream {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(findMedian(arr, arr.length)));
    }

    //codeStdio
    //T(C) = O(nlogn)
    //S(C) = O(n)
    public static int[] findMedian(int[] arr, int n) {
        int[] result = new int[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        for (int num : arr) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= num)
                maxHeap.add(num);
            else
                minHeap.add(num);

            //Either both heap will be equal number of elements or maxHeap will be one more elements than minHeap
            if (maxHeap.size() > minHeap.size() + 1)
                minHeap.add(maxHeap.poll());
            else if (maxHeap.size() < minHeap.size())
                maxHeap.add(minHeap.poll());

            if (maxHeap.size() == minHeap.size())
                result[i++] = (minHeap.peek() + maxHeap.peek()) / 2;
            else
                result[i++] = maxHeap.peek();
        }

        return result;
    }
}

//LeetCode
//T(C) = O(nlogn)
//addNum(int num) takes logn
//If n element inserted then nlogn
//findMedian() takes O(1)
//S(C) = O(n)
//n element is divided two parts one part go to minHeap and one part go to  maxHeap

class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else
            minHeap.add(num);

        //Either both heap will be equal number of elements or maxHeap will be one more elements than minHeap
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        return maxHeap.peek();
    }
}
