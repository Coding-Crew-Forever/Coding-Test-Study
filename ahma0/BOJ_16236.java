import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int moveX[] = {0, 0, 1, -1};
    static int moveY[] = {1, -1, 0, 0};
    static int map[][];
    static int dist[][];
    static int size = 2, eat = 0, cnt = 0;
    static int sharkX = 0, sharkY = 0;
    static int minX, minY, minDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        while(true) {
            dist = new int[N][N];
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            minDist = Integer.MAX_VALUE;

            bfs(sharkX, sharkY);

            if(minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
                eat++;
                map[minX][minY] = 0;
                sharkX = minX;
                sharkY = minY;
                cnt += dist[minX][minY];

                if(eat == size) {
                    size++;
                    eat = 0;
                }
            } else {
                break;
            }
        }

        System.out.println(cnt);

    }

    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));

        while(!q.isEmpty()) {
            Node now = q.poll();

            for(int i = 0; i < 4; i++) {
                int newX = now.x + moveX[i];
                int newY = now.y + moveY[i];

                if(!isArea(newX, newY) || !isAbleToGo(newX, newY) || dist[newX][newY] != 0) {
                    continue;
                }

                dist[newX][newY] = dist[now.x][now.y] + 1;
                eat(newX, newY);
                q.add(new Node(newX, newY));
            }
        }
    }

    private static boolean isArea(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    private static boolean isAbleToGo(int x, int y) {
        return map[x][y] <= size;
    }

    private static void eat(int x, int y) {
        if(map[x][y] == 0 || map[x][y] >= size) {
            return;
        }

        if(minDist > dist[x][y]) {
            minDist = dist[x][y];
            minX = x;
            minY = y;
        }
        else if(minDist == dist[x][y]) {
            if(minX == x && minY > y) {
                minY = y;
            } else if(minX > x) {
                minX = x;
                minY = y;
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

