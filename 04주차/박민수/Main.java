package ClassFour.BOJ11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 백준 11660번
 * 구간 합 구하기 5
 * 2023-11-17
 *
 */

public class Main {
    static int N; // 1 <= N <= 1024
    static int M; // 1 <= M <= 100,000
    static int x1, y1, x2, y2; // x1 <= x2, y1 <= y2
    static int[][] numbers;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N;j ++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
                // 행 누적합 저장
                if (j == 1) {
                    dp[i][j] = numbers[i][j];
                } else {
                    dp[i][j] = dp[i][j - 1] + numbers[i][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            int total = 0;

            for (int a = x1; a <= x2; a++) {
                total += (dp[a][y2] - dp[a][y1 - 1]);
            }
            sb.append(total).append("\n");
        }

        System.out.println(sb);
    }
}
