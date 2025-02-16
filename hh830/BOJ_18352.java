import java.io.*;
import java.util.*;

class Main {
    static List<List<Pair>> graph = new ArrayList<>();
    static int N, M, K, X;
    static int[] distance;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken()); // 도시의 개수 N
        M = Integer.parseInt(stringTokenizer.nextToken()); // 도로의 개수 M
        K = Integer.parseInt(stringTokenizer.nextToken()); // 거리 정보 K
        X = Integer.parseInt(stringTokenizer.nextToken()); // 출발 도시의 번호 X

        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(u).add(new Pair(v, 1)); // 거리 1로 가중치 설정
        }

        dijkstra(X);

        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                flag = true;
                System.out.println(i);
            }
        }

        if (!flag) {
            System.out.println(-1);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int dist = current.cost;

            if (distance[node] < dist) continue;

            for (Pair next : graph.get(node)) {
                int newDist = distance[node] + next.cost;
                if (newDist < distance[next.node]) {
                    distance[next.node] = newDist;
                    pq.add(new Pair(next.node, newDist));
                }
            }
        }
    }
}

class Pair implements Comparable<Pair> {
    int node, cost;

    Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.cost, other.cost);
    }
}
