package ep1.uri1835;

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

        int caseTests = sc.nextInt();

        for(int i = 1; i <= caseTests; i++){
            connectedGraphs = 0;
            connectedGraphsPath.clear();

            int quantidadeVertices = sc.nextInt();
            int quantidadeArestas = sc.nextInt();


            if(quantidadeVertices == 0){
                System.out.print("Caso #" + i + ":");
                System.out.print(" a promessa foi cumprida\n");
            }
            if(quantidadeArestas == 0){
                int newQtd = quantidadeVertices - 1;

                System.out.print("Caso #" + i + ": ainda falta(m) " + newQtd + " estrada(s)\n");

                continue;
            }

            Vertice[][] grafo = new Vertice[quantidadeVertices + 1][quantidadeVertices + 1];
            initializeGraph(grafo);

            for(int j = 0; j < quantidadeArestas; j++){
                int firstAresta = sc.nextInt();
                int secondAresta = sc.nextInt();

                addConnection(grafo, firstAresta, secondAresta);
            }

            while(true){
                int nextIndex = findNonVisitedVertice(grafo);

                if(nextIndex < 0) break;

                connectedGraphsPath.add(new ArrayList<>());

                findConnectedGraphs(grafo, nextIndex);

                connectedGraphs++;
            }

            if(connectedGraphs == 0) connectedGraphs = grafo.length;

            checkIfVerticeHasNoConnections(grafo);

            System.out.print("Caso #" + i + ":");

            if(connectedGraphs == 1){
                System.out.print(" a promessa foi cumprida\n");
            }
            else{
                int qtd = connectedGraphs - 1;

                System.out.print(" ainda falta(m) " + qtd + " estrada(s)\n");
            }
        }
    }

    private static void checkIfVerticeHasNoConnections(Vertice[][] grafo) {
        boolean hasConnection;

        for(int i = 1; i < grafo.length; i++){
            hasConnection = false;

            for(int j = 1; j < grafo[i].length; j++){
                if(grafo[i][j].isConnected == 1){
                    hasConnection = true;
                }
            }

            if(!hasConnection){
                connectedGraphs++;

                connectedGraphsPath.add(new ArrayList<>());
                connectedGraphsPath.get(connectedGraphs - 1).add(i + 96);
            }
        }
    }

    private static int findNonVisitedVertice(Vertice[][] grafo) {
        for(int i = 1; i < grafo.length; i++){
            for(int j = 1; j < grafo[i].length; j++){
                if(grafo[i][j].isConnected == 1 && grafo[i][j].isVisited != 1){
                    return i;
                }
            }
        }

        return -1;
    }

    private static void findConnectedGraphs(Vertice[][] grafo, int index) {
        if(!indexExists(index)) connectedGraphsPath.get(connectedGraphs).add(index + 96);

        for(int i = 1; i < grafo.length; i++){
            if(grafo[index][i].isConnected == 1 && grafo[index][i].isVisited != 1){
                grafo[index][i].isVisited = 1;
                grafo[i][index].isVisited = 1;

                findConnectedGraphs(grafo, i);
            }
        }
    }

    private static boolean indexExists(int index) {
        for(int i = 0; i < connectedGraphsPath.get(connectedGraphs).size(); i++){
            if(connectedGraphsPath.get(connectedGraphs).get(i) == (index + 96)){
                return true;
            }
        }
        return false;
    }

    private static void initializeGraph(Vertice[][] grafo) {
        for(int i = 0; i < grafo.length; i++){
            for(int j = 0; j < grafo[i].length; j++){
                grafo[i][j] = new Vertice();
            }
        }
    }

    private static void addConnection(Vertice[][] grafo, int firstAresta, int secondAresta) {
        grafo[firstAresta][secondAresta].isConnected = 1;
        grafo[secondAresta][firstAresta].isConnected = 1;
    }


    public static class Vertice{
        public Vertice(){

        }

        int isConnected;
        int isVisited;
    }
}

/*
4
3
2
1 3
2 3
4
2
1 2
3 4
3
0
6
5
1 2
1 3
1 4
2 3
3 4

 */