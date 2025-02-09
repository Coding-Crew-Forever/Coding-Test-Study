import java.util.*;

class Solution {

    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        String[] arr = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        for (String s : arr) {
            answer.append(s);
        }

        long zeroCnt = answer.chars()
            .filter(ch -> ch == '0')
            .count();

        if (zeroCnt == answer.length()) {
            return "0";
        }

        return answer.toString();
    }
}