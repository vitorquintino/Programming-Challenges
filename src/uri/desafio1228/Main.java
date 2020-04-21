//package uri.desafio1228;
//
//import java.util.Scanner;
//
//
//public class Main {
///*
//Integrantes do grupo:
//
//Hugo Bechtolt Curi - 10284198
//Guilherme Estevam Ferreira Putzeys - 10424972
//Vitor Santos Quintino - 10258880
//*/
//        public static void main(String[] args) {
//            Scanner sn = new Scanner(System.in);
//
//            int minimoDeUltrapassagens = 0;
//
//            while(sn.hasNext()){
//                int corredores = sn.nextInt();
//
//                int[] posicaoInicial = new int[corredores];
//                int[] posicaoFinal = new int[corredores];
//
//                for (int i = 0; i < corredores; i++){
//                    posicaoInicial[i] = sn.nextInt();
//                }
//
//                sn.nextLine();
//                String linha = sn.nextLine();
//
//                String[] linha2 = linha.split(" ");
//
//                for (int i = 0; i < corredores; i++){
//                    posicaoFinal[i] = Integer.parseInt(linha2[i]);
//                }
//
//                for(int i = corredores - 1; i > 0; i--){
//                    int selectedNumberFinalIndex = findIndex(posicaoInicial[i], posicaoFinal);
//                    for(int j = i - 1; j >= 0; j--){
//                        int numberFinalIndex = findIndex(posicaoInicial[j], posicaoFinal);
//
//                        if(numberFinalIndex > selectedNumberFinalIndex) minimoDeUltrapassagens++;
//                    }
//                }
//
//                System.out.println(minimoDeUltrapassagens);
//                minimoDeUltrapassagens = 0;
//            }
//        }
//
//        public static int findIndex(int number, int[] array){
//            for(int i = 0; i < array.length; i++){
//                if(array[i] == number) return i;
//            }
//
//            return -1;
//        }
//}
//
//
///*
//5
//1 2 3 4 5
//3 1 2 5 4
//5
//3 1 2 5 4
//1 2 3 4 5
//5
//3 1 2 5 4
//5 3 2 1 4
//
//
//
// */