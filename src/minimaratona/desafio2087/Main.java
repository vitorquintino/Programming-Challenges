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
            String all = "";

            for(int i = 0; i < number; i++){
                String nextString = sc.next();

                strings.add(nextString);

                all = all.concat("-" + nextString);
            }

            all = all.concat("-");

            boolean result = true;
            for(String s: strings){
                String aux = all;

                int count = all.length() - aux.replace("-" + s, "").length();

                if(count > 2 || count == 0) result = false;
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