import java.io.*;
import java.util.*;

public class BOJ_21736 {
    private static int n, m;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        int sx = 0, sy = 0;

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'I') {
                    sx = i;
                    sy = j;
                }
            }
        }

        dfs(sx, sy);

        System.out.println(count == 0 ? "TT" : count);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        if (map[x][y] == 'P') count++;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(!visited[nx][ny] && map[nx][ny] != 'X'){
                dfs(nx, ny);
            }
        }
    }
}
