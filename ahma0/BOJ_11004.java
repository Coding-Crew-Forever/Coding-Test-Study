import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, n - 1);

        System.out.println(arr[k - 1]);
    }


    public static void quickSort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end);

        if (start < part2 - 1) {
            quickSort(arr, start, part2 - 1);
        }

        if (part2 < end) {
            quickSort(arr, part2, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int m = (start + end) / 2;
        int pivot = arr[m];

        while (start <= end) {

            while (arr[start] < pivot) start++;

            while (arr[end] > pivot) end--;

            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        return start;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

