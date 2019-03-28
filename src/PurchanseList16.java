
import java.util.Scanner;

//加了限制条件的背包问题
public class PurchanseList16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int m = scanner.nextInt();

        int[] v = new int[m + 1];
        int[] p = new int[m + 1];
        int[] vTp = new int[m + 1];
        int[] q = new int[m + 1];

        for(int i = 1; i <= m; i++)
        {
            v[i] = scanner.nextInt();
            p[i] = scanner.nextInt();
            vTp[i] = v[i] * p[i];
            q[i] = scanner.nextInt();
        }

        int maxValue = dp(N, m, v, p, vTp, q);

        System.out.println(maxValue);

    }

    private static int dp(int N, int m, int[] v, int[] p, int[] vTp, int[] q) {
        int[][] dp = new int[m + 1][N + 1];
        int maxValue = 0;

        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= N; j++) {
                if(q[i] == 0)
                {
                    if(v[i] <= j)
                    {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + vTp[i]);
                    }
                }
                else
                {
                    if(v[i] + v[q[i]] <= j)
                    {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + vTp[i]);
                    }

                }

                if(dp[i][j] > maxValue)
                {
                    maxValue = dp[i][j];
                }

            }

        }
        return maxValue;
    }

}