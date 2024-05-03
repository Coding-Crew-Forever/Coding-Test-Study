public class PGS_70129 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt_conversion = 0;
        int cnt_zero = 0;
        String x = s;
        while(!x.equals("1")){
            int len_before = x.length();
            x = x.replace("0",""); // x의 모든 0 없애기
            int len_after = x.length(); // 0 없앤 후 x의 길이
            cnt_zero += len_before - x.length();
            x = Integer.toBinaryString(len_after); // x의 길이 -> 2진수 변환
            cnt_conversion++;
        }
        answer[0]= cnt_conversion;
        answer[1] = cnt_zero;
        return answer;
    }
}
