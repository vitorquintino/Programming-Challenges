package uri.desafio1122;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /*
    Integrantes do grupo:

    Hugo Bechtolt Curi - 10284198
    Guilherme Estevam Ferreira Putzeys - 10424972
    Vitor Santos Quintino - 10258880
    */

    static List<Integer> transactions = new ArrayList<>();

    static ArrayList<String> sequences = new ArrayList<>();
    static ArrayList<String> finalSequences = new ArrayList<>();


    static int money, numberOfTransactions;

    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);

        while(true){
            numberOfTransactions = sn.nextInt();
            money = sn.nextInt();

            if(numberOfTransactions == 0 && money == 0) break;

            for(int i = 0; i < numberOfTransactions; i++){
                int nextTransaction = sn.nextInt();

                transactions.add(nextTransaction);
            }

            go(0, 0, 'I', "");

            reverseSequenceStrings();
            printResults();

            sequences.clear();
            finalSequences.clear();
            transactions.clear();
        }
    }

    private static void printResults() {
        if(finalSequences.size() == 0){
            System.out.println("*");
            return;
        }

        if(finalSequences.size() == 1){
            System.out.println(finalSequences.get(0));
            return;
        }

        boolean equal;
        StringBuilder result = new StringBuilder();
        char current;

        for(int i = 0; i < numberOfTransactions; i++){
            equal = true;
            current = finalSequences.get(0).charAt(i);

            for(int j = 1; j < finalSequences.size(); j++){
                if(current != finalSequences.get(j).charAt(i)){
                    equal = false;
                }
            }

            if(equal) result.append(finalSequences.get(0).charAt(i));
            else result.append("?");
        }

        System.out.println(result.toString());
    }

    private static void reverseSequenceStrings() {
        for(String s: sequences){
            finalSequences.add(new StringBuilder(s).reverse().toString());
        }
    }

    public static void go(int index, int sum, char op, String sequence){
        if((index) == transactions.size()){
            if(sum == money){
                sequences.add(sequence);
            }
        }
        else {
            go(index + 1, sum + transactions.get(index), 'A', "+" + sequence);
            go(index + 1, sum - transactions.get(index), 'S', "-" + sequence);
        }
    }
}


/*
5 7
1
2
3
4
5
0 0

2 3
1
2
0 0

40 0
17
17
17
17
17
17
17
17
17
17
17
17
17
17
17
17
17
17
17
17
17
17
17
23
23
23
23
23
23
23
23
23
23
23
23
23
23
23
23
23
0 0

 */