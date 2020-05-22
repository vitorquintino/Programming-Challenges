package ep2.uri1798;

import java.util.ArrayList;
import java.util.Scanner;

/*
    Integrantes do grupo:

    Hugo Bechtolt Curi - 10284198
    Guilherme Estevam Ferreira Putzeys - 10424972
    Vitor Santos Quintino - 10258880
*/

public class Main {

    static int[][] maxValues = new int[5000][5000];

    public static void main(String[] args) {
        startMaxValues();

        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();

        int fullSize = sc.nextInt();

        ArrayList<Order> orders = new ArrayList<>();

        for(int i = 0; i < tests; i++) {
            Order order = new Order();

            order.size = sc.nextInt();
            order.price = sc.nextInt();

            orders.add(order);
        }

        System.out.println(calculateMaxValue(orders, 0, fullSize));
    }

    private static void startMaxValues() {
        for(int i = 0; i < maxValues.length; i++){
            for(int j = 0; j < maxValues[i].length; j++){
                maxValues[i][j] = -1;
            }
        }
    }

    public static int calculateMaxValue(ArrayList<Order> orders, int currentIndex, int currentSize){
        if(currentIndex == orders.size()) return 0;
        if(currentSize == 0) return 0;
        if(currentSize < 0) return -10000;

        int currentMaxValue = -1;

        if(maxValues[currentIndex][currentSize] == -1){
            currentMaxValue = Math.max(calculateMaxValue(orders, currentIndex + 1, currentSize), orders.get(currentIndex).price + calculateMaxValue(orders, currentIndex, currentSize - orders.get(currentIndex).size));
            maxValues[currentIndex][currentSize] = currentMaxValue;
        }

        return currentMaxValue;
    }

    public static class Order {
        public Order() {

        }

        int size;
        int price;
    }
}
