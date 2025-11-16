import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String n = bufferedReader.readLine();
        char arr[] = n.toCharArray();

        Arrays.sort(arr);

        for(int i=arr.length-1; i>=0; i--) {
            System.out.print(arr[i]);
        }
    }
}
