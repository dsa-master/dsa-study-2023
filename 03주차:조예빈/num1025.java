import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num1025 {
    static int N = 0;
    static int M = 0;
    static int[][] inputNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        inputNum = new int[N][M];

        for (int i = 0; i < N; i++) {
            String numInput = br.readLine();
            for (int j = 0; j < M; j++) {
                inputNum[i][j] = Integer.parseInt(String.valueOf(numInput.charAt(j)));
            }
        }

        int result = findLargestPerfectSquare(inputNum);
        System.out.println(result);
        br.close();
    }

    public static int findLargestPerfectSquare(int[][] inputNum) {
        int largest = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int dx = -N; dx < N; dx++) {
                    for (int dy = -M; dy < M; dy++) {
                        if (dx == 0 && dy == 0) {
                            continue;
                        }

                        int newRow = i, newCol = j;
                        StringBuilder strNum = new StringBuilder();

                        while (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M) {
                            strNum.append(inputNum[newRow][newCol]);
                            int num = Integer.parseInt(strNum.toString());

                            if (isPerfectSquare(num) && num > largest) {
                                largest = num;
                            }
                            newRow += dx;
                            newCol += dy;
                        }
                    }
                }
            }
        }

        return largest; // 완전 제곱수가 없을 경우
    }

    public static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
