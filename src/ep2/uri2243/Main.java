package ep2.uri2243;

import java.util.Scanner;

/*
    Integrantes do grupo:

    Hugo Bechtolt Curi - 10284198
    Guilherme Estevam Ferreira Putzeys - 10424972
    Vitor Santos Quintino - 10258880
*/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int columns = sc.nextInt();
        int result = 0;

        int[] columnsOrganization = new int[columns + 2];

        for(int i = 1; i <= columns; i++){
            columnsOrganization[i] = sc.nextInt();

            if(columnsOrganization[i] > columnsOrganization[i - 1]) columnsOrganization[i] = columnsOrganization[i - 1] + 1;
        }

        for(int i = columns; i >= 1; i--) if(columnsOrganization[i] > columnsOrganization[i + 1]) columnsOrganization[i] = columnsOrganization[i + 1] + 1;

        for(int i = 0; i <= columns; i++) if(columnsOrganization[i] > result) result = columnsOrganization[i];

        System.out.println(result);
    }
}
