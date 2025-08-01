import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 1000 - Integer.parseInt(br.readLine());
        int answer = 0;
        int[] coinArr = {500, 100, 50, 10, 5, 1};

        for (int i = 0; i < 6; i++) {
            if (n / coinArr[i] > 0) {
                answer += n / coinArr[i];
                n = n % coinArr[i];
            }
        }

        System.out.println(answer);
    }

}