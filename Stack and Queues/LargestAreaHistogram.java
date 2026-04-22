import java.util.*;

public class LargestAreaHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] rb = new int[n];// right boundary -> index of Next Smaller Element on the right
        Stack<Integer> st = new Stack<>();
        st.push(a.length - 1);
        rb[a.length - 1] = a.length;
        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && a[st.peek()] >= a[i]) {
                st.pop();
            }

            if (st.size() == 0) {
                rb[i] = n;
            } else {
                rb[i] = st.peek();
            }

            st.push(i);
        }

        st = new Stack<>();

        int[] lb = new int[n];// right boundary -> index of Next Smaller Element on the left
        st.push(0);
        lb[0] = -1;

        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && a[st.peek()] >= a[i]) {
                st.pop();
            }

            if (st.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }

            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = a[i] * width;
            maxArea = Math.max(area, maxArea);
        }
        System.out.println(maxArea);
    }
}