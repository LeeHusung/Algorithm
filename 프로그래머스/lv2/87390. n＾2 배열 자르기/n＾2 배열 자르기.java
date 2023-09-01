import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
//행과 열의 최댓값이 원소의 값.. 규칙 찾기
        int idx = 0;
        for (long i = left; i<=right; i++) {
            answer[idx++] = (int)Math.max(i / n + 1, i % n +1);
        }

        return answer;
    }
}



// import java.util.*;
// class Solution {
//     public long[] solution(int n, long left, long right) {
//         long[] answer = new long[(int)(right - left+1)];
        
//         long[][] newArr = new long[n][n];
        
//         // n,0  '' n,n '' 0,n 
        
//         int a = 1;
//         int k = 0;
//         for (int i = 0; i<newArr.length; i++) {
//             for (int j = 0; j<newArr[i].length; j++) {
//                 if (i == k || j == k) {
//                     newArr[i][j] = a;
//                     newArr[j][i] = a;
//                 }
                
//             }
//             a++;
//             k++;
//         }
//         List<Long> list = new LinkedList<>();
//         for (int i = 0; i<newArr.length; i++) {
//             for (int j = 0; j<newArr[i].length; j++) {
//                 list.add(newArr[i][j]);
//             }
//         }
//         int idx = 0;
//         while (left <= right) {
//             answer[idx] = list.get((int)left);
//             left++;
//             idx++;
//         }
        
//         return answer;
//     }
// }