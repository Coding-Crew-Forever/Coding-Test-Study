import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725 {
    static int N;
    static ArrayList<Integer>[] arrayList;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arrayList = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++){
            arrayList[i] = new ArrayList<Integer>();
        }
        parent = new int[N + 1];
        int root = 1; // 루트노드 1번

        // 노드의 연결 정보 저장
        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayList[a].add(b);
            arrayList[b].add(a);
        }

        dfs(root); // root(1번) 노드부터 시작!
        for(int i = 2; i <= N; i++){
            System.out.println(parent[i]);
        }
    }

    // n번 노드 방문 -> 자식 노드 확인 -> 자식 노드의 부모 노드(n) 저장
    public static void dfs(int n){
        for(int i : arrayList[n]){ // n번 노드와 연결된 노드들 확인
            if(parent[n] != i) { // n번의 부모 노드가 아닐 경우
                parent[i] = n; // 자식노드가 n번 노드를 부모로 저장
                dfs(i);
            }
        }
    }
}
