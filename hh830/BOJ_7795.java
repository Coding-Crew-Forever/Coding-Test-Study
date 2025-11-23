import java.io.*;
import java.util.*;

public class BOJ_7795 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int T = Integer.parseInt(bufferedReader.readLine());

        while(T > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            int A[] = new int[N];
            int B[] = new int[M];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            Arrays.sort(B);

            int count = 0;

            for(int x : A) {
                count += lowerBound(B, x);
            }

            stringBuilder.append(count).append("\n");
            T--;
        }

        System.out.print(stringBuilder);
    }

    private static int lowerBound(int arr[], int x) {
        int left = 0;
        int right = arr.length;

        while(left < right) {
            int mid = (left + right) / 2;
            if(arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
