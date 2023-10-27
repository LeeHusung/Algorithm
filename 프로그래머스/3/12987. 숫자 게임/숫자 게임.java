import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i = 0; i < A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
        }
        
        for (int i = 0; i < B.length; i++) {
            if (b.get(b.size()-1) > a.get(a.size()-1)) {
                answer++;
                b.remove(b.size()-1);
                a.remove(a.size()-1);
            }
            else {
                a.remove(a.size()-1);
            }
            
        }
        
        return answer;
    }
}