import java.util.*;

class Solution {

    public long solution(int n, int[] times) {
        long start = times[0];
        long end = n * 1_000_000_000L;

        while (start < end) {
            long mid = (start + end) / 2;

            if (check(times, mid, n)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private boolean check(int[] times, long mid, int n) {
        long cnt = 0;

        for (int time : times) {
            cnt += mid / time;
        }

        return n <= cnt;
    }
}