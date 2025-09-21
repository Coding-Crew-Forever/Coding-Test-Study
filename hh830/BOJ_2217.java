import java.io.*;
import java.util.*;

public class BOJ_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int rope[] = new int[n];

        for (int i=0; i<n; i++) {
            rope[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(rope);

        int max = 0;
        for (int i=0; i<n; i++) {
            int weight = rope[i] * (n-i);
            max = Math.max(max, weight);
        }

        System.out.println(max);
    }
}
