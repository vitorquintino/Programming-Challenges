package ep2.uri1798;

import java.util.Scanner;

/*
    Integrantes do grupo:

    Hugo Bechtolt Curi - 10284198
    Guilherme Estevam Ferreira Putzeys - 10424972
    Vitor Santos Quintino - 10258880
*/

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();

        int fullSize = sc.nextInt();

        int[] weights = new int[tests];
        int[] values = new int[tests];

        for(int i = 0; i < tests; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        System.out.println(findBiggestCombination(weights, values, tests, fullSize));
    }

    private static int findBiggestCombination(int[] wt, int[] val, int n, int W) {
        int dp[] = new int[W + 1];

        // Fill dp[] using above recursive formula
        for(int i = 0; i <= W; i++){
            for(int j = 0; j < n; j++){
                if(wt[j] <= i){
                    dp[i] = max(dp[i], dp[i - wt[j]] +
                            val[j]);
                }
            }
        }
        return dp[W];
    }

    private static int max(int i, int j) {
        return Math.max(i, j);
    }
}
