class Solution {
    int target, answer = 0;
    int arr[];

    public int solution(int[] numbers, int target) {
        this.target = target;
        arr = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = numbers[i];
        }

        find(-1 * arr[0], 1);
        find(arr[0], 1);

        return answer;
    }

    private void find(int number, int cnt) {
        if (number == target && cnt == arr.length) {
            answer++;
            return;
        } else if (cnt == arr.length) {
            return;
        }

        find(number - arr[cnt], cnt + 1);
        find(number + arr[cnt], cnt + 1);
    }
}