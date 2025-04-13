import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger n = new BigInteger(br.readLine());
        BigInteger answer = BigInteger.ZERO;
        BigInteger one = BigInteger.ONE;

        while (true) {
            if (n.compareTo(answer) < 0) {
                answer = answer.subtract(one);
                break;
            }
            n = n.subtract(answer);
            answer = answer.add(one);
        }

        System.out.println(answer);
        br.close();
    }

}