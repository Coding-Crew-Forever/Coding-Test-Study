class Solution {

    public int solution(int[][] triangle) {
        int answer = triangle[0][0];
        int length = triangle.length;
        int[][] arr = new int[length][length];
        arr[0][0] = triangle[0][0];

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                arr[i][j] = triangle[i][j] + arr[i - 1][j];
                try {
                    arr[i][j] = Math.max(arr[i][j], triangle[i][j] + arr[i - 1][j - 1]);
                } catch (Exception e) {
                }
            }
        }

        for (int i = 0; i < length; i++) {
            answer = Math.max(answer, arr[length - 1][i]);
        }

        return answer;
    }
}