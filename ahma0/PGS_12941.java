import java.util.*;

class Solution {
    
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
        
        int answer = 0;
        
        for(int i = 0; i < A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
        }
        
        for(int i = 0; i < A.length; i++) {
            answer += a.poll() * b.poll();
        }

        return answer;
    }
}