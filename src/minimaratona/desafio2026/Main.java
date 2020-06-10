package minimaratona.desafio2026;

import java.util.Scanner;

/*
    Integrantes do grupo:

    Hugo Bechtold Curi - 10284198
    Guilherme Estevam Ferreira Putzeys - 10424972
    Vitor Santos Quintino - 10258880
*/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int caseTests = sc.nextInt();

        for(int i = 0; i < caseTests; i++){
            int packages = sc.nextInt();
            int W = sc.nextInt();

            int[] weights = new int[packages];
            int[] values = new int[packages];

            for(int j = 0; j < packages; j++){
                values[j] = sc.nextInt();
                weights[j] = sc.nextInt();
            }

            int biggestCombination = findBiggestCombination(W, weights, values, packages);

            System.out.println("Galho " + (i + 1) + ":");
            System.out.println("Numero total de enfeites: " + biggestCombination);
            System.out.println();
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
}

/*
3
3
30
30 15
10 12
12 18

 */
