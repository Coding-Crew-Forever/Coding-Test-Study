import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        visited = new boolean[r][c];

        int wolf = 0, sheep = 0;
        for (int i = 0; i < r; i++) {
            String s = br.readLine();

            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && arr[i][j] != '#') {
                    int[] t = bfs(i, j);
                    sheep += t[0];
                    wolf += t[1];
                }
            }
        }

        System.out.println(sheep + " " + wolf);
        br.close();
    }

    private static int[] bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;

        int wolf = 0, sheep = 0;

        if (arr[x][y] == 'v') wolf++;
        if (arr[x][y] == 'k') sheep++;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    continue;
                }

                if (visited[nx][ny] || arr[nx][ny] == '#') {
                    continue;
                }

                q.add(new Node(nx, ny));
                visited[nx][ny] = true;

                if (arr[nx][ny] == 'v') { //늑대일 경우
                    wolf++;
                }

                if (arr[nx][ny] == 'k') {
                    sheep++;
                }
            }
        }

        if (wolf < sheep) {
            wolf = 0;
        } else {
            sheep = 0;
        }
        return new int[]{sheep, wolf};
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

