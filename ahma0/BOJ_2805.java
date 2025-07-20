import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int max = 0;
        int min = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;

            for (int tree : arr) {
                if (tree - mid > 0) {
                    sum += (tree - mid);
                }
            }

            if (sum < m) {
                max = mid;
                continue;
            }

            min = mid + 1;
        }


        System.out.println(min - 1);
    }
}