package ep1.uri1082;


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
    private static ArrayList<String> connectedGraphsPathFinal = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int caseTests = sc.nextInt();

        for(int i = 1; i <= caseTests; i++){
            connectedGraphs = 0;
            connectedGraphsPath.clear();
            connectedGraphsPathFinal.clear();

            int arestas = sc.nextInt();
            int vertices = sc.nextInt();

            Vertice[][] grafo = new Vertice[arestas + 1][arestas + 1];
            initializeGraph(grafo);

            for(int j = 0; j < vertices; j++){
                String first = sc.next();
                String second = sc.next();

                int firstAresta = (int) first.charAt(0) - 96;
                int secondAresta = (int) second.charAt(0) - 96;

                addConnection(grafo, firstAresta, secondAresta);
            }

            while(true){
                int nextIndex = findNonVisitedVertice(grafo);

                if(nextIndex < 0) break;

                connectedGraphsPathFinal.add("");
                connectedGraphsPath.add(new ArrayList<>());

                findConnectedGraphs(grafo, nextIndex);

                connectedGraphs++;
            }

            if(connectedGraphs == 0) connectedGraphs = grafo.length;

            checkIfVerticeHasNoConnections(grafo);

            System.out.println("Case #" + i + ":");
            int l = 0;
            for(ArrayList s: connectedGraphsPath){
                int size = s.size();
                for(int k = 0; k < size; k++) {
                    connectedGraphsPathFinal.set(l, connectedGraphsPathFinal.get(l).concat(findFirst(s)));
                }
                l++;
            }
            printResults();
            System.out.println(connectedGraphs + " connected components");
            System.out.println();
        }
    }

    private static void printResults() {
        int size = connectedGraphsPathFinal.size();
        for(int i = 0; i < size; i++){
            int indiceMenor = findFirstToPrint();
            System.out.println(connectedGraphsPathFinal.get(indiceMenor));
            connectedGraphsPathFinal.remove(indiceMenor);
        }
    }

    private static int findFirstToPrint() {
        int menor = 999, indiceMenor = 0;
        for(int i = 0; i < connectedGraphsPathFinal.size(); i++){
            if((int) connectedGraphsPathFinal.get(i).charAt(0) < menor){
                menor = (int) connectedGraphsPathFinal.get(i).charAt(0);
                indiceMenor = i;
            }
        }

        return indiceMenor;
    }

    private static String findFirst(ArrayList s) {
        int menor = 999, indiceMenor = 0;
        for(int i = 0; i < s.size(); i++){
            if((int) s.get(i) < menor) {
                menor = (int) s.get(i);
                indiceMenor = i;
            }
        }

        s.remove(indiceMenor);

        return (char) menor + ",";
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

                connectedGraphsPathFinal.add("");
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
3
3 1
a c
10 10
a b
a c
a g
b c
c g
e d
d f
h i
i j
j h
6 4
a b
b c
c a
e f

 */