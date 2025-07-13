using System;

public class Solution {
    public int[] solution(int[] array, int[,] commands) {
        int n = commands.GetLength(0);
        int[] answer = new int[n];

        for (int idx = 0; idx < n; idx++) {
            int i = commands[idx, 0];
            int j = commands[idx, 1];
            int k = commands[idx, 2];

            int len = j - i + 1;
            int[] subArray = new int[len];
            Array.Copy(array, i - 1, subArray, 0, len);

            // 정렬
            Array.Sort(subArray);

            // k번째 원소
            answer[idx] = subArray[k - 1];
        }

        return answer;
    }
}
