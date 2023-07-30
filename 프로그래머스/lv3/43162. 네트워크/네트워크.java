class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i<visited.length; i++) {
            visited[i] = false; //모든 방문 node를 false로 초기화
        }
        
        for (int i = 0; i<n; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers);
                answer++;
            }
        }
        
        
        return answer;
    }
    
    
    public boolean[] dfs(int i, boolean[] visited, int[][] computers) {
        visited[i] = true;
        
        for (int j = 0; j<computers.length; j++) {
            if (i != j && computers[i][j] == 1 && visited[j] == false) {
                visited = dfs(j, visited, computers);
            }
        }
        return visited;
    }
}