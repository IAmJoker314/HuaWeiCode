import java.util.Arrays;
import java.util.Scanner;

public class Chorus24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){

            int N = scanner.nextInt();
            int[] chorus = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                chorus[i] = scanner.nextInt();
            }

            int[] dp1 = new int[N + 1];
            int[] dp2 = new int[N + 1];

            Arrays.fill(dp1, 1);
            Arrays.fill(dp2, 1);


            for (int i = 1; i <= N; i++) {
                for(int j = 1; j < i; j++){
                    if(chorus[i] > chorus[j]){
                        dp1[i] = Math.max(dp1[j] + 1, dp1[i]);
                    }
                }
            }

            for (int i = N; i >= 1; i--) {
                for(int j = N; j > i; j--){
                    if(chorus[i] > chorus[j]){
                        dp2[i] = Math.max(dp2[j] + 1, dp2[i]);
                    }
                }
            }

            int minCut = N;
            for (int i = 1; i <= N; i++) {
                if(N - dp1[i] - dp2[i] + 1 < minCut){
                    minCut = N - dp1[i] - dp2[i] + 1;
                }
            }

            System.out.println(minCut);
        }

     }
}
