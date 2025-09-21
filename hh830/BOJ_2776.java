import java.io.*;
import java.util.*;

public class BOJ_2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int t=0;t<T;t++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int num[] = new int[n];

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i=0;i<n;i++) {
                num[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            Arrays.sort(num);

            int m = Integer.parseInt(bufferedReader.readLine());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for(int i=0;i<m;i++) {
                int target = Integer.parseInt(stringTokenizer.nextToken());
                if (search(num, target)) {
                    stringBuilder.append("1\n");
                } else{
                    stringBuilder.append("0\n");
                }
            }
        }
        System.out.print(stringBuilder.toString());
    }

    public static boolean search(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target)
                return true;
            if(arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
