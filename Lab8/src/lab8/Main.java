package lab8;

import java.util.ArrayList;
import java.util.Iterator;


public class Main {

	private static int TamanhoDoFrame = 3;
	public static void main(String[] args) {
		TratadorDeEntrada tc = new TratadorDeEntrada();
		Algoritimos alg = new Algoritimos();
		ArrayList<Integer> Entradas = new ArrayList<Integer>();
		String Entrada = "1,2,3,4,1,2,5,1,2,3,4,5";
		Entradas = tc.processar(Entrada);
		alg.FIFO(Entradas, TamanhoDoFrame);

	}

}
