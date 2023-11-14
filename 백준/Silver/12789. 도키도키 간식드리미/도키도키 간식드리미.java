//백준
//https://www.acmicpc.net/problem/12789

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int start = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != start) {
                st.push(arr[i]);
                continue;
            }
            if (arr[i] == start) {
                start++;
                while (!st.isEmpty()) {
                    if (st.peek() != start) break;
                    else {
                        st.pop();
                        start++;
                    }
                }
                continue;
            }
        }
        while (!st.isEmpty()) {
            int p = st.peek();
            if (p != start) break;
            else {
                st.pop();
                start++;
            }
        }

        if (st.size() == 0) System.out.println("Nice");
        else System.out.println("Sad");
    }
}
