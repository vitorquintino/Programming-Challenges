package ep1.uri2870;

/*
    Integrantes do grupo:

    Hugo Bechtolt Curi - 10284198
    Guilherme Estevam Ferreira Putzeys - 10424972
    Vitor Santos Quintino - 10258880
*/


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static int connectedGraphs;
    private static ArrayList<ArrayList<Integer>> connectedGraphsPath = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int quantidadeVertices = sc.nextInt();
        int quantidadeArestas = sc.nextInt();

        if(quantidadeArestas == 0){
            System.out.println("Junior");
            System.exit(0);
        }

        Vertice[][] grafo = new Vertice[quantidadeVertices + 1][quantidadeVertices + 1];
        initializeGraph(grafo);

        for (int j = 0; j < quantidadeArestas; j++) {
            int firstAresta = sc.nextInt();
            int secondAresta = sc.nextInt();

            addConnection(grafo, firstAresta, secondAresta);
        }

        while (true) {
            int nextIndex = findNonVisitedVertice(grafo);

            if (nextIndex < 0) break;

            connectedGraphsPath.add(new ArrayList<>());

            findConnectedGraphs(grafo, nextIndex);

            connectedGraphs++;
        }

        if (connectedGraphs == 0) connectedGraphs = grafo.length;

        checkIfVerticeHasNoConnections(grafo);

        int qtdVertices = connectedGraphsPath.get(0).size();

        if(qtdVertices == 0) System.out.println("Thiago");
        if(qtdVertices % 2 == 0) System.out.println("Thiago");
        else System.out.println("Junior");
    }

    private static void checkIfVerticeHasNoConnections(Vertice[][] grafo) {
        boolean hasConnection;

        for (int i = 1; i < grafo.length; i++) {
            hasConnection = false;

            for (int j = 1; j < grafo[i].length; j++) {
                if (grafo[i][j].isConnected == 1) {
                    hasConnection = true;
                }
            }

            if (!hasConnection) {
                connectedGraphs++;

                connectedGraphsPath.add(new ArrayList<>());
                connectedGraphsPath.get(connectedGraphs - 1).add(i + 96);
            }
        }
    }

    private static int findNonVisitedVertice(Vertice[][] grafo) {
        for (int i = 1; i < grafo.length; i++) {
            for (int j = 1; j < grafo[i].length; j++) {
                if (grafo[i][j].isConnected == 1 && grafo[i][j].isVisited != 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    private static void findConnectedGraphs(Vertice[][] grafo, int index) {
        if (!indexExists(index)) connectedGraphsPath.get(connectedGraphs).add(index + 96);

        for (int i = 1; i < grafo.length; i++) {
            if (grafo[index][i].isConnected == 1 && grafo[index][i].isVisited != 1) {
                grafo[index][i].isVisited = 1;
                grafo[i][index].isVisited = 1;

                findConnectedGraphs(grafo, i);
            }
        }
    }

    private static boolean indexExists(int index) {
        for (int i = 0; i < connectedGraphsPath.get(connectedGraphs).size(); i++) {
            if (connectedGraphsPath.get(connectedGraphs).get(i) == (index + 96)) {
                return true;
            }
        }
        return false;
    }

    private static void initializeGraph(Vertice[][] grafo) {
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[i].length; j++) {
                grafo[i][j] = new Vertice();
            }
        }
    }

    private static void addConnection(Vertice[][] grafo, int firstAresta, int secondAresta) {
        if (grafo.length > 1) {
            grafo[firstAresta][secondAresta].isConnected = 1;
            grafo[secondAresta][firstAresta].isConnected = 1;
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
6 5
1 2
2 3
3 4
4 5
5 6

2 1
1 2

1 0

 */