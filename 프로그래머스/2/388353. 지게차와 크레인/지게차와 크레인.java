import java.util.*;
class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] k;
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        char[][] arr = new char[storage.length][storage[0].length()];
        k = new int[storage.length][storage[0].length()];
        for (int i = 0; i < storage.length; i++) {
            arr[i] = storage[i].toCharArray();
        }
        
        for (String x : requests) {
            List<int[]> list = new ArrayList<>();
            k = new int[storage.length][storage[0].length()];
            if (x.length() == 1) {
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        if ((i == 0 || j == 0 || i == arr.length - 1 || j == arr[i].length - 1) && arr[i][j] == '0') {
                            list.add(new int[]{i, j});
                            // bfs(i, j, arr, x.charAt(0));
                        }
                        if ((i == 0 || j == 0 || i == arr.length - 1 || j == arr[i].length - 1) && arr[i][j] == x.charAt(0)) {
                            arr[i][j] = '0';
                            k[i][j] = -1;
                        }
                    }
                }
                bfs (list, arr, x.charAt(0));
            } else if (x.length() == 2) {
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        // System.out.println(arr[i][j] + " " + x.charAt(0));
                        if (arr[i][j] == x.charAt(0)) {
                            arr[i][j] = '0';
                        }
                    }
                }
            }
        for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        if (k[i][j] == -1) {
                            arr[i][j] = '0';
                        }
                    }
                }
        
        }
          
         for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        if (arr[i][j] != '0') answer++;
                    }
                }
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[i].length; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return answer;
    }
    
    public void bfs(List<int[]> list, char[][] arr, char target) {
        // System.out.println("x, y : " + x + " " + y);
        int[][] ch = new int[arr.length][arr[0].length];
        Queue<int[]> q = new ArrayDeque<>();
        //  for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[i].length; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        for (int[] x : list) {
            q.offer(new int[]{x[0], x[1]});
            // System.out.println(x[0] + " " + x[1]);
        }
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                // System.out.println("p: " + p[0] + " " + p[1]);
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length || ch[nx][ny] == 1 || k[nx][ny] == -1) continue;
                    ch[nx][ny] = 1;
                    if (arr[nx][ny] == '0') {
                        q.offer(new int[]{nx, ny});
                    }
                    if (arr[nx][ny] == target) {
                        // arr[nx][ny] = '0';
                        k[nx][ny] = -1;
                        // System.out.println("nx, ny : " + nx + " " + ny);
                        // break;
                    }
                    
                }
            }
        }
        
        
    }
}