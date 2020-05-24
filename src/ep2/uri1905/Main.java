package ep2.uri1905;

import java.util.Scanner;

/*
    Integrantes do grupo:
    Hugo Bechtolt Curi - 10284198
    Guilherme Estevam Ferreira Putzeys - 10424972
    Vitor Santos Quintino - 10258880
*/


public class Main {
    static boolean[][] board = new boolean[5][5];
    static boolean[][] boardVisited = new boolean[5][5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for(int i = 0; i < tests; i++){
            sc.nextLine();

            for(int j = 0; j < 5; j++){
                String line = sc.nextLine();
                String[] entries = line.split(" ");

                if(entries[0].equals("") || entries[0].equals(" ")){
                    continue;
                }

                for(int k = 0; k < 5; k++) {
                    board[j][k] = Integer.parseInt(entries[k]) == 1;
                }
            }
            if (catched(0, 0)) {
                System.out.println("COPS");
            } else {
                System.out.println("ROBBERS");
            }
            clearBoardVisited();
        }
    }

    public static void clearBoardVisited() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                boardVisited[i][j] = false;
            }
        }
    }
    public static boolean catched(int i, int j) {
        if (boardVisited[i][j]) return false;
        boardVisited[i][j] = true;
        if (board[i][j]) return false;
        try {
            if (catched(i -1, j)) return true;
        } catch (Exception error) {}
        try {
            if (catched(i, j -1)) return true;
        } catch (Exception error) {}
        try {
            if (catched(i + 1, j)) return true;
        } catch (Exception error) {}
        try {
            if (catched(i, j + 1)) return true;
        } catch (Exception error) {}

        if (i == 4 && j == 4) return true;
        return false;
    }
}