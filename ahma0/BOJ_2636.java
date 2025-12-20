import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] cheese;
    static boolean[][] visited;
    static int cheeseCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheese = new int[N][M];
        cheeseCount = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if (cheese[i][j] == 1) {
                    cheeseCount++;
                }
            }
        }

        int time = 0;
        int cnt = 0;
        while (cheeseCount != 0) {
            time++;
            cnt = cheeseCount;
            findCheese();
        }

        System.out.println(time);
        System.out.println(cnt);
    }

    private static void findCheese() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        visited = new boolean[N][M];

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y]) {
                    continue;
                }

                visited[x][y] = true;

                if (cheese[x][y] == 0) {
                    q.add(new Node(x, y));
                } else {
                    cheeseCount--;
                    cheese[x][y] = 0;
                }
            }
        }
    }

    private static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

