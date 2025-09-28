import java.io.*;
import java.util.*;

public class BOJ_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(bufferedReader.readLine());

        int now = 1;
        int count = 0;
        
        while(count + now < X) {
            count += now;
            now++;
        }

        int p = X - count;
        
        int a;
        int b;
        
        if(now % 2 == 0){
            a = p;
            b = now - p + 1;
        } else {
            a = now - p + 1;
            b = p;
        }

        System.out.println(a + "/" + b);
    }
}
