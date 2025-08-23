import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean[] check;
    static List<Integer>[] lists;
    static List<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        lists = new List[n + 1];
        check = new boolean[n + 1];
        ans = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists[a].add(b);
            lists[b].add(a);
        }

        check[1] = true;
        dfs(1, 0);

        System.out.println(ans.size());
    }

    private static void dfs(int n, int cnt) {
        if (cnt > 2) {
            return;
        }

        if (n != 1 && !ans.contains(n)) {
            ans.add(n);
        }

        check[n] = true;
        for (int nxt : lists[n]) {
            if (check[nxt]) continue;

            if (n == 1) {
                dfs(nxt, cnt + 1);
                continue;
            }
            if (cnt != 0) {
                dfs(nxt, cnt + 1);
            }
        }

        check[n] = false;
    }

}