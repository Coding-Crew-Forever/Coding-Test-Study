import java.util.*;
import java.io.*;

class Solution {
    
    boolean visited[];
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n + 1];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(computers, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int[][] computers, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int i = 0; i < computers.length; i++) {
                if(computers[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
    
}