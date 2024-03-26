import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606 {
    public static int cnt;
    public static int[][] node;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        cnt = 0;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        node = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a][b] = node[b][a] = 1;
        }
        dfs(1);
        System.out.println(cnt-1); // 1번 컴퓨터 제외
    }

    public static void dfs(int start) {
        visited[start] = true;
        cnt++;
        for(int i = 1; i < node.length; i++){
            if(node[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}
