package uri.desafio1799;

import java.util.HashMap;
import java.util.Scanner;

/*
    Integrantes do grupo:
    Hugo Bechtolt Curi - 10284198
    Guilherme Estevam Ferreira Putzeys - 10424972
    Vitor Santos Quintino - 10258880
*/
public class Main {

    static int resultIda = 99999;
    static int resultVolta = 99999;
    static int points;
    static HashMap<String, Integer> code = new HashMap<>();
    static int lastIndex = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        points = sc.nextInt();
        int connections = sc.nextInt();

        int[][] graph = new int[points][points];

        for(int i = 0; i < connections; i++){
            String pointA = sc.next();
            String pointB = sc.next();

            int va = getPoint(pointA);
            int vb = getPoint(pointB);

            addConnection(graph, va, vb);
        }

        resultIda = doDijkstra(graph, getPoint("Entrada"), getPoint("*"));
        resultVolta = doDijkstra(graph, getPoint("*"), getPoint("Saida"));

        System.out.println(resultIda + resultVolta);
    }

    private static int getPoint(String point) {
        if(code.containsKey(point)) return code.get(point);
        else{
            code.put(point, lastIndex);
            lastIndex++;
            return lastIndex - 1;
        }
    }

    private static int doDijkstra(int[][] graph, int sourceNode, int returnValue) {
        int dist[] = new int[points];

        Boolean sptSet[] = new Boolean[points];

        for (int i = 0; i < points; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[sourceNode] = 0;

        for (int count = 0; count < points - 1; count++) {
            int u = minDistance(dist, sptSet);

            sptSet[u] = true;

            for (int v = 0; v < points; v++)
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + 1 < dist[v])
                    dist[v] = dist[u] + 1;
        }

        return dist[returnValue];
    }

    static int minDistance(int dist[], Boolean sptSet[]){
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < points; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    private static void addConnection(int[][] grafo, int firstAresta, int secondAresta) {
        grafo[firstAresta][secondAresta] = 1;
        grafo[secondAresta][firstAresta] = 1;
    }

    public static class Vertice {
        public Vertice() {

        }

        int isConnected;
        int isVisited;
    }
}

/*
16 20
Entrada A
A F
F C
C B
B D
C D
F J
J H
H G
J G
J *
* I
I L
L M
M K
K Saida
A K
C E
E I
I M


10 11
B A
Entrada A
B GT
GT H
H *
B *
* C
C I
I D
C D
D Saida

 */
