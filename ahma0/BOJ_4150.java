import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n == 0) System.out.println(0);
        else if(n == 1) System.out.println(1);
        else {
            BigInteger arr[] = new BigInteger[n + 1];
            arr[0] = new BigInteger("0");
            arr[1] = new BigInteger("1");

            for (int i = 2; i < n + 1; i++) {
                arr[i] = arr[i - 1].add(arr[i - 2]);
            }

            System.out.println(arr[n].toString());
        }
    }
}