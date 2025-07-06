import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(combination(m, n)).append("\n");
        }

        System.out.println(sb);
    }

    private static int combination(int n, int r) {
        if (arr[n][r] > 0) {
            return arr[n][r];
        }

        if (n == r || r == 0) {
            return arr[n][r] = 1;
        }

        return arr[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
}