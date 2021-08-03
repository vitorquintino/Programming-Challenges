package hackerrank;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int sockMerchant = sockMerchant(1, Collections.singletonList(10));
        int countingValleys = countingValleys(8, "DDUUDDUDUUUD");
        int jumpingOnClouds = jumpingOnClouds(Arrays.asList(0, 0, 0, 1, 0, 0));
        long repeatedString = repeatedString("a", 1000000000000L);
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        int numberOfPairs = 0;
        int[] socksByColor = new int[101];

        for (int currentColor : ar) {
            if (socksByColor[currentColor] == 1) {
                numberOfPairs++;
                socksByColor[currentColor] = 0;
            } else {
                socksByColor[currentColor] = 1;
            }
        }

        return numberOfPairs;
    }

    public static int countingValleys(int steps, String path) {
        int currentLevel = 0, numberOfValleys = 0;

        for(int i = 0; i < path.length(); i++){
            char currentStep = path.charAt(i);

            if(currentStep == 'U'){
                currentLevel++;
            }
            else{
                currentLevel--;
            }

            if(currentLevel == 0 && currentStep == 'U') numberOfValleys++;
        }

        return numberOfValleys;
    }

    public static int jumpingOnClouds(List<Integer> c) {
        int numberOfJumps = 0, aux = 0;

        for(int i = 0; i < c.size(); ){
            if((i + 2) > c.size() - 1){
                aux = i;
                break;
            }
            if(c.get(i + 2) == 0){
                i = i + 2;
                numberOfJumps++;
            }
            else{
                i = i + 1;
                numberOfJumps++;
            }
        }

        if(aux < c.size() - 1) numberOfJumps++;

        return numberOfJumps;
    }

    public static long repeatedString(String s, long n) {
        String repeatingS1, repeatingS2;
        double occurrences = 1, finalOccurrences = 0;

        if(s.length() > n){
            repeatingS1 = s.substring(0, (int) n);
            repeatingS2 = "";
        }
        else{
            occurrences = Math.floor( n/s.length());
            int lastString = (int) (n%s.length());

            repeatingS1 = s;
            repeatingS2 = s.substring(0, lastString);
        }

        String s1AfterReplace = repeatingS1.replaceAll("a", "");
        String s2AfterReplace = repeatingS2.replaceAll("a", "");

        finalOccurrences = ((repeatingS1.length() - s1AfterReplace.length()) * occurrences) + (repeatingS2.length() - s2AfterReplace.length());

        return (long) finalOccurrences;
    }
}