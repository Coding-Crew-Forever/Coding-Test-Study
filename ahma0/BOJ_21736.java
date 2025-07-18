import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr;
    static boolean[][] visited;
    static int n, m;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m];

        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            String t = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = t.charAt(j);

                if (arr[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        int answer = bfs(x, y);

        System.out.println(answer == 0 ? "TT" : answer);
    }

    private static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = cur.x + moveX[i];
                int newY = cur.y + moveY[i];

                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }

                if (arr[newX][newY] == 'X' || arr[newX][newY] == 'I' || visited[newX][newY]) {
                    continue;
                }

                if (arr[newX][newY] == 'P') {
                    cnt++;
                }
                q.offer(new Node(newX, newY));
                visited[newX][newY] = true;
            }
        }

        return cnt;
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