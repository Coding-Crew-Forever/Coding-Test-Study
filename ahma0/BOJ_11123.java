import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new int[n + 1][m + 1];
            visited = new boolean[n + 1][m + 1];

            for (int i = 0; i < n; i++) {
                String s = br.readLine();

                for (int j = 0; j < m; ++j) {
                    if (s.charAt(j) == '#') {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = 0;
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (map[i][j] == 0) continue;
                    if (visited[i][j]) continue;
                    bfs(i, j);
                    ans++;
                }
            }

            System.out.println(ans);
        }

    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; ++i) {
                int nx = node.x + dx[i], ny = node.y + dy[i];

                if (nx > n || nx < 0 || ny > m || ny < 0) continue;
                if (map[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
            }
        }

    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}