package ep1.uri1100;

import java.util.ArrayList;
import java.util.Scanner;

/*
    Integrantes do grupo:

    Hugo Bechtolt Curi - 10284198
    Guilherme Estevam Ferreira Putzeys - 10424972
    Vitor Santos Quintino - 10258880
*/

public class Main {

    static boolean stopKey = false;
    static int objectiveX = 0;
    static int objectiveY = 0;
    static int result = 100;
    static int mostProbableWay = 0;

    public static void main(String[] args) {
        Vertice[][] xadrez = new Vertice[9][9];
        initializeGraph(xadrez);

        Scanner sc = new Scanner(System.in);

        int startX = 0;
        int startY = 0;

        while (sc.hasNext()) {
            String[] positions = sc.nextLine().split(" ");

            if (positions[0].equals(positions[1])) {
                System.out.println("To get from " + positions[0] + " to " + positions[1] + " takes 0 knight moves.");
                continue;
            }

            startX = (int) (positions[0].charAt(0) - 96);
            startY = (int) (positions[0].charAt(1) - 48);

            objectiveX = (int) (positions[1].charAt(0) - 96);
            objectiveY = (int) (positions[1].charAt(1) - 48);

            doDijkstra(xadrez, startX, startY);

            System.out.println("To get from " + positions[0] + " to " + positions[1] + " takes " + result + " knight moves.");

            result = 900;
            initializeGraph(xadrez);
        }
    }

    private static void doDijkstra(Vertice[][] xadrez, int startX, int startY) {
        ArrayList<DijkstraVertice> unsettledNodes = new ArrayList<>();

        unsettledNodes.add(new DijkstraVertice(startX, startY, 0));

        while(unsettledNodes.size() > 0){
            DijkstraVertice point = unsettledNodes.get(0);
            unsettledNodes.remove(0);

            if(point.x == objectiveX && point.y == objectiveY){
                if(point.moves < result) result = point.moves;
            }

            xadrez[point.x][point.y].isVisited = 1;

            int newX, newY;

            //direita cima
            newX = point.x + 2;
            newY = point.y + 1;
            if (newX <= 8 && newY <= 8 && xadrez[newX][newY].isVisited != 1) {
                unsettledNodes.add(new DijkstraVertice(newX, newY, point.moves + 1));
            }

            //cima direita
            newX = point.x + 1;
            newY = point.y + 2;
            if (newX <= 8 && newY <= 8  && xadrez[newX][newY].isVisited != 1) {
                unsettledNodes.add(new DijkstraVertice(newX, newY, point.moves + 1));
            }

            //direita baixo
            newX = point.x + 2;
            newY = point.y - 1;
            if (newX <= 8 && newY >= 1  && xadrez[newX][newY].isVisited != 1) {
                unsettledNodes.add(new DijkstraVertice(newX, newY, point.moves + 1));
            }

            //cima esquerda
            newX = point.x - 1;
            newY = point.y + 2;
            if (newX >= 1 && newY <= 8  && xadrez[newX][newY].isVisited != 1) {
                unsettledNodes.add(new DijkstraVertice(newX, newY, point.moves + 1));
            }

            //esquerda cima
            newX = point.x - 2;
            newY = point.y + 1;
            if (newX >= 1 && newY <= 8  && xadrez[newX][newY].isVisited != 1) {
                unsettledNodes.add(new DijkstraVertice(newX, newY, point.moves + 1));
            }

            //esquerda baixo
            newX = point.x - 2;
            newY = point.y - 1;
            if (newX >= 1 && newY >= 1  && xadrez[newX][newY].isVisited != 1) {
                unsettledNodes.add(new DijkstraVertice(newX, newY, point.moves + 1));
            }

            //baixo esquerda
            newX = point.x - 1;
            newY = point.y - 2;
            if (newX >= 1 && newY >= 1  && xadrez[newX][newY].isVisited != 1) {
                unsettledNodes.add(new DijkstraVertice(newX, newY, point.moves + 1));
            }

            //baixo direita
            newX = point.x + 1;
            newY = point.y - 2;
            if (newX <= 8 && newY >= 1  && xadrez[newX][newY].isVisited != 1) {
                unsettledNodes.add(new DijkstraVertice(newX, newY, point.moves + 1));
            }
        }
    }

    private static void initializeGraph(Vertice[][] grafo) {
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[i].length; j++) {
                grafo[i][j] = new Vertice();
            }
        }
    }

    public static class Vertice {
        public Vertice() {

        }

        int isConnected;
        int isVisited;
    }

    public static class DijkstraVertice {
        public DijkstraVertice(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }

        public DijkstraVertice(){

        }

        int x;
        int y;
        int moves;
    }
}

/*
e2 e4
a1 b2
b2 c3
a1 h8
a1 h7
h8 a1
b1 c3
f6 f6


 */