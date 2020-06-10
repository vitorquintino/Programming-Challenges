package minimaratona.desafio2087;

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

        while((number = sc.nextInt()) != 0) {
            ArrayList<String> strings = new ArrayList<>();
            boolean result = true;

            for(int i = 0; i < number; i++){
                String nextString = sc.next();
                if (result) {
                    for (String s: strings) {
                        if (s.startsWith(nextString) || nextString.startsWith(s)) {
                            result = false;
                        }
                    }
                }

                strings.add(nextString);
            }

            if(result) System.out.println("Conjunto Bom");
            else System.out.println("Conjunto Ruim");
        }
    }
}

/*
3
abc
dae
abcde
2
abc
def
0

2
abcdef
abc

 */