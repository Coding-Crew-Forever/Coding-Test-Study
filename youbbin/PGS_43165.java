package youbbin;

public class PGS_43165 {
    int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(numbers, 0, target, 0);
        return answer;
    }

    public void dfs(int[] numbers, int depth, int target, int result){
        if(depth == numbers.length){
            if(target == result){
                answer++;
            }
        }
        else{
            dfs(numbers, depth + 1, target, result + numbers[depth]);
            dfs(numbers, depth + 1, target, result - numbers[depth]);
        }
    }
}
