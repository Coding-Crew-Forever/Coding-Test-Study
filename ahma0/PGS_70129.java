import java.util.Scanner;

class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int index = 0;

        while (!s.equals("1")) {
            int zero_count = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zero_count++;
                }
            }

            s = Integer.toBinaryString(s.length() - zero_count);
            cnt += zero_count;
            index++;
        }

        int[] answer = {index, cnt};
        return answer;
    }
}