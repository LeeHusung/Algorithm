import java.util.*;
//두 수의 곱 a * b = 최소공배수 * 최소공약수
class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
    
    // 최대 공약수 계산 함수
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // 최소 공배수 계산 함수
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
