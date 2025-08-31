import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    static List<Character> mo = List.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = null;
        while (!(s = br.readLine()).equals("end")) {
            boolean flag = false;
            if (s.chars().mapToObj(c -> (char) c).anyMatch(c -> mo.contains(c))) {
                flag = pass(s);
            }

            if (flag) {
                System.out.println("<" + s + "> is acceptable.");
            } else {
                System.out.println("<" + s + "> is not acceptable.");
            }

        }
    }

    private static boolean pass(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                if (s.charAt(i) != 'o' && s.charAt(i) != 'e') {
                    return false;
                }
            }
        }

        int cnt = 0;
        boolean isJa = false;
        for (int i = 0; i < s.length(); i++) {
            if (isJa) {
                if (mo.contains(s.charAt(i))) {
                    cnt = 1;
                    isJa = false;
                } else {
                    cnt++;
                }
            } else {
                if (mo.contains(s.charAt(i))) {
                    cnt++;
                } else {
                    isJa = true;
                    cnt = 1;
                }
            }

            if (cnt >= 3) {
                return false;
            }
        }

        return true;
    }

}