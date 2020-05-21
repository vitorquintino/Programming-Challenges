package ep2.uri1905;

import java.util.Scanner;


/*
    Integrantes do grupo:

    Hugo Bechtolt Curi - 10284198
    Guilherme Estevam Ferreira Putzeys - 10424972
    Vitor Santos Quintino - 10258880
*/


public class Main {

    private static boolean result = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();
        sc.nextLine();

        Vertice[][] board = new Vertice[6][6];
        initializeGraph(board);

        for(int i = 0; i < tests; i++){
            sc.nextLine();
            result = false;

            for(int j = 1; j <= 5; j++){
                String[] entries = sc.nextLine().split(" ");

                if(entries[0].equals("") || entries[0].equals(" ")){
                    j--;
                    continue;
                }

                for(int k = 0; k < entries.length; k++){
                    board[j][k + 1].isConnected = Integer.parseInt(entries[k]);
                }
            }

            run(board, 1, 1);

            if(result){
                System.out.println("COPS");
            }
            else System.out.println("ROBBERS");

            initializeGraph(board);
        }

    }

    private static void run(Vertice[][] board, int i, int j) {
        if(board[i][j].isConnected == 1) return;

        board[i][j].isVisited = 1;

        if(i == 5 && j == 5) {
            result = true;
        }

        if(!result){
            int nextIDown = i + 1;
            int nextJRight = j + 1;
            int nextIUp = i - 1;
            int nextJLeft = j - 1;

            if(nextIDown <= 5){
                if(board[nextIDown][j].isConnected == 0 && board[nextIDown][j].isVisited == 0) run(board, nextIDown, j);
            }
            if(nextJRight <= 5){
                if(board[i][nextJRight].isConnected == 0 && board[i][nextJRight].isVisited == 0) run(board, i, nextJRight);
            }
            if(nextIUp > 0){
                if(board[nextIUp][j].isConnected == 0 && board[nextIUp][j].isVisited == 0) run(board, nextIUp, j);
            }
            if(nextJLeft > 0){
                if(board[i][nextJLeft].isConnected == 0 && board[i][nextJLeft].isVisited == 0) run(board, i, nextJLeft);
            }
        }
    }

    private static void initializeGraph(Vertice[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Vertice();
            }
        }
    }

    public static class Vertice {
        public Vertice() {

        }

        int isConnected;
        int isVisited;
    }
}

/*
2

0 0 0 0 1
1 1 0 0 1
0 1 0 0 0
0 0 0 1 1
1 1 0 0 0

0 0 0 0 1
1 1 0 0 1
0 1 0 0 0
0 0 1 1 1
1 1 0 0 0

 */