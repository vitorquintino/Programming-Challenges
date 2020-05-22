package ep2.uri1288;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();

        int[] values;
        int[] weights;

        for(int i = 0; i < tests; i++){
            int quantity = sc.nextInt();
            values = new int[quantity];
            weights = new int[quantity];

            for(int j = 0; j < quantity; j++){
                values[j] = sc.nextInt();
                weights[j] = sc.nextInt();
            }

            int maxWeight = sc.nextInt();
            int resistance = sc.nextInt();

            int biggestCombination = findBiggestCombination(weights, values, values.length, maxWeight + 1);

            if(biggestCombination >= resistance){
                System.out.println("Missao completada com sucesso");
            }
            else{
                System.out.println("Falha na missao");
            }
        }
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
