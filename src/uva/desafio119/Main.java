//package uva.desafio119;
//
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Main{
//
//
//	public static void main (String args[]){
//		HashMap<String, Integer> saldo = new HashMap<>();
//		String[] ordemPessoas = {};
//    	boolean isFirst = true;
//
//    	Scanner scan = new Scanner (System.in);
//		while (scan.hasNext()){
//			String linha = scan.nextLine();
//			String valores[] = linha.split(" ");
//
//			if(valores.length == 1 || valores.length == 0){
//    			for(int i = 0; i < ordemPessoas.length; i++){
//    			    System.out.println(ordemPessoas[i] + " " + saldo.get(ordemPessoas[i]));
//    			}
//			    if(!isFirst) System.out.println();
//				saldo.clear();
//				continue;
//			}
//			else if(valores[1].matches("[0-9]+")){
//				String nomePessoaQueDeu = valores[0];
//				int valor = Integer.parseInt(valores[1]);
//				if(valor == 0) continue;
//				int qtdPessoas = Integer.parseInt(valores[2]);
//				if(qtdPessoas == 0) {
//				    // saldo.put(nomePessoaQueDeu, (saldo.get(nomePessoaQueDeu) - valor));
//				    continue;
//				}
//
//				saldo.put(nomePessoaQueDeu, (saldo.get(nomePessoaQueDeu) - valor));
//
//				int valorASerDado = Math.floorDiv(valor, qtdPessoas);
//				if(valor % qtdPessoas != 0){
//				    saldo.put(nomePessoaQueDeu, saldo.get(nomePessoaQueDeu) + (valor - (qtdPessoas*valorASerDado)));
//				}
//
//				for (int i = 3; i < valores.length; i++) {
//					saldo.put(valores[i], saldo.get(valores[i]) + valorASerDado);
//				}
//			}
//			else{
//				ordemPessoas = valores;
//				for(int i = 0; i < valores.length; i++){
//					saldo.put(valores[i], 0);
//				}
//			}
//			isFirst = false;
//		}
//		for(int i = 0; i < ordemPessoas.length; i++){
//    	    System.out.println(ordemPessoas[i] + " " + saldo.get(ordemPessoas[i]));
//    	}
//
//	}
//}
