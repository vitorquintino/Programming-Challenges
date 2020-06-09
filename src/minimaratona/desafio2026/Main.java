package minimaratona.desafio2026;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Boolean> list = new HashMap<Integer, Boolean>();
        Scanner sc = new Scanner(System.in);
        int caseTests = sc.nextInt();
        int count = 0;

        for (int i = 0; i < caseTests; i++) {
            int x = sc.nextInt();
            if (list.get(x) == null) {
                list.put(x, true);
                count++;
            }
        }
        System.out.println(count);
    }

}