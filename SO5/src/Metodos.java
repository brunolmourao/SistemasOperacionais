import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;



public class Metodos {
	public Relatorio1 r1 = new Relatorio1();
	public ArrayList<Processos> FCFS(ArrayList<Processos> processos){
		r1.cabecalho = "FCFS";
		r1.n_processos = processos.size();
		int tempoDeExecucao=0,count=0,tempoDeEntrada=0;
		ArrayList<Processos> executados = new ArrayList<Processos>();
		while(count<= processos.size()+1){
			for(int i=0;i<processos.size();i++){
				if(processos.get(i).tempo_de_entrada == tempoDeEntrada){
					processos.get(i).tempoDeEspera = tempoDeExecucao-processos.get(i).tempo_de_entrada;
					tempoDeExecucao = processar(processos.get(i).burstTime,tempoDeExecucao);
					processos.get(i).tempoDeExecução = tempoDeExecucao;
					executados.add(processos.get(i));
					processos.remove(i);
					count ++;
				}
			}
			tempoDeEntrada++;
		}
		//r1.m_TempoDeEspera = calc_media();
		r1.Tempo_total = tempoDeExecucao;
		return executados;
	}
	public ArrayList<Processos> SJF(ArrayList<Processos> processos){
		r1.cabecalho = "SJF";
		r1.n_processos = processos.size();
		Fila filaDeEspera = new Fila();
		int tempoDeExecucao=0,count=0;
		ArrayList<Processos> executados = new ArrayList<Processos>(); 
		Processos processo_executando = null;
		boolean isExecuting = false;
		for(int i=0;i<processos.size();i++){
			filaDeEspera.add(processos.get(i));
		}
		while(count<=processos.size()+1){
				if(!isExecuting){
					System.out.println("oi");
					processo_executando = filaDeEspera.get();
					processo_executando.tempoDeEspera = tempoDeExecucao-processo_executando.tempo_de_entrada;
					isExecuting = true;
				}
				if(tempoDeExecucao == (processo_executando.burstTime - processo_executando.tempoDeEspera)){
					System.out.println("oi2");
					processo_executando.tempoDeExecução = tempoDeExecucao-processo_executando.tempo_de_entrada;
					executados.add(processo_executando);
					count++;
					processo_executando = filaDeEspera.get();
					
			}
			tempoDeExecucao++;
				
		}		
		//r1.m_TempoDeEspera = calc_media(tempoDeEspera);
		r1.Tempo_total = tempoDeExecucao;
		return executados;
	}
	public int processar(int bustTime,int tempoDeExecucao){
		return bustTime+tempoDeExecucao;
	}
	public void gerarRelatorio2(ArrayList<Processos> array){
		System.out.println("Relatório 2");
		Processos aux;
		Iterator it  = array.iterator();
		while(it.hasNext()){
			aux = (Processos) it.next();
		    System.out.println("Processo: "+aux.id_do_porcesso);
		    System.out.println("Tempo: "+aux.tempoDeExecução);
		}
	}
	public void gerarRelatorio1(ArrayList<Processos> array){
		//r1.m_TurnAround = calc_media(map);
		r1.m_Thoroughput = 1;
		r1.gerar_relatorio();
	}
}
