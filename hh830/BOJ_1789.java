import java.io.*;

public class BOJ_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long S=Long.parseLong(bufferedReader.readLine().trim());

        long sum=0;
        long count=0;
        long i=1;

        while(sum+i<=S){
            sum+=i;
            count++;
            i++;
        }

        System.out.println(count);
    }
}
