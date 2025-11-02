import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(st.nextToken()); // 큐 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑을 개수

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=1;i<=N;i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(bufferedReader.readLine());
        int count = 0;

        for(int i=0;i<M;i++) {
            int target = Integer.parseInt(st.nextToken());

            int index = deque.indexOf(target);
            int left = index;
            int right = deque.size() - index;

            if(left<=right) {
                // 왼쪽 회전
                for(int j=0;j<left;j++) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            } else{
                // 오른쪽 회전
                for(int j=0;j<right;j++) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}
