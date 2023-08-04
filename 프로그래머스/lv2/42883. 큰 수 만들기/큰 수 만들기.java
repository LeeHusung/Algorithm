class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        //뒤에서부터 필요한 최소자리수 만 남기고 앞에서 가장 큰 수 탐색하면됨
    
        StringBuilder sb = new StringBuilder();
        int answerLength = number.length() - k;
        int start = 0;
        
        while (sb.length() != answerLength && start < number.length()) {
            int max = 0;
            int n = sb.length() + k + 1; //필요한 최소 자리수 남기기 위해 여기까지만 반복 돌아
            for (int i = start; i<n; i++) {
                if (number.charAt(i) - '0' > max) {
                    max = number.charAt(i) - '0';
                    start = i+1; //가장 큰 자릿수 구했으니 그 앞 숫자들은 다 버림
                }
            }
            sb.append(max);
        }
        
        
        
        answer = sb.toString();
        
        return answer;
    }
}