import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());

            switch (t) {
                case 1:
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    bw.write((stack.isEmpty() ? -1 : stack.pop()) + "\n");
                    break;
                case 3:
                    bw.write(stack.size() + "\n");
                    break;
                case 4:
                    bw.write((stack.isEmpty() ? 1 : 0) + "\n");
                    break;
                case 5:
                    bw.write((stack.isEmpty() ? -1 : stack.peek()) + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}