//package uva.desafio11942;
//
//import java.util.Scanner;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author a10258880
// */
//public class Main {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        int cases = scan.nextInt();
//
//        System.out.println("Lumberjacks:");
//
//        while (cases-- > 0) {
//
//        	int[] tamanhosInteiros = new int[10];
//
//        	for (int i = 0; i < tamanhosInteiros.length; i++) {
//				tamanhosInteiros[i] = scan.nextInt();
//			}
//
//            boolean crescente = true;
//            boolean decrescente = true;
//
//            for (int i = 1; i < 10; i++) {
//                if(tamanhosInteiros[i-1] > tamanhosInteiros[i])
//                    crescente = false;
//                if(tamanhosInteiros[i-1] < tamanhosInteiros[i])
//                    decrescente = false;
//            }
//
//            if(crescente || decrescente)
//                System.out.println("Ordered");
//            else
//                System.out.println("Unordered");
//        }
//
//
//    }
//}
