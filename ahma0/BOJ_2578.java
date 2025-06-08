import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int index = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                find(Integer.parseInt(st.nextToken()));
                index++;

                leftCheck();
                rightCheck();
                crossCheck();
                reverseCrossCheck();

                if (count >= 3) {
                    System.out.println(index);
                    return;
                }
                count = 0;
            }
        }

    }

    private static void find(int n) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == n) {
                    arr[i][j] = -1;
                }
            }
        }
    }

    private static void leftCheck() {
        for (int i = 0; i < arr.length; i++) {
            int zero = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == -1) {
                    zero++;
                }
            }
            if (zero == 5) {
                count++;
            }
        }
    }

    private static void rightCheck() {
        for (int i = 0; i < arr.length; i++) {
            int zero = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[j][i] == -1) {
                    zero++;
                }
            }

            if (zero == 5) {
                count++;
            }
        }
    }

    private static void crossCheck() {
        int zero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][i] == -1) {
                zero++;
            }
        }

        if (zero == 5) {
            count++;
        }
    }

    private static void reverseCrossCheck() {
        int zero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][arr.length - 1 - i] == -1) {
                zero++;
            }
        }

        if (zero == 5) {
            count++;
        }
    }
}