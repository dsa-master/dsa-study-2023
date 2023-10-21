// 1105번 : L <= n <= R 을 만족하는 자연수 n 중에 8이 가장 적게 들어있는 수의 8의 개수 구하기
// L R 입력 ( L <= R <= 2,000,000,000
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon1105 {
    public static void main(String[] args) throws IOException {

       // 8이 들어가는 경우 -> L과 R이 공통 자릿수에 같은 숫자(ex 8800 8812)를 갖고잇는데 그 숫자가 8인 경우
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String LR = br.readLine(); // 개행문자를 기준으로 입력받는 것
//        StringTokenizer st = new StringTokenizer(" ");
//        st.nextToken();
        String[] arr = LR.split(" ");
        String L = arr[0];
        String R = arr[1];

        // 조건 1 -> 같은 자리수여야함 다른 자리수면 개수 무조건 0 -> 길이
        if(L.length() != R.length()){
            System.out.println(0);
        } else {
            int count = 0;
            for( int i = 0; i < L.length()&&L.charAt(i)==R.charAt(i); i++){
                // 조건2 각 문자의 자릿수가 8로 같으면 카운트 추가
                // String.charAt(i) 문자열에서 한문자씩 반환
                if( R.charAt(i)=='8' ){
                    count++;
                }
            }
            System.out.println(count);

        }

    }
}
