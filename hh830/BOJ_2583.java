import java.io.*;
import java.util.*;

public class BOJ_2583 {
    private static int M, N, K;
    private static int[][] map;
    private static boolean[][] visited;

    // 상,하,좌,우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        M = Integer.parseInt(stringTokenizer.nextToken()); // 세로
        N = Integer.parseInt(stringTokenizer.nextToken()); // 가로
        K = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    areas.add(bfs(i, j));
                }
            }
        }

        Collections.sort(areas);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(areas.size()).append("\n");
        for (int area : areas) {
            stringBuilder.append(area).append(" ");
        }

        System.out.println(stringBuilder);
    }

    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        int count = 1;

        while(!queue.isEmpty()) {
            int cur[] = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if(visited[nx][ny] || map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                count++;
            }
        }
        return count;
    }
}
