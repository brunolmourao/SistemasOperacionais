import java.util.ArrayList;
import java.util.Map;


public class Escalonador {

	public static void main(String[] args) {
		TratadorDeEntradas te = new TratadorDeEntradas();
		ArrayList<Processos> array ;
		Metodos me = new Metodos();
		String arquivo = args[0];
		te.lerCsv(arquivo);
		array = me.FCFS(te.fila);
		me.gerarRelatorio2(array);
		me.gerarRelatorio1(array);
		

	}
	
}
	
