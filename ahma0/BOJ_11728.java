import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        for (int j = 0; j < n; j++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for (int j = 0; j < m; j++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < n + m; i++) {
            bw.write(pq.poll() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}