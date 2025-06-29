import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = bufferedReader.readLine().split(" ");
        long A = Long.parseLong(tokens[0]);
        long B = Long.parseLong(tokens[1]);

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(A, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            long num = node.num;
            int count = node.count;

            if (num == B) {
                System.out.println(count);
                return;
            }

            if (num * 2 <= B) {
                queue.add(new Node(num * 2, count + 1));
            }

            if (num * 10 + 1 <= B) {
                queue.add(new Node(num * 10 + 1, count + 1));
            }
        }

        System.out.println(-1);
    }

    static class Node {
        long num;
        int count;
        Node(long num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}

