import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931 {
    static int N;
    static int[][] meetings;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 회의의 수
        meetings = new int[N][2]; // 회의의 시작 시간과 끝나는 시간을 저장할 2차원 배열

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            meetings[i][0] = startTime;
            meetings[i][1] = endTime;
        }
        Arrays.sort(meetings, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]); // 끝나는 시간으로 오름차순 정렬함. 끝나는 시간이 같다면 시작 시간으로 오름차순 정렬

        search(0); // 정렬 기준 첫 회의부터 시작
        System.out.println(answer + 1);
    }

    static void search(int n){
        for(int i = n + 1; i < N; i++){
            if(meetings[i][0] >= meetings[n][1]){
                answer++;
                search(i);
                break;
            }
        }
    }
}
