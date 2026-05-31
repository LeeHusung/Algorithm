import java.util.*;
class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort(
            Comparator.comparingInt((List<String> inner) -> Integer.parseInt(inner.get(1)))
                    .thenComparing(Comparator.comparing((List<String> inner) -> inner.get(0)).reversed())
        );
        int[] mentions = new int[numberOfUsers];
        int[] offArray = new int[numberOfUsers];

        for (List<String> event : events) {
            // System.out.println(event.get(0) + " " + event.get(1) + " " + event.get(2));
            // for (int mention : mentions) {
            //     System.out.print(mention + " ");
            // }
            // System.out.println();
            int now = Integer.valueOf(event.get(1));
            for (int i = 0; i < offArray.length; i++) {
                if (offArray[i] + 60 <= now) {
                    offArray[i] = 0;
                }
            }
            String type = event.get(0);
            if ("OFFLINE".equals(type)) {
                offArray[Integer.valueOf(event.get(2))] = Integer.valueOf(event.get(1));
            } 
            else {
                // for (int kk : offArray) {
                //     System.out.print(kk + " ");
                // }
                // System.out.println();
                switch (event.get(2)) {
                    case "ALL" -> {
                        for (int i = 0; i < mentions.length; i++) {
                            mentions[i]++;
                        }
                    }
                    case "HERE" -> {
                        for (int i = 0; i < mentions.length; i++) {
                            if (offArray[i] == 0) {
                                mentions[i]++;
                            }
                        }
                    }
                    default -> {
                        String[] split = event.get(2).split(" ");
                        for (String x : split) {
                            int user = Integer.valueOf(x.substring(2));
                            mentions[user]++;
                        }
                    }
                }
            }
        }
        return mentions;
    }
}