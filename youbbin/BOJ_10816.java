import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (hashMap.containsKey(n)) {
                hashMap.put(n, hashMap.get(n) + 1);
            } else {
                hashMap.put(n, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for (int i = 0; i < arr.length; i++) {
            int m = Integer.parseInt(st.nextToken());
            if (hashMap.containsKey(m)) {
                arr[i] = hashMap.get(m);
            } else {
                arr[i] = 0;
            }
        }

        for (int i : arr) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
