class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
//         n을 0부터 차례대로 쭉 늘어놔. t개 까지. 그리고 m별로 나눠서 뽑으면 될듯 물론 튜브의 순서별로.
            
//         n == 2, 2진법을 m개까지.
//         n == 16, 16진법을 m개까지.
//         나열만 하면 풀 수 있음.
//         n 123456789ABCDEF1112131415
            
//         0,1,10,11,100,101,110,111.1000 '''
            
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<t*m; i++) {
            String str = Integer.toString(i, n);
            sb.append(str);
        }
        
        for (int i = p; i<t*m+1; i += m) {
            answer += sb.substring(i-1, i);
        }
        answer = answer.toUpperCase();
        return answer;
    }
}