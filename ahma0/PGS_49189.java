import java.util.*;

class Solution {
    boolean[] visited;
    int[] step;
    List<List<Integer>> graph = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();

    public int solution(int n, int[][] edge) {
        int answer = 1;
        visited = new boolean[n + 1];
        step = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        queue.add(1);
        visited[1] = true;
        step[1] = 1;

        for (int[] vertex : edge) {
            int src = vertex[0];
            int dest = vertex[1];
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }

        bfs();

        Arrays.sort(step);
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (max < step[i]) {
                answer = 1;
                max = Math.max(step[i], max);
            } else if (max == step[i]) {
                answer++;
            }
        }
        return answer;
    }

    private void bfs() {
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    step[v] = step[u] + 1;
                    queue.add(v);
                }
            }
        }
    }
}