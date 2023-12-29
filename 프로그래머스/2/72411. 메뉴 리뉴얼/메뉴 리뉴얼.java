import java.util.*;
class Solution {
    Map<String, Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    public void D(int size, int L, int start, String order, StringBuilder sb) {
        if (L == size) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            D(size, L + 1, i + 1, order, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
//     public void D2(int size, int L, int start, String order, StringBuilder sb) {
//         if (L == size) {
//             map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
//             return;
//         }
        
//         for (int i = start; i >= 0; i--) {
//             sb.append(order.charAt(i));
//             D2(size, L + 1, i - 1, order, sb);
//             sb.deleteCharAt(sb.length() - 1);
//         }
//     }
    public String[] solution(String[] orders, int[] course) {
        Set<String> res = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            int size = course[i];
            for (String order : orders) {   
                char[] orderArr = order.toCharArray();
                Arrays.sort(orderArr);
                D(size, 0, 0, new String(orderArr), new StringBuilder());
                // D2(size, 0, order.length() - 1, order, new StringBuilder());
            }
            
        }
        for (int size : course) {
            int max = Integer.MIN_VALUE;
            for (String key : map.keySet()) {
                if (size == key.length()) {
                    // System.out.println("key : " + key + " value : " + map.get(key));
                    max = Math.max(map.get(key), max);
                }
            }
            
            for (String key : map.keySet()) {
                if (map.get(key) == max && size == key.length() && map.get(key) > 1) {
                    list.add(key);
                }
            }
            for (String x : list) {
                char[] carr = x.toCharArray();
                Arrays.sort(carr);
                String str = "";
                for (char ch : carr) {
                    str += String.valueOf(ch);
                }
                res.add(str);
            }
        }
        String[] answer = new String[res.size()];
        int idx = 0;
        for (String x : res) {
            answer[idx++] = x; 
        }
        Arrays.sort(answer);
        return answer;
    }
}