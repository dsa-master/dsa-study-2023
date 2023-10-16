package BFS.BOJ13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Distance {
        int x;
        int time;

        public Distance(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    static int N;
    static int K;
    static final int MAX = 100000;
    static boolean[] visited = new boolean[100001];
    static Queue<Distance> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 처음 위치 큐에 삽입
        q.add(new Distance(N, 0));
        visited[N] = true;
        while(!q.isEmpty()) {
            Distance now = q.poll();

            if (now.x == K) {
                System.out.println(now.time);
                break;
            }

            // 걷는 경우, 순간이동 하는 경우 계산
            for (int i = 0; i < 3; i++) {
                Distance next = null;

                switch (i) {
                    case 0:
                        next = new Distance(now.x - 1, now.time + 1);
                        break;
                    case 1:
                        if (now.x + 1 <= MAX)
                            next = new Distance(now.x + 1, now.time + 1);
                        break;
                    case 2:
                        if (now.x * 2 <= MAX)
                            next = new Distance(now.x * 2, now.time);
                        break;
                }

                if (next != null && !visited[next.x]) {
                    q.add(next);
                }
            }
        }
    }
}
