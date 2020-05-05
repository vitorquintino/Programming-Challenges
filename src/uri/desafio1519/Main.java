package uri.desafio1519;

import java.util.*;

/*
    Integrantes do grupo:

    Hugo Bechtolt Curi - 10284198
    Guilherme Estevam Ferreira Putzeys - 10424972
    Vitor Santos Quintino - 10258880
*/

public class Main {

    static String[] originalPhrase;
    static ArrayList<String> orderedPhrase = new ArrayList<>();

    static Map<String, String> abbreviatedWords = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            abbreviatedWords.clear();

            String phrase = sc.nextLine();

            if(phrase.equals(".")) break;

            originalPhrase = phrase.split(" ");
            orderedPhrase = new ArrayList<>(Arrays.asList(originalPhrase));

            Collections.sort(orderedPhrase);

            while(true){
                findWordsToAbbreviate(orderedPhrase.get(0).charAt(0));

                if(orderedPhrase.size() == 1 && orderedPhrase.get(0).length() > 2){
                    abbreviatedWords.put(orderedPhrase.get(0), orderedPhrase.get(0).charAt(0) + ".");
                    break;
                }
                if(orderedPhrase.size() == 0) break;
            }

            for(int i = 0; i < originalPhrase.length; i++){
                if(abbreviatedWords.containsKey(originalPhrase[i])){
                    System.out.print(abbreviatedWords.get(originalPhrase[i]));
                }
                else{
                    System.out.print(originalPhrase[i]);
                }

                if((i + 1) != originalPhrase.length) System.out.print(" ");
            }

            System.out.println();

            System.out.println(abbreviatedWords.size());

            Map<String, String> sortedWords = new TreeMap<>(abbreviatedWords);

            Iterator it = sortedWords.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();

                System.out.println(pair.getValue() + " = " + pair.getKey());
            }
        }
    }

    private static void findWordsToAbbreviate(char firstLetter) {
        int size = 0;
        String wordToBeAbbreviated = "";

        while(orderedPhrase.get(0).charAt(0) == firstLetter){
            int occurrences = findAllOccurrences(orderedPhrase.get(0));

            if((orderedPhrase.get(0).length() - 2) * occurrences > size){
                size = (orderedPhrase.get(0).length() - 2) * occurrences;

                wordToBeAbbreviated = orderedPhrase.get(0);
            }

            orderedPhrase.remove(0);

            if(orderedPhrase.size() == 0) break;
        }

        if(!wordToBeAbbreviated.isEmpty()){
            abbreviatedWords.put(wordToBeAbbreviated, wordToBeAbbreviated.charAt(0) + ".");
        }
    }

    private static int findAllOccurrences(String toCount) {
        int count = 0;

        for(String s: orderedPhrase){
            if(s.equals(toCount)) count++;
        }

        return count;
    }
}


/*
hoje eu visitei meus pais
tive que lavar meu cachorro pois ele estava fedendo
.

abcdef abc abc abc
abcd abc abc abc
abcd abcd abc abc abc
.


 */