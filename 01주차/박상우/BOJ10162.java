//전자렌지
import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class boj_10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = 300; //정의 해줘도 되고 안해도 됨. 300,60,10 쓰는 것보다 A,B,C 로 쓰는게 편해서 정희함 , *대입연산 1회
        int B = 60; // *대입연산 1회
        int C = 10; // *대입연산 1회

        int a,b,c; // *대입연산 1회

        int T = Integer.parseInt(br.readLine()); //*대입연산 1회

        if (T % 10 != 0) {
            System.out.println(-1);
        } else {
            a = T / A; // 100을 예로 들면 a = 100/300 -> 0
            T = T % A; // 100 % 300 -> 100
            b = T / B; // b = 100/60 -> 1
            T = T % B; // 100 % 60 -> 40
            c = T / C; // 40 / 10 -> 4

            System.out.println(a + " " + b + " " + c);
        }
    }
}
