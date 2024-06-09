import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수의 개수
        int[] arr = new int[N];
        double sum = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        int mean = (int)Math.round(sum / N);
        int median = arr[N / 2];
        int range = arr[N-1] - arr[0];
        int mode = 0;
        int[] temp = new int[8001];
        for(int i = 0; i < N; i++){
            temp[4000 + arr[i]]++;
        }
        int max = 0;
        int maxIndex = 0;
        for(int i = 0; i < temp.length; i++){
            if(max < temp[i]){
                max = temp[i];
                mode = i;
                maxIndex = 1;
            }
            else if(max == temp[i]){
                maxIndex++;
                if(maxIndex == 2) mode = i;
            }
        }

        mode = mode - 4000;
        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}
