import java.util.*;

class Solution {
    public ArrayList solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int min_days = 0;
        int cnt = 0;

        for(int i = 0; i < progresses.length; i++){
            queue.add((int)Math.ceil((100.0-progresses[i])/speeds[i]));
        }

        while(!queue.isEmpty()){
            min_days = queue.poll();
            cnt = 1;
            while(!queue.isEmpty() && queue.peek() <= min_days){
                queue.poll();
                cnt++;
            }
            answer.add(cnt);
            cnt = 0;
        }

        return answer;
    }
}