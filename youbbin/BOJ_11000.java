import java.io.*;
import java.util.*;
public class BOJ_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        ArrayList<Lecture> lectureList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            Lecture lecture = new Lecture(startTime, endTime);
            lectureList.add(lecture);
        }
        // 시작시간 기준으로 오름차순 정렬, 시작시간 같으면 종료시간 기준 오름차순 정렬
        lectureList.sort((l1, l2) -> (l1.startTime==l2.startTime) ? l1.endTime - l2.endTime : l1.startTime - l2.startTime);
        pq.add(lectureList.get(0).endTime);

        for(int i = 1; i < N ; i++){
            if(pq.peek() <= lectureList.get(i).startTime){
                pq.poll(); // 기존 강의실에 배치
            }
            pq.add(lectureList.get(i).endTime);
        }
        System.out.println(pq.size());
    }
}

class Lecture {
    int startTime;
    int endTime;

    public Lecture(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
