
package Stack;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Taking input of number of intervals
        int[][] arr = new int[sc.nextInt()][2];

        //Each row represents one interval [start, end]
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        mergeIntervals(arr);
    }

    private static void mergeIntervals(int[][] arr) {

        //Base case: If there are no intervals, nothing to merge
        if (arr.length == 0) return;

        //Creating an array of Pair objects
        //Each Pair stores the starting and ending point of an interval
        Pair[] pairs = new Pair[arr.length];

        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }

        //Sorting intervals based on starting point
        //Comparable is used to define the natural ordering of Pair objects
        //After sorting, intervals with smaller starting points come first
        Arrays.sort(pairs);

        //Stack is used to store merged intervals
        //The top of the stack always represents the last merged interval
        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            //First interval: No previous interval exists to compare with
            if (i == 0) {
                st.push(pairs[i]);
            } else {

                //If current interval starts after the ending point
                //of the previous merged interval, there is no overlap
                //So we push it as a separate interval
                if (pairs[i].st > st.peek().et) {
                    st.push(pairs[i]);
                } else {

                    //Overlap exists between current and previous interval
                    //peek() gives the top Pair without removing it
                    Pair top = st.peek();

                    //Merging intervals by updating the ending point
                    //Math.max() ensures that the larger ending point is retained
                    top.et = Math.max(pairs[i].et, top.et);

                }
            }
        }

        //At this point, Stack contains all merged intervals
        //But Stack follows LIFO (Last In First Out)
        //So popping directly would give intervals in reverse order

        Stack<Pair> result = new Stack<>();

        //Reversing the stack to get intervals in their original sorted order
        while (!st.isEmpty()) {
            result.push(st.pop());
        }

        //Printing merged intervals in ascending order
        while (!result.isEmpty()) {
            Pair p = result.pop();
            System.out.println(p.st + " " + p.et);
        }

    }

    //Custom Pair class to represent an interval
    //Comparable<Pair> allows Pair objects to be sorted using Arrays.sort()
    static class Pair implements Comparable<Pair> {
        int st, et;

        Pair(int st, int et) {
            this.st = st;
            this.et = et;
        }

        //Defining how two Pair objects should be compared during sorting
        @Override
        public int compareTo(Pair other) {

            //Primary sorting condition: Compare starting points
            if (this.st != other.st) {
                return this.st - other.st;
            } else {

                //If starting points are equal, compare ending points
                //This ensures intervals with smaller ending points come first
                return this.et - other.et;
            }
        }
    }
}
