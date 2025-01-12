class Solution {

    public int solution(int n, int m, int[] section) {
        int max = 0;
        int cnt = 0;

        for (int i : section) {
            if (max <= i) {
                max = i + m;
                cnt++;
            }
        }

        return cnt;
    }
}