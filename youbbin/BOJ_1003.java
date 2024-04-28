import java.io.*;

public class BOJ_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] answer = new int[41][2];
        for(int i = 0; i <= 40; i++){
            if(i == 0) {
                answer[i][0]++;
            }
            else if(i == 1) {
                answer[i][1]++;
            }
            else {
                answer[i][0] += answer[i-1][0]+ answer[i-2][0];
                answer[i][1] += answer[i-1][1]+ answer[i-2][1];

            }
        }
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(answer[n][0] + " "+ answer[n][1]);
        }
    }
}
