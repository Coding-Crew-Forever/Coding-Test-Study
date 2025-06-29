import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int worm; // 지렁이 수
    static boolean[][] arr;
    static boolean[][] visited;
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 
   
        for(int i = 0; i < T; i++){
            worm = 0; // 지렁이 수 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // M : 배추밭 가로길이
            N = Integer.parseInt(st.nextToken()); // N : 배추밭 세로길이
            int K = Integer.parseInt(st.nextToken()); // K : 배추 위치 개수
         
            arr = new boolean[N][M];// M * N 크기의 배추밭 -> false : 배추 없음, true : 배추 있음
            visited = new boolean[N][M];

            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = true; // 배추심기
            }

            worm = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (arr[y][x] && !visited[y][x]) {
                        dfs(y, x);
                        worm++;
                    }
                }
            }

            System.out.println(worm);
        }
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                if (arr[ny][nx] && !visited[ny][nx]) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
