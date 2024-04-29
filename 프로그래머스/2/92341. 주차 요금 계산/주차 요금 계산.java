import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
      
        Map<String, Integer> inMap = new HashMap<>();
        TreeMap<String, Integer> resMap = new TreeMap<>();
        for (String x : records) {
            String[] split = x.split(" ");
            if (split[2].equals("IN")) {
                inMap.put(split[1], getTime(split[0]));
            } else if (split[2].equals("OUT")) {
                resMap.put(split[1], resMap.getOrDefault(split[1], 0) + getTime(split[0]) - inMap.get(split[1]));
                inMap.remove(split[1]);
            }
        }
        for (String key : inMap.keySet()) {
            resMap.put(key, resMap.getOrDefault(key, 0) + getTime("23:59") - inMap.get(key));
        }
        int idx = 0;
        int[] answer = new int[resMap.size()];
        for (String key : resMap.keySet()) {
            int sum = 0;
            double parkTime = resMap.get(key);
            // System.out.println(parkTime);
            if (parkTime <= fees[0]) {
                answer[idx++] = fees[1];
                continue;
            }
            if (parkTime > fees[0]) {
                sum += fees[1];
            }
            sum += Math.ceil((parkTime - fees[0]) / fees[2]) * fees[3];
            answer[idx++] = sum;
        }
        
        return answer;
    }
    public int getTime(String time) {
        String[] tSplit = time.split(":");
        int h = Integer.parseInt(tSplit[0]) * 60;
        int m = Integer.parseInt(tSplit[1]);
        return h + m;
    }
}