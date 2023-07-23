class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        String str = "RTCFJMAN";
        
        int[] iarr = new int[] {0,0,0,0,0,0,0,0};
        
        int index = 0;
        for (int i = 0; i<choices.length; i++) {
            if (choices[i] == 1) {
                 index = str.indexOf(survey[i].substring(0,1));
                iarr[index] += 3;
            } else if (choices[i] == 2) {
                 index = str.indexOf(survey[i].substring(0,1));
                iarr[index] += 2;
            } else if (choices[i] == 3) {
                 index = str.indexOf(survey[i].substring(0,1));
                iarr[index] += 1;
            } else if (choices[i] == 4) {
                continue;
            } else if (choices[i] == 5) {
                 index = str.indexOf(survey[i].substring(1));
                iarr[index] += 1;
            } else if (choices[i] == 6) {
                 index = str.indexOf(survey[i].substring(1));
                iarr[index] += 2;
            } else if (choices[i] == 7) {
                 index = str.indexOf(survey[i].substring(1));
                iarr[index] += 3;
            }
        }
        
        if (iarr[0] > iarr[1]) {
            answer += "R";
        } else if (iarr[0] < iarr[1]) {
            answer += "T";
        } else {
            answer += "R";
        }
        
        if (iarr[2] > iarr[3]) {
            answer += "C";
        } else if (iarr[2] < iarr[3]) {
            answer += "F";
        } else {
            answer += "C";
        }
        if (iarr[4] > iarr[5]) {
            answer += "J";
        } else if (iarr[4] < iarr[5]) {
            answer += "M";
        } else {
            answer += "J";
        }
        if (iarr[6] > iarr[7]) {
            answer += "A";
        } else if (iarr[6] < iarr[7]) {
            answer += "N";
        } else {
            answer += "A";
        }

        
        
        return answer;
    }
}