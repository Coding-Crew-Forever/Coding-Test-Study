import java.util.*;
public class PGS_12939 {
    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split(" ");
        int[] intArr = new int[strArr.length];
        for(int i = 0; i < strArr.length; i++){
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(intArr);
        answer = intArr[0] + " " + intArr[intArr.length-1];
        return answer;
    }
}
