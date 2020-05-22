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

            int biggestCombination = findBiggestCombination(maxWeight, weights, values, values.length);

            if(biggestCombination >= resistance){
                System.out.println("Missao completada com sucesso");
            }
            else{
                System.out.println("Falha na missao");
            }
        }
    }

    private static int findBiggestCombination(int W, int[] wt, int[] val, int n) {
        int[][] mat = new int[n + 1][W + 1];
        for (int r = 0; r < W + 1; r++) {
            mat[0][r] = 0;
        }
        for (int c = 0; c < n + 1; c++) {
            mat[c][0] = 0;
        }

        for (int item = 1; item <= n; item++) {
            for (int capacity = 1; capacity <= W; capacity++) {
                int maxValWithoutCurr = mat[item - 1][capacity];
                int maxValWithCurr = 0;

                int weightOfCurr = wt[item - 1];
                if (capacity >= weightOfCurr) {
                    maxValWithCurr = val[item - 1];

                    int remainingCapacity = capacity - weightOfCurr;
                    maxValWithCurr += mat[item - 1][remainingCapacity];
                }

                mat[item][capacity] = Math.max(maxValWithoutCurr, maxValWithCurr);
            }
        }

        return mat[n][W];
    }

    private static int max(int i, int j) {
        return Math.max(i, j);
    }
}
