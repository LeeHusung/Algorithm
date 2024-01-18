import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> enrollMap = new HashMap<>();
        Map<String, String> referralMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            enrollMap.put(enroll[i], 0);
            referralMap.put(enroll[i], referral[i]);
        }
        for (int i = 0; i < seller.length; i++) {
            int price = amount[i] * 100;
            String person = seller[i];
            boolean flag = true;
            while (flag) {
                if (person.equals("-")) break;
                if (price == 0) break;
                
                if (price < 10) {
                    map.put(person, map.getOrDefault(person, 0) + price);
                    flag = false;
                    break;
                }
                int tenPer = price / 10;
                
                map.put(person, map.getOrDefault(person, 0) + price - tenPer);
                // System.out.println("person : " + person + ", map.get(person) : " + map.get(person));
                person = referralMap.get(person);
                price = tenPer;
                flag = true;
                
            } flag = false;
            
        }
        
        for (int i = 0; i < enroll.length; i++) {
            if (map.containsKey(enroll[i])) {
                answer[i] = map.get(enroll[i]);
            }
        }
        
        
        
        return answer;
    }
}