package youbbin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PGS_49189 {
    class Solution {
        public int solution(int n, int[][] edge) {
            int answer = 0;
            int[] result = dijkstra(n, edge, 1);
            int max = 0;

            // 최단 거리 중의 최대값을 찾기
            for (int i = 1; i < result.length; i++) {
                if (max < result[i]) {
                    max = result[i];
                }
            }

            // 가장 먼 노드 개수
            for (int i = 1; i < result.length; i++) {
                if (result[i] == max) answer++;
            }

            return answer;
        }

        public int[] dijkstra(int n, int[][] edges, int start) {
            // 그래프 만들기 (인접 리스트)
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            // edges 정보로 그래프 구성
            for (int[] edge : edges) {
                // 양방향 그래프
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }

            int[] distance = new int[n + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[start] = 0; // 시작점은 거리 0
            boolean[] visited = new boolean[n + 1]; // 방문 확인용 boolean 배열

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            pq.offer(new int[]{0, start});

            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int currentNode = current[1];

                if (visited[currentNode]) continue;
                visited[currentNode] = true;

                for (int next : graph.get(currentNode)) {
                    int cost = distance[currentNode] + 1;
                    if (cost < distance[next]) {
                        distance[next] = cost;
                        pq.offer(new int[]{cost, next});
                    }
                }
            }
            return distance;
        }
    }
}
