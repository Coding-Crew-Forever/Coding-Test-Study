import java.io.*;
import java.util.*;

public class BOJ_11060 {
    private static int n;
    private static int[] arr;
    private static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        arr = new int[n];
        visit = new boolean[n];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visit[0] = true;

        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            int i = cur[0];
            int cnt = cur[1];

            if (i == n - 1) {
                return cnt;
            }

            for (int jump = 1; jump <= arr[i]; jump++) {
                int next = i + jump;
                if (next >= n) break;
                if (!visit[next]) {
                    visit[next] = true;
                    queue.offer(new int[]{next, cnt + 1});
                }
            }
        }

        return -1;
    }
}
