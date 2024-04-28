import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1012 {
    static int worm; // 지렁이 수
    static boolean[][] arr;
    static boolean[][] visited;
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // T : 테스트 케이스의 개수
        int[][] temp;
        for(int i = 0; i < T; i++){
            worm = 0; // 지렁이 수 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // M : 배추밭 가로길이
            N = Integer.parseInt(st.nextToken()); // N : 배추밭 세로길이
            int K = Integer.parseInt(st.nextToken()); // K : 배추 위치 개수
            temp = new int[K][2]; // 배추위치 저장용
            arr = new boolean[N][M];// M * N 크기의 배추밭 -> false : 배추 없음, true : 배추 있음
            visited = new boolean[N][M];
            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                temp[j][0] = b;
                temp[j][1] = a;
                arr[b][a] = true; // 배추심기
            }

            for(int j = 0; j < K; j++) {
                if(!visited[temp[j][0]][temp[j][1]]) {
                    worm++;
                    dfs(temp[j][0], temp[j][1]);
                }
            }
            System.out.println(worm);
        }
    }

    public static void dfs(int a, int b) {
        if(!visited[a][b]){
            visited[a][b] = true;
            if(a == N - 1 && b == M - 1){
                return;
            }
            if(b < M - 1){
                if(arr[a][b + 1]) dfs(a, b + 1);
            }
            if(a < N - 1){
                if(arr[a + 1][b]) dfs(a + 1, b);
            }
            if(b > 1) {
                if(arr[a][b - 1]) dfs(a, b - 1);
            }
            if(a > 1) {
                if(arr[a-1][b]) dfs(a - 1, b);
            }
        }
    }

}
