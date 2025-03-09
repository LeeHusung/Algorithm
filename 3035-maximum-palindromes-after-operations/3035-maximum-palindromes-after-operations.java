class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int n = words.length;
        Map<Character, Integer> cntMap = new HashMap<>();
        for (String str : words) {
            for (char ch : str.toCharArray()) {
                cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
            }
        }

        int pairs = 0;
        for (int value : cntMap.values()) {
            pairs += value / 2;
        }

        int answer = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (int i = 0; i < words.length; i++) {
            if ((pairs -= words[i].length() / 2) < 0) return i;
        }
        return n;
    }
}