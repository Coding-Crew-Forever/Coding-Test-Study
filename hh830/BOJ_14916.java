import java.io.*;
import java.util.*;

public class BOJ_14916 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int INF = 100001;
        int dp[] = new int[n+1];
        Arrays.fill(dp, INF);

        dp[0] = 0;

        for(int i=1;i<=n;i++){
            if(i-2 >= 0){
                dp[i] = Math.min(dp[i], dp[i-2] + 1);
            }
            if(i-5 >= 0){
                dp[i] = Math.min(dp[i], dp[i-5] + 1);
            }
        }

        System.out.println(dp[n] == INF ? -1 : dp[n]);
    }
}
