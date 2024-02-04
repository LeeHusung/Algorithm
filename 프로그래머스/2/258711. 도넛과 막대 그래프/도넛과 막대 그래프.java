// import java.util.*;
// class Solution {
//     static int newNode = 0;
//     static int makdae = 0;
//     static int donut = 0;
//     static int eight = 0;
//     static int[] ch;
//     static Queue<Integer> q = new LinkedList<>();
//     static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
//     public int[] solution(int[][] edges) {
//         int[] answer = new int[4];
        
//         int max = 0;
//         for (int[] x : edges) {
//             max = Math.max(max, x[0]);
//             max = Math.max(max, x[1]);
//         }
        
//         for (int i = 0; i <= max; i++) {
//             graph.add(new ArrayList<>());
//         }
        
//         for (int[] x : edges) {
//             graph.get(x[0]).add(x[1]);
//         }
        
//         for (int i = 1; i <= max; i++) {
//             boolean flag = false;
//             if (graph.get(i).size() >= 2) {
//                 for (int j = 1; j<= max; j++) {
//                     if (graph.get(j).contains(i)) {
//                         flag = false;
//                         break;
//                     } else flag = true;
//                 }
//             }
//             if (flag) newNode = i;
//         }
        
//         ch = new int[max + 1];
        
//         for (int[] x : edges) {
//             if (ch[x[0]] == 0 && x[0] != newNode) {
//                 ch[x[0]] = 1;
//                 q.offer(x[1]);
//                 check();
//             }
//         }
        
//         answer[0] = newNode;
//         answer[1] = donut;
//         answer[2] = makdae;
//         answer[3] = eight;
        
//         return answer;
//     }
    
//     public static void check() {
//         while(!q.isEmpty()) {
//             int p = q.poll();
//             if (graph.get(p).size() == 0) makdae++;
//             if (graph.get(p).size() > 1) {
//                 eight++;
//                 System.out.println("p : " + p + ", eight : " + eight);
//             }
//             // System.out.println(p);
//             for (int x : graph.get(p)) {
//                 if (ch[x] == 1 && graph.get(p).size() == 1) {
//                     // System.out.println("sayhi");
//                     donut++;
//                 }
//                 if (ch[x] == 0) {
//                     ch[x] = 1;
//                     q.offer(x);
//                 }
//             }
//         }
//     }
// }

import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, int[]> map = new HashMap<>();
        
        for (int[] x : edges) {
            if (!map.containsKey(x[0])) {
                map.put(x[0], new int[2]);
            }
            if (!map.containsKey(x[1])) {
                map.put(x[1], new int[2]);
            }
            
            map.get(x[0])[0]++;
            map.get(x[1])[1]++;
        }
        
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] value = entry.getValue();
            if (value[0] >= 2 && value[1] >= 2) answer[3]++;
            else if (value[1] == 0 && value[0] >= 2) answer[0] = entry.getKey();
            else if (value[0] == 0 && value[1] > 0) answer[2]++;
        }
        answer[1] = map.get(answer[0])[0] - answer[2] - answer[3];
        
        
        return answer;
    }
}

// import java.util.*;

// class Solution {
//     public int[] solution(int[][] edges) {
//         int[] answer = new int[4];
//         Map<Integer, int[]> exchangeCnts = new HashMap<>();

//         for (int[] edge : edges) {
//             int a = edge[0];
//             int b = edge[1];

//             if (!exchangeCnts.containsKey(a)) {
//                 exchangeCnts.put(a, new int[2]);
//             }
//             if (!exchangeCnts.containsKey(b)) {
//                 exchangeCnts.put(b, new int[2]);
//             }

//             exchangeCnts.get(a)[0] += 1;
//             exchangeCnts.get(b)[1] += 1;
//         }

//         for (Map.Entry<Integer, int[]> entry : exchangeCnts.entrySet()) {
//             int[] exchangeCnt = entry.getValue();
            
//             if (exchangeCnt[0] >= 2 && exchangeCnt[1] == 0) {
//                 answer[0] = entry.getKey();
//             } else if (exchangeCnt[0] == 0 && exchangeCnt[1] > 0) {
//                 answer[2]++;
//             } else if (exchangeCnt[0] >= 2 && exchangeCnt[1] >= 2) {
//                 answer[3]++;
//             }
//         }

//         answer[1] = exchangeCnts.get(answer[0])[0] - answer[2] - answer[3];
//         return answer;
//     }
// }
