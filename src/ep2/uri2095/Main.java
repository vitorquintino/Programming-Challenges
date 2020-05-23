package ep2.uri2095;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int warriors = sc.nextInt();

        ArrayList<Integer> warriorsFirst = new ArrayList<>();
        ArrayList<Integer> warriorsSecond = new ArrayList<>();

        for(int i = 0; i < warriors; i++){
            warriorsFirst.add(sc.nextInt());
        }

        for(int i = 0; i < warriors; i++){
            warriorsSecond.add(sc.nextInt());
        }

        warriorsSecond.sort(Collections.reverseOrder());

        int battlesWon = 0;

        for(int i = 0; i < warriors; i++){
            int functionReturn = findNextOpponent(warriorsSecond, warriorsFirst.get(i));

            if(functionReturn > 0) battlesWon++;
        }

        System.out.println(battlesWon);

    }

    private static int findNextOpponent(ArrayList<Integer> warriorsSecond, int power) {
        int indexNextWarrior = 0, bigger = warriorsSecond.get(0);

        if(bigger <= power) return -1;

        for(int i = 1; i < warriorsSecond.size(); i++){
            if(warriorsSecond.get(i) > power){
                if(warriorsSecond.get(i) < bigger){
                    bigger = warriorsSecond.get(i);
                    indexNextWarrior = i;
                }
            } else{
                break;
            }
        }

        warriorsSecond.remove(indexNextWarrior);

        return 1;
    }
}
