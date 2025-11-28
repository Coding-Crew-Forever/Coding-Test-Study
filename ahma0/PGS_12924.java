class Solution {

    public int search(int n) {
        int answer = 0;

        for (int i = 1; i * (i + 1) / 2 <= n; i++) {
            if ((n - (i * (i - 1) / 2)) % i == 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        //        Solution s = new Solution();
        //        int n = s.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        //        System.out.println(n);
    }
}
