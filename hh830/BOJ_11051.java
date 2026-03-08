import java.util.*;
import java.io.*;

public class BOJ_11051 {
    static final int MOD = 10007;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        int dp[][] = new int[n + 1][n + 1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;

            for(int j = 1; j < i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        System.out.println(dp[n][k]);
    }
}
