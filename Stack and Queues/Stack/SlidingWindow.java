package Stack;

import java.util.*;

public class SlidingWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] nge = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        Stack<Integer> st = new Stack<>();
        // Push last index into stack
        st.push(n - 1);
        // Last element has no greater element to its right
        // so mark it as n (outside array boundary)
        nge[n - 1] = n;

        for (int i = n - 2; i >= 0; i--) {
            // Remove all smaller elements from stack
            // because they cannot be next greater for arr[i]
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                st.pop();
            }
            // If stack is empty,
            // there is no greater element on right
            if (st.isEmpty()) {
                nge[i] = n;
            } else {
                // Top of stack is the next greater element index
                nge[i] = st.peek();
            }

            st.push(i);
        }
        int[] res = new int[n - k + 1];
        int p = 0;// Pointer for result array
        int j = 0; // Pointer used to jump through next greater elements

        for (int i = 0; i <= n - k; i++) {
            // If current pointer j is outside current window,
            // reset it to window start
            if (j < i) {
                j = i;
            }
            // Jump to next greater element
            // as long as it lies inside current window
            while (nge[j] < i + k) {
                j = nge[j];
            }
            // Current j is maximum element index in this window
            // store its value
            res[p++] = arr[j];
        }
        // Print result array
        System.out.println(Arrays.toString(res));
    }
}