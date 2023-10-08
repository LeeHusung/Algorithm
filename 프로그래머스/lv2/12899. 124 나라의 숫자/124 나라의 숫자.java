class Solution {
    public String solution(int n) {
        String answer = "";
        
        while(n != 0) {
            int r = n % 3;
            n /= 3;
            if (r == 0) {
                answer = "4" + answer;
                n -= 1;
            } else if (r == 1) {
                answer = "1" + answer;
            } else if (r == 2) {
                answer = "2" + answer;
            }
            
        }
        
//         String third = Integer.toString(n, 3);
//         int idx = -1;
//         for (int i = 0; i<third.length(); i++) {
            
//             idx = third.lastIndexOf('0');
//         System.out.println(idx);
            
//             if (idx > -1) {
//                 int k = 6;
//                 for(int j = 1; j < idx; j++) {
//                     k *= 10;
//                 }
//                 answer = String.valueOf(Integer.parseInt(third) - k);
//             } else {
//                 answer = third;
//             }
//         }
        
        
        
        return answer;
    }
}