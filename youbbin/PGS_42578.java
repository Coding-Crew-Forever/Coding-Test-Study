import java.util.ArrayList;
import java.util.HashMap;
public class PGS_42578 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1]; // 의상 종류
            String name = clothes[i][0]; // 의상 이름

            if(hashMap.containsKey(type)) {
                hashMap.get(clothes[i][1]).add(clothes[i][0]);
                hashMap.put(clothes[i][1], hashMap.get(clothes[i][1]));
            }
            else {
                ArrayList<String> nameArr = new ArrayList<>();
                nameArr.add(name);
                hashMap.put(type, nameArr);
            }
        }

        for (String type : hashMap.keySet()) {
            answer *= hashMap.get(type).size() + 1; // 각 타입마다 안입는 경우도 포함
        }

        answer -= 1; // 아무것도 안입는 경우 제외
        return answer;
    }
}
