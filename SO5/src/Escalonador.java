import java.util.ArrayList;
import java.util.Map;


public class Escalonador {

	public static void main(String[] args) {
		TratadorDeEntradas te = new TratadorDeEntradas();
		ArrayList<Processos> array ;
		Metodos me = new Metodos();
		String arquivo = args[0];
		te.lerCsv(arquivo);
		if(args[1].equals("FCFS")){
			array = me.FCFS(te.fila);
			me.gerarRelatorio2(array);
			me.gerarRelatorio1(array);
		}
		if(args[1].equals("SJF")){
			array = me.SJF(te.fila);
			me.gerarRelatorio2(array);
			me.gerarRelatorio1(array);
		}
		if(args[1].equals("SJFP")){
			array = me.SJFP(te.fila);
			me.gerarRelatorio1(array);
			me.gerarRelatorio2(array);
		}
		else{
			System.out.println("Nome inválido de método");
		}
		
		

	}
	
}
	
