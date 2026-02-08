import java.io.*;
import java.util.*;

public class BOJ_13305 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        long d[] = new long[n - 1];
        long price[] = new long[n];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n - 1; i++) {
            d[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        long minPrice = price[0];
        long result = 0;

        for (int i = 0; i < n - 1; i++) {
            if (price[i] < minPrice) {
                minPrice = price[i];
            }
            result += minPrice * d[i];
        }

        System.out.println(result);
    }
}
