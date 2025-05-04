import java.io.*;
import java.util.HashMap;

public class BOJ_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        String str = "";
        StringBuilder sb;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            hashMap.clear();
            flag = false;
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (!hashMap.containsKey(ch)) {
                    hashMap.put(ch, str.indexOf(ch));
                    sb= new StringBuilder(str);
                    sb.setCharAt(str.indexOf(ch),'-');
                    str = sb.toString();
                    flag = true;
                } else if (hashMap.containsKey(ch) && (str.indexOf(ch) - hashMap.get(ch) == 1)) {
                    hashMap.put(ch, str.indexOf(ch));
                    sb= new StringBuilder(str);
                    sb.setCharAt(str.indexOf(ch),'-');
                    str = sb.toString();
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
}
