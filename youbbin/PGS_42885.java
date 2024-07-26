import java.util.Arrays;

public class PGS_42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people); // 정렬
        int a = 0;
        int b = people.length - 1;
        while(a <= b) {
            if(people[a] + people[b] > limit) { // 가장 무거운 사람과 가장 가벼운 사람이 같이 못타면 가장 무거운 사람 혼자 보내기
                b--;
                answer++;
            }
            else {
                a++;
                b--;
                answer++;
            }
        }
        return answer;
    }
}
