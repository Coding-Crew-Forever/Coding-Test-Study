import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        System.out.println(bfs(n, m));
    }

    private static int bfs(long n, long m) {
        int ans = 1;

        while (n != m) {
            if (m < n) {
                return -1;
            }

            String str = String.valueOf(m);

            if (str.charAt(str.length() - 1) != '1' && m % 2 != 0) {
                return -1;
            }

            if (m % 2 == 0) {
                m = m / 2;
            } else {
                m = (m - 1) / 10;
            }

            ans++;
        }

        return ans;
    }

}