import java.util.*;
public class PGS_42746 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strArr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            strArr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strArr, (o1, o2)->(o1 + o2).compareTo(o2 + o1));
        for(int i = strArr.length-1; i >= 0; i--){
            answer += strArr[i];
        }
        if(answer.startsWith("0")) return "0";
        return answer;
    }
}
