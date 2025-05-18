import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[][] arr;
    private static int min = Integer.MAX_VALUE, ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        System.out.println(ans);
        br.close();
    }

    private static void bfs(int index) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        q.add(new Node(index, 0));
        visited[index] = true;

        int res = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 1; i < arr.length; i++) {
                if (!visited[i] && arr[now.index][i] == 1) {
                    q.add(new Node(i, now.count + 1));
                    visited[i] = true;
                    res += now.count + 1;
                }
            }
        }

        if (res < min) {
            min = res;
            ans = index;
        }
    }

    static class Node {
        int index;
        int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}