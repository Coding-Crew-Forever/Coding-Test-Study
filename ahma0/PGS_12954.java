import java.util.ArrayList;
import java.util.List;

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = {};

        List<Long> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add((long) x * i);
        }

        return list.stream().mapToLong(Long::longValue).toArray();
    }
}
