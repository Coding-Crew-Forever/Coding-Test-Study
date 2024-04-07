import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Room[] rooms = new Room[N];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            rooms[i] = new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(rooms);
        pq.add(rooms[0].endTime);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= rooms[i].startTime) {
                pq.poll();
            }
            pq.add(rooms[i].endTime);
        }

        System.out.println(pq.size());

    }

    static class Room implements Comparable<Room> {
        int startTime;
        int endTime;

        public Room(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Room o) {
            if (o.startTime == this.startTime) {
                return this.endTime - o.endTime;
            }
            return this.startTime - o.startTime;
        }
    }

}

