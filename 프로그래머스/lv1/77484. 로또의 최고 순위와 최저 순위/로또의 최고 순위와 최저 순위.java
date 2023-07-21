class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int count = 0;
        for (int i = 0; i<lottos.length; i++) {
            for (int j = 0; j<win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    count++;
                }
            }
        }
            if (count == 0) {answer[1] = 6;}
            else if (count == 1) {answer[1] = 6;}
            else if (count == 2) {answer[1] = 5;}
            else if (count == 3) {answer[1] = 4;}
            else if (count == 4) {answer[1] = 3;}
            else if (count == 5) {answer[1] = 2;}
            else if (count == 6) {answer[1] = 1;}
        
        int countZero = 0;
        for(int i = 0; i<lottos.length; i++) {
            if (lottos[i] == 0) {
                countZero++;
            }
        }
        if (countZero == 0) {answer[0] = answer[1];}
        if (countZero == 1) {answer[0] = answer[1]-1;}
        if (countZero == 2) {answer[0] = answer[1]-2;}
        if (countZero == 3) {answer[0] = answer[1]-3;}
        if (countZero == 4) {answer[0] = answer[1]-4;}
        if (countZero == 5) {answer[0] = answer[1]-5;}
        if (countZero == 6) {answer[0] = answer[1]-5;}
        
        
        
        
        
        return answer;
    }
}