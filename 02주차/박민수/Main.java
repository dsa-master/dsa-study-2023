package BFS.BOJ13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

    static int N; // 수빈이의 위치
    static int K; // 동생의 위치
    static final int DISTANCE_MAX = 100000;
    static int[] counter = new int[100001]; // INDEX : 현재위치, VALUE : 최소이동횟수

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(counter, Integer.MAX_VALUE);

        // 처음 위치 큐에 삽입
        q.add(N);
        counter[N] = 0;
        while(!q.isEmpty()) {
            int now = q.poll();

            if (now == K) {
                System.out.println(counter[K]);
                break;
            }

            // 걷는 경우, 순간이동 하는 경우 계산
            for (int i = 0; i < 3; i++) {

                switch (i) {
                    case 0:
                        if (now - 1 >= 0 && counter[now - 1] > counter[now] + 1) {
                            q.add(now - 1);
                            counter[now - 1] = counter[now] + 1;
                        }
                        break;
                    case 1:
                        if (now + 1 <= DISTANCE_MAX && counter[now + 1] > counter[now] + 1) {
                            q.add(now + 1);
                            counter[now + 1] = counter[now] + 1;
                        }
                        break;
                    case 2:
                        if (now * 2 <= DISTANCE_MAX && counter[now * 2] > counter[now]) {
                            q.add(now * 2);
                            counter[now * 2] = counter[now];
                        }
                        break;
                }
            }
        }
    }
}
