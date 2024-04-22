import java.util.*;

public class PGS_12909 {
    boolean solution(String s) {
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                queue.add(s.charAt(i));
            }
            else{
                if(!queue.isEmpty()){
                    queue.poll();
                }
                else{
                    return false;
                }
            }
        }

        if(!queue.isEmpty()){ // 마지막에 큐 비어있지 않으면 false
            return false;
        }
        else return true;
    }
}
