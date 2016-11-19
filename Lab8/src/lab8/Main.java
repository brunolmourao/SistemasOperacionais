package lab8;

import java.util.Scanner;

public class Main {

	private static int TamanhoDoFrame = 3;
	public static void main(String[] args) {
		TratadorDeEntrada tc = new TratadorDeEntrada();
		Algoritimos alg = new Algoritimos();
		int[] Entradas;
		String Entrada = "1,2,3,4,1,2,5,1,2,3,4,5";
		Entradas = tc.processar(Entrada);
		String algoritmo;
		Scanner sc = new Scanner(System.in);
		System.out.println("Insira o nome do algoritmo a ser executado");
		algoritmo = sc.next();
		if(algoritmo.equals("FIFO")){
			alg.FIFO(Entradas, TamanhoDoFrame);
		}
		if(algoritmo.equals("LRU")){
			alg.LRU(Entradas, TamanhoDoFrame);
		}
		if(algoritmo.equals("MFU")){
			alg.MFU(Entradas, TamanhoDoFrame);
		}
		if(algoritmo.equals("LFU")){
			alg.LFU(Entradas, TamanhoDoFrame);
		}
		if(algoritmo.equals("Otimo")){
			alg.Otimo(Entradas, TamanhoDoFrame);
		}
		
		

	}

}
