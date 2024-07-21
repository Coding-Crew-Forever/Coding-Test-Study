import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PGS_138476 {
    public int solution(int k, int[] tangerine) {
        int answer = 1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++) {
            hashMap.put(tangerine[i],hashMap.getOrDefault(tangerine[i], 0) + 1);
        }
        ArrayList<Integer> valueList = new ArrayList<>(hashMap.values());
        valueList.sort(Collections.reverseOrder());

        int cnt = 0;
        for(int i = 0; i < valueList.size(); i++) {
            cnt += valueList.get(i);
            if(cnt < k){
                answer++;
            }
            else{
                break;
            }
        }
        return answer;
    }
}
