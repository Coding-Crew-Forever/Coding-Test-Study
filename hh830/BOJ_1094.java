import java.io.*;

public class BOJ_1094 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bufferedReader.readLine());

        int cnt = 0;
        while(x > 0) {
            if(x % 2 == 1) 
                cnt++;
            x /= 2;
        }

        System.out.println(cnt);
    }
}
