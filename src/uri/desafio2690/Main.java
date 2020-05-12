package uri.desafio2690;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/*
    Integrantes do grupo:

    Hugo Bechtolt Curi - 10284198
    Guilherme Estevam Ferreira Putzeys - 10424972
    Vitor Santos Quintino - 10258880
*/


public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> code = new HashMap<>();

        code.put("GQaku", 0);
        code.put("ISblv", 1);
        code.put("EOYcmw", 2);
        code.put("FPZdnx", 3);
        code.put("JTeoy", 4);
        code.put("DNXfpz", 5);
        code.put("AKUgq", 6);
        code.put("CMWhr", 7);
        code.put("BLVis", 8);
        code.put("HRjt", 9);

        Scanner sc = new Scanner(System.in);

        int caseTests = sc.nextInt();
        sc.nextLine();

        int printNumbers = 0;
        for(int i = 0; i < caseTests; i++){
            String phrase = sc.nextLine();

            printNumbers = 0;
            for(int j = 0; j < phrase.length(); j++){

                String currentChar = String.valueOf(phrase.charAt(j));

                if(currentChar.equals(" ")) continue;

                System.out.print(findEncryptedChar(currentChar, code));

                printNumbers++;

                if(printNumbers == 12) break;
            }

            System.out.println();

        }

    }

    public static int findEncryptedChar(String key, HashMap<String, Integer> code){
        Iterator it = code.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry pair = (Map.Entry) it.next();

            String lettersCode = (String) pair.getKey();

            if(lettersCode.contains(key)){
                return (int) pair.getValue();
            }
        }

        return -1;
    }
}

/*
3
o rato roeu a roupa de margarida
O Rato Roeu A Roupa de Margarida
OlA TuDo CeRtO

6
abcdefgh ijkl
mnopqrst uvwx
yz
ABCD EFGH IJKL
MNOP QRST UVWX
YZ

 */
