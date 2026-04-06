import java.util.*;
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st = new Stack<>();
        for (char x : s.toCharArray()) {
            if (!st.isEmpty()) {
                int[] p = st.peek();
                // System.out.println(p[0] + " " + p[1]);
                if (p[0] == x) {
                    p[1] = p[1] + 1;
                    if (p[1] == k) {
                        st.pop();
                    }
                    continue;    
                }
            }
            st.push(new int[]{x, 1});
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            int[] tmp = st.pop();
            while (tmp[1] --> 0) {
                sb.append((char) tmp[0]);
            }
        }
        return sb.reverse().toString();
    }
}