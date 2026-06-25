import java.util.*;
class TimeMap {
    Map<String, LinkedList<Node>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new LinkedList<>());
        }
        map.getOrDefault(key, new LinkedList<>()).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        // System.out.println(map.size());
        LinkedList<Node> list = map.get(key);
        // System.out.println(list);
        if (list == null) return "";
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).timestamp <= timestamp) {
                return list.get(i).value;
            }
        }
        return "";
        
    }

    static class Node {
        String value;
        int timestamp;

        public Node (String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */