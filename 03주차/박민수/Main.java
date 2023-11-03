package BackTracking.BOJ9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 백준 9663번
 * N-Queen
 * 2023-10-27
 *
 * Back Tracking
 */

public class Main {

    static int N; // 체스판 크기, 퀸의 개수, 1 <= N < 15
    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            placedQueen(1, i);
        }

        System.out.println(answer);
    }

    public static void placedQueen(int row, int col) {
        // 해당 위치에 퀸을 놓았을 때 막히는 부분 체크
        // 새롭게 알게된 사실 : 열의 차와 행의 차가 같을 경우 대각선에 놓여있는 경우임
        mark(row, col);

        // 종료 조건
        if (row == N) {
            answer++;
            // 백트래킹
            unmark(row, col);
            return;
        }

        for (int i = 1; i <= N; i++) {
            // 다음 단계 조건
            if (map[row + 1][i] == 0) {
                placedQueen(row + 1, i);
            }
        }

        // 백트래킹
        unmark(row, col);
    }

    public static void mark(int cx, int cy) {
        int times = 1;
        map[cx][cy] = cx;
        // 남아있는 행 만큼
        for(int nx = cx + 1; nx <= N; nx++) {
            for(int dy = -1; dy <= 1; dy++) {
                int ny = cy + dy * times;
                if (1 <= nx && nx <= N && 1 <= ny && ny <= N && map[nx][ny] == 0) {
                    map[nx][ny] = cx;
                }
            }
            times++;
        }
    }

    public static void unmark(int cx, int cy) {

        int times = 1;
        map[cx][cy] = 0;
        // 남아있는 행 만큼
        for(int nx = cx + 1; nx <= N; nx++) {
            for(int dy = -1; dy <= 1; dy++) {
                int ny = cy + dy * times;
                if (1 <= nx && nx <= N && 1 <= ny && ny <= N && map[nx][ny] == cx) {
                    map[nx][ny] = 0;
                }
            }
            times++;
        }
    }
}
