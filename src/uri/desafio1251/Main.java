//package uri.desafio1251;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Scanner;
//
///*
//Integrantes do grupo:
//
//Hugo Bechtol Curi - 10284198
//Guilherme Estevam Ferreira Putzeys - 10424972
//Vitor Santos Quintino - 10258880
// */
//
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sn = new Scanner(System.in);
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        while(sn.hasNext()){
//            String linha = sn.nextLine();
//
//            for (int i = 0; i < linha.length(); i++){
//                char atual = linha.charAt(i);
//
//                if(map.containsKey((int) atual)){
//                    map.put((int) atual, map.get((int) atual) + 1);
//                }
//                else{
//                    map.put((int) atual, 1);
//                }
//            }
//
//            int linhas = map.size();
//
//            for(int i = 0; i < linhas; i++){
//                System.out.println(achaMenor(map));
//            }
//
//            if(sn.hasNext())
//                System.out.println();
//
//            map.clear();
//        }
//    }
//
//    public static String achaMenor(HashMap<Integer, Integer> map){
//        int value = 9999, key = 9999;
//        Iterator it = map.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//
//            if((int) pair.getValue() < value){
//                value = (int) pair.getValue();
//                key = (int) pair.getKey();
//            }
//            else if((int) pair.getValue() == value){
//                if((int) pair.getKey() > key){
//                    value = (int) pair.getValue();
//                    key = (int) pair.getKey();
//                }
//            }
//        }
//
//        map.remove(key);
//
//        return key + " " + value;
//    }
//}
//
//
///*
//
//AAABBC
//122333
//
//
//
//
//
// */