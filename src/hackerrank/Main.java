package hackerrank;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int sockMerchant = sockMerchant(1, Collections.singletonList(10));
        int countingValleys = countingValleys(8, "DDUUDDUDUUUD");
        int jumpingOnClouds = jumpingOnClouds(Arrays.asList(0, 0, 0, 1, 0, 0));
        long repeatedString = repeatedString("a", 1000000000000L);

        List<Integer> l1 = Arrays.asList(-9, -9, -9,  1, 1, 1);
        List<Integer> l2 = Arrays.asList( 0, -9,  0,  4, 3, 2);
        List<Integer> l3 = Arrays.asList(-9, -9, -9,  1, 2, 3);
        List<Integer> l4 = Arrays.asList( 0,  0,  8,  6, 6, 0);
        List<Integer> l5 = Arrays.asList( 0,  0,  0, -2, 0, 0);
        List<Integer> l6 = Arrays.asList( 0,  0,  1,  2, 4, 0);

        List<List<Integer>> lFinal = new ArrayList<List<Integer>>();

        lFinal.add(l1);
        lFinal.add(l2);
        lFinal.add(l3);
        lFinal.add(l4);
        lFinal.add(l5);
        lFinal.add(l6);

        int i = hourglassSum(lFinal);

        List<Integer> integers = rotLeft(Arrays.asList(1, 2, 3, 4, 5), 4);

        minimumBribes(Arrays.asList(2, 1, 5, 3, 4));
        int minimumSwaps = minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7});

        List<Integer> l21 = Arrays.asList(1, 5, 3);
        List<Integer> l22 = Arrays.asList(4, 8, 7);
        List<Integer> l23 = Arrays.asList(6, 9, 1);

        List<List<Integer>> l2Final = new ArrayList<List<Integer>>();

        l2Final.add(l21);
        l2Final.add(l22);
        l2Final.add(l23);

        long l = arrayManipulation(10, l2Final);
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

    public static int hourglassSum(List<List<Integer>> arr) {
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.size() - 2; i++){
            int currentSum = arr.get(i).get(0) + arr.get(i).get(1) + arr.get(i).get(2)
                    + arr.get(i + 1).get(1)
                    + arr.get(i + 2).get(0) + arr.get(i + 2).get(1) + arr.get(i + 2).get(2);

            if(currentSum > maxSum) maxSum = currentSum;
        }

        for(int i = 0; i < arr.size() - 2; i++){
            int currentSum = arr.get(0).get(i) + arr.get(0).get(i + 1) + arr.get(0).get(i + 2)
                    + arr.get(1).get(i + 1)
                    + arr.get(2).get(i) + arr.get(2).get(i + 1) + arr.get(2).get(i + 2);

            if(currentSum > maxSum) maxSum = currentSum;
        }

        for(int i = 0; i < arr.size() - 2; i++){
            int currentSum = arr.get(i).get(i) + arr.get(i).get(i + 1) + arr.get(i).get(i + 2)
                    + arr.get(i + 1).get(i + 1)
                    + arr.get(i + 2).get(i) + arr.get(i + 2).get(i + 1) + arr.get(i + 2).get(i + 2);

            if(currentSum > maxSum) maxSum = currentSum;
        }

        for(int i = 0; i < arr.size() - 2; i++){
            int currentSum = arr.get(3).get(i) + arr.get(3).get(i + 1) + arr.get(3).get(i + 2)
                    + arr.get(4).get(i + 1)
                    + arr.get(5).get(i) + arr.get(5).get(i + 1) + arr.get(5).get(i + 2);

            if(currentSum > maxSum) maxSum = currentSum;
        }

        return maxSum;
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        int[] newRotatedList = new int[a.size()];

        for(int i = 0; i < a.size(); i++){
            int newIndex = i - d;
            if(newIndex < 0) newIndex = newIndex + a.size();

            newRotatedList[newIndex] = a.get(i);
        }

        List<Integer> finalList = new ArrayList<>();

        for (int currentInteger: newRotatedList) {
            finalList.add(currentInteger);
        }

        return finalList;
    }

    public static void minimumBribes(List<Integer> q) {
        int numberOfBribes = 0;

        for (int i = q.size() - 1; i >= 2; i--) {
            if(!(q.get(i) == i + 1)){
                if(q.get(i - 2) == i + 1){
                    numberOfBribes+=2;
                    Collections.swap(q, i-2, i-1);
                    Collections.swap(q, i-1, i);
                }
                else if(q.get(i - 1) == i + 1){
                    numberOfBribes++;
                    Collections.swap(q, i-1, i);
                }
                else{
                    System.out.println("Too chaotic");
                    return;
                }
            }

        }

        if(q.get(0) != 1) numberOfBribes++;

        System.out.println(numberOfBribes);

    }

    public static int minimumSwaps(int[] arr) {
        int swaps = 0;

        for(int i = 0; i < arr.length; i++){
            while(arr[i] != (i+1)){
                swaps++;

                int auxInt = arr[i];
                arr[i] = arr[auxInt - 1];
                arr[auxInt - 1] = auxInt;
            }
        }

        return swaps;
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        int[] myNumbers = new int[n + 1];

        queries.forEach(ops -> {
            int minIndex = ops.get(0) - 1;
            int maxIndex = ops.get(1);
            int sumValue = ops.get(2);

            myNumbers[minIndex] += sumValue;
            myNumbers[maxIndex] -= sumValue;
        });

        int maxValue = 0, sum = 0;
        for(int i = 0; i < myNumbers.length; i++){
            sum += myNumbers[i];
            maxValue = Math.max(maxValue, sum);
        }

        return maxValue;
    }
}