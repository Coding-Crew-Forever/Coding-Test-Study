import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.replaceAll("0{2,}", "0");
        s = s.replaceAll("1{2,}", "1");
        int cnt1 = 0;
        int cnt2 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                cnt1++;
            } else {
                cnt2++;
            }
        }

        int answer = Math.min(cnt1, cnt2);
        System.out.println(answer);

        br.close();
    }

}