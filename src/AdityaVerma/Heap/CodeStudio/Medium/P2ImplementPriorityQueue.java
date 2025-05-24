package AdityaVerma.Heap.CodeStudio.Medium;
//Problem
/*
Implement a priority queue

You have to implement the pop function of Max Priority Queue and implement using a heap.



Functions :
a) push(int x) : 'x' has to be inserted in the priority queue. This has been implemented already

b) pop() : return the maximum element in the priority queue, if priority queue is empty then return '-1'.


Example:
We perform the following operations on an empty priority queue:

When operation push(5) is performed, we insert 1 in the priority queue.

When operation push(2) is performed, we insert 2 in the priority queue.

When operation pop() is performed, we remove the maximum element from the priority queue and print which is 5.

When operation push(3) is performed, we insert 1 in the priority queue.

When operation pop() is performed, we remove the maximum element from the priority queue and print which is 3.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
8
1 4
1 9
2
1 5
2
1 10
1 1
2
Sample Output 1 :
9
5
10
Explanation For Sample Output 1 :
After processing 1 4
The elements in the priority queue are 4

After processing 1 9
The elements in the priority queue are 4,9

After processing 2
The largest element which is 9 is printed and removed from the queue
The elements in the priority queue are 4

After processing 1 5
The elements in the priority queue are 4,5

After processing 2
The largest element which is 5 is printed and removed from the queue

After processing 1 10
The elements in the priority queue are 4,10

After processing 1 1
The elements in the priority queue are 1,4,10

After processing 2
The largest element which is 10 is printed and removed from the queue
The elements in the priority queue are 1,4
Sample Input 2 :
8
2
1 6
2
2
2
1 2
1 9
1 5
Sample Output 2 :
-1
6
-1
-1
Constraints :
1 <= n <= 10^6

Time Limit: 1 sec
 */

import java.util.List;

public class P2ImplementPriorityQueue {
    public static void main(String[] args) {

    }
    public static int pop(List<Integer> heap) {

        return 0;
    }
}
