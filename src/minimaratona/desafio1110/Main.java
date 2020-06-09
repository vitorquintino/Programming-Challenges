package minimaratona.desafio1110;

import java.util.ArrayList;
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

        int number;

        while((number = sc.nextInt()) != 0){
            if(number == 1){
                System.out.println("Discarded cards:");
                System.out.println("Remaining card: 1");
                continue;
            }
            ArrayList<Integer> discarded = new ArrayList<>();

            Queue queue = new Queue();

            for(int i = 1; i <= number; i++){
                queue.put(i);
            }

            while(queue.size() != 1){
                Integer firstToPop = queue.pop();

                discarded.add(firstToPop);

                Integer secondToPop = queue.pop();

                queue.put(secondToPop);
            }

            System.out.print("Discarded cards:");
            for(int i = 0; i < discarded.size() - 1; i++){
                System.out.print(" " + discarded.get(i) + ",");
            }
            System.out.print(" " + discarded.get(discarded.size() - 1) + "\n");

            System.out.println("Remaining card: " + queue.getRemaining());
        }
    }

    public static class Queue{
        ArrayList<Integer> queue = new ArrayList<>();

        public Queue(){

        }

        public boolean put(Integer number){
            queue.add(number);

            return true;
        }

        public Integer pop(){
            Integer firstValue = queue.get(0);

            queue.remove(0);

            return firstValue;
        }

        public Integer size(){
            return queue.size();
        }

        public Integer getRemaining(){
            return queue.get(0);
        }
    }
}
/*
7
19
10
6
0


1
49
0

 */
