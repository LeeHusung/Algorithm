import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 오늘 날짜
        String today2 = today.replace(".", "");
        int year = Integer.parseInt(today2.substring(0, 4));
        int month = Integer.parseInt(today2.substring(4, 6));
        int day = Integer.parseInt(today2.substring(6, 8));

        int cnt = (year * 12 * 28) + (month * 28) + day;

        int[] answer = new int[privacies.length];
        int idx = 0;

        for (int i = 0; i < privacies.length; i++) {
            String[] pSplit = privacies[i].split(" ");

            // 약관 유효기간 찾기
            int num = 0;
            for (int j = 0; j < terms.length; j++) {
                String[] tSplit = terms[j].split(" ");
                if (pSplit[1].equals(tSplit[0])) {
                    num = Integer.parseInt(tSplit[1]);
                    break;
                }
            }

            String[] pSplitDate = pSplit[0].split("\\.");

            int pYear = Integer.parseInt(pSplitDate[0]);
            int pMonth = Integer.parseInt(pSplitDate[1]);
            int pDay = Integer.parseInt(pSplitDate[2]);

            // 유효기간 만큼 개인정보 파기 날짜 계산
            int expiryYear = pYear;
            int expiryMonth = pMonth + num;
            while (expiryMonth > 12) {
                expiryYear++;
                expiryMonth -= 12;
            }

            // 개인정보 파기 날짜를 오늘 날짜로 변환하여 비교
            int cnt2 = (expiryYear * 12 * 28) + (expiryMonth * 28) + pDay - 1;
            if (cnt > cnt2) {
                answer[i] = i + 1; 
         
        }
    }
    
    
            int a = 0;
            for(int i = 0; i<answer.length; i++) {
                if(answer[i]>0){
                    a++;
                }
            }
        int[] arr = new int[a];
        int index = 0;
        for (int i = 0; i<answer.length; i++) {
            if (answer[i] > 0) {
                arr[index] = answer[i];
                index++;
            }
        }
        return arr;
    }
}
