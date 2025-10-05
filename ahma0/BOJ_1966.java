import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Queue<Doc> q = new LinkedList<>();

        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int t = Integer.parseInt(st.nextToken());

                q.add(new Doc(t, m == i));
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                Doc d = q.poll();
                if (q.stream().anyMatch(x -> x.priority > d.priority)) {
                    q.add(d);
                    continue;
                }

                cnt++;
                if (d.checked) {
                    break;
                }
            }

            System.out.println(cnt);
            q.clear();
        }
    }

    static class Doc implements Comparable<Doc> {
        int priority;
        boolean checked;

        public Doc(int priority, boolean checked) {
            this.priority = priority;
            this.checked = checked;
        }

        @Override
        public int compareTo(Doc o) {
            return o.priority - this.priority;
        }
    }

}

