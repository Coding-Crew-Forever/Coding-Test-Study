import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1068 {
    static int N;
    static int[] parentNode;
    static boolean[] visited;
    static int leafCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        parentNode = new int[N];
        visited = new boolean[N];
        int rootNode = 0;

        for(int i = 0; i < N; i++){
            parentNode[i] = Integer.parseInt(st.nextToken());
            if(parentNode[i] == -1) rootNode = i;
        }

        int deleteNode = Integer.parseInt(br.readLine());

        deleteNode(deleteNode); // 노드 삭제

        cntLeaf(rootNode); // 리프노드 카운팅

        System.out.println(leafCnt);
    }
    public static void deleteNode(int node){
        parentNode[node] = -2; // 본인 노드 삭제
        for(int i = 0; i < N ; i++){
            if(parentNode[i] == node){ // 본인 노드의 자식 노드들 삭제
                deleteNode(i);
            }
        }
    }
    public static void cntLeaf(int node){
        boolean isLeaf = true;
        visited[node] = true;
        if(parentNode[node] != -2){ // 본인 노드가 삭제되지 않았다면
            for(int i = 0; i < N; i++){ // 본인 노드가 부모인 자식 노드가 있는지 확인
                if(parentNode[i] == node){ // 자식 노드 있으면 리프노드 아님
                    isLeaf = false;
                    cntLeaf(i); // 그 자식 노드의 자식 노드 확인
                }
            }
            if(isLeaf) leafCnt++;
        }
    }
}
