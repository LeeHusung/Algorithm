import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String sb = "";
        
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String records : record) {
            String[] recordSplit = records.split(" ");
            if (recordSplit[0].equals("Enter") || recordSplit[0].equals("Change")) {
                map.put(recordSplit[1], recordSplit[2]);
            }
        }
        
        for (String records : record) {
            String[] recordSplit = records.split(" ");
            if (recordSplit[0].equals("Enter")) {
                list.add(map.get(recordSplit[1]) + "님이 들어왔습니다.");
            }
            if (recordSplit[0].equals("Leave")) {
                list.add(map.get(recordSplit[1]) + "님이 나갔습니다.");
            }
            
            
        }
        String[] answer = list.toArray(new String[0]);
        
        
        
        
        return answer;
    }
}