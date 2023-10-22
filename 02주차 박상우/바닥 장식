package BAEKJOON;
//바닥 장식
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1388_Buffer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());//세로 크기 입력받기
        int M = Integer.parseInt(st.nextToken());//가로 크기 입력받기
        int count = 0;
        char[][] arr = new char[N][M];//방 크기의 2차원 배열 생성

        for (int i = 0; i < N; i++) {//탐색을 위해 세로크기 만큼 반복문
            String t = br.readLine();//방에 나무판자 입력받기('ㅣ' or '-')
            for (int j = 0; j < M; j++) {//탐색을 위해 "" (가로)
                arr[i][j] = t.charAt(j);//t에서 j번째 열에 해당하는 문자를 가져와서 2차원 배열 arr의 i행 j열에 할당
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i != 0 && arr[i - 1][j] == '|' && arr[i][j] == '|') {// '|'가 위아래로 붙어있으면 하나로 취급해서 더하지 않는다.
                    continue;
                } else if (j != 0 && arr[i][j - 1] == '-' && arr[i][j] == '-') {//'-'가 붙어있으면 하나로 취급
                    continue;
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
