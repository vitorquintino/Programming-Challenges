package uri.desafio1259;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
    Integrantes do grupo:
    Hugo Bechtolt Curi - 10284198
    Guilherme Estevam Ferreira Putzeys - 10424972
    Vitor Santos Quintino - 10258880
*/

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> pares = new ArrayList<>();
        ArrayList<Integer> impares = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int numbers = sc.nextInt();

        for(int i = 0; i < numbers; i++){
            int nextNumber = sc.nextInt();

            if(nextNumber % 2 == 0) pares.add(nextNumber);
            else impares.add(nextNumber);
        }

        Collections.sort(pares);
        Collections.sort(impares, Collections.reverseOrder());

        for(Integer i: pares) System.out.println(i);
        for(Integer i: impares) System.out.println(i);
    }
}
