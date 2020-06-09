package minimaratona.desafio2344;

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

        int number = sc.nextInt();

        if(number == 0) System.out.println("E");
        else if(number >= 1 && number <= 35) System.out.println("D");
        else if(number >= 36 && number <= 60) System.out.println("C");
        else if(number >= 61 && number <= 85) System.out.println("B");
        else if(number >= 86 && number <= 100) System.out.println("A");
    }
}
