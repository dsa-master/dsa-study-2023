import java.util.Scanner;

public class num12845 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cards = new int[n];

        for(int i=0;i<n;i++){
            cards[i] = sc.nextInt();
        }
        int maxCard = 0;
        int maxCardIndex = 0;

        for(int i=0;i<n;i++){
            if(maxCard<cards[i]){
                maxCard = cards[i];
                maxCardIndex = i;
            }
        }
        int total = 0;

        for(int i=0;i<n;i++){
            if(i!=maxCardIndex){
                total += maxCard + cards[i];
            }
        }
        System.out.println(total);
        sc.close();
    }
}
