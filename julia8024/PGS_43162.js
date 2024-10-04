function solution(n, computers) {
    let visited = Array(computers.length).fill(false);
    
    function dfs(v) {
        visited[v] = true;
        
        for(let i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[v][i]) {
                dfs(i);
            }
        }
        
        
    }
    
    let cnt = 0;
    
    for(let i = 0; i < computers.length; i++) {
        if (!visited[i]) {
            cnt++;
            dfs(i);
        }
    }
    
    return cnt;
}