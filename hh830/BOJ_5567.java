import java.io.*;
import java.util.*;

public class BOJ_5567 {
    private static int N, M;
    private static List<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited[1] = true;
        queue.offer(new int[]{1, 0});

        int count = 0;

        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            int p= cur[0];
            int depth = cur[1];

            if (depth >= 2) continue;

            for (int next : graph[p]) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    queue.offer(new int[]{next, depth + 1});
                }
            }
        }
        return count;
    }
}
