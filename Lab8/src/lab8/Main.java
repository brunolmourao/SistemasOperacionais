package lab8;

public class Main {

	private static int TamanhoDoFrame = 3;
	public static void main(String[] args) {
		TratadorDeEntrada tc = new TratadorDeEntrada();
		Algoritimos alg = new Algoritimos();
		int[] Entradas;
		String Entrada = "1,2,3,4,1,2,5,1,2,3,4,5";
		Entradas = tc.processar(Entrada);
		alg.FIFO(Entradas, TamanhoDoFrame);

	}

}
