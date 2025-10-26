import java.io.*;
import java.util.*;

public class BOJ_16173 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine().trim());

        int map[][] = new int[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        boolean visited[][] = new boolean[N][N];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        boolean success = false;

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int r = now[0];
            int c = now[1];
            int value = map[r][c];

            if (value == -1) {
                success = true;
                break;
            }

            if (value == 0)
                continue;

            int nr = r + value;
            int nc = c;
            if (nr >= 0 && nr < N && !visited[nr][nc]) {
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
            nr = r;
            nc = c + value;
            if (nc >= 0 && nc < N && !visited[nr][nc]) {
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }

        System.out.println(success ? "HaruHaru" : "Hing");
    }
}
