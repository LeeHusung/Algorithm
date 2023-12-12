import java.util.*;
class Solution {
    
    public int[] solution(int[] fees, String[] records) {

        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> parkMap = new HashMap<>();
        for (String x : records) {
            String[] one = x.split(" ");
            if (one[2].equals("IN")) {
                inMap.put(one[1], getTime(one[0]));
            }
            if (one[2].equals("OUT")) {
                for (String key : inMap.keySet()) {
                    if (one[1].equals(key)) {
                        int parkTime = getTime(one[0]) - inMap.get(key);
                        parkMap.put(key, parkMap.getOrDefault(key, 0) + parkTime);
                        inMap.put(key, 1000000);
                        // System.out.println(key + " " + parkTime);
                    }
                }
            }
        }
    
        for (String key : inMap.keySet()) {
            if (inMap.get(key) != 1000000) {
                parkMap.put(key, parkMap.getOrDefault(key, 0) + getTime("23:59") - inMap.get(key));
            }
        }
    
        
        Map<String, Integer> resultMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String key : parkMap.keySet()) {
            list.add(key);
            if (parkMap.get(key) <= fees[0]) {
                resultMap.put(key, fees[1]);
            } else {
                double ceil = Math.ceil((double)(parkMap.get(key) - fees[0]) / fees[2]);
                // System.out.println(ceil);
                int fee = fees[1] + (int) ceil * fees[3];
                resultMap.put(key, fee);
            }
        }
            
//         for (String key : resultMap.keySet()) {
//             System.out.println(key + " " + resultMap.get(key));
//         }
        Collections.sort(list);
        
        int[] answer = new int[resultMap.size()];
        int idx = 0;
        for (String key : list) {
            answer[idx++] = resultMap.get(key);
        }
        
        return answer;
    }
    
    public int getTime(String time) {
        String[] s = time.split(":");
        int h = Integer.parseInt(s[0]) * 60;
        int m = Integer.parseInt(s[1]);
        return h + m;
    }
}