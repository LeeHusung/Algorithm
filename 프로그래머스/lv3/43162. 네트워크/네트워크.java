class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i<visited.length; i++) {
            visited[i] = false; //모든 방문 node를 false로 초기화
        }
        
        for (int i = 0; i<n; i++) {
            if (!visited[i]) { //아직 방문되지 않았다면
                dfs(i, visited, computers); 
                // i번 컴퓨터에 대한 모든 노드들 탐색 후 방문처리 완료
                answer++;
            }
        }
        return answer;
    }
    
    
    public boolean[] dfs(int i, boolean[] visited, int[][] computers) {
        visited[i] = true; //방문처리
        
        for (int j = 0; j<computers.length; j++) {
            if (i != j && computers[i][j] == 1 && visited[j] == false) { //다음방문할 노드 j가 false면
                visited = dfs(j, visited, computers); //노드 j부터 다시 탐색 -> 이어진 모드 노드들 방문처리됨.
            }
        }
        return visited;
    }
}
