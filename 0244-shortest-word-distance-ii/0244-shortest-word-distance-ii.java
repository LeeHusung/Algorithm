import java.util.*;
class WordDistance {
    String[] tmp;
    Map<String, List<Integer>> map = new HashMap<>();
    public WordDistance(String[] wordsDict) {
        tmp = wordsDict;
        for (int i = 0; i < wordsDict.length; i++) {
            if (map.containsKey(wordsDict[i])) {
                map.get(wordsDict[i]).add(i + 1);
            }
            else {
                map.put(wordsDict[i], new ArrayList<>());
                map.get(wordsDict[i]).add(i + 1);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for (int x : list1) {
            for (int y : list2) {
                res = Math.min(res, Math.abs(x - y));
            }
        }

        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */