import java.util.ArrayList;
import java.util.Collections;
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
		r1.Tempo_total = tempoDeExecucao;
		return executados;
	}
	public ArrayList<Processos> SJF(ArrayList<Processos> processos){
		r1.cabecalho = "SJF";
		r1.n_processos = processos.size();
		Fila filaDeEspera = new Fila();
		int tempoDeExecucao=0,count=0,burstTimesAnteriores = 0;
		ArrayList<Processos> executados = new ArrayList<Processos>(); 
		Processos processo_executando = null;
		boolean isExecuting = false;
		for(int i=0;i<processos.size();i++){
			filaDeEspera.add(processos.get(i));
		}
		System.out.println(filaDeEspera.size());
		while(count<=processos.size()-1){
				if(!isExecuting){
					processo_executando = filaDeEspera.get();
					processo_executando.tempoDeEspera = tempoDeExecucao-processo_executando.tempo_de_entrada;
					tempoDeExecucao = processar(processo_executando.burstTime,tempoDeExecucao);
					isExecuting = true;
				}
				if(isExecuting){
					System.out.println(tempoDeExecucao);
					processo_executando.tempoDeExecução = tempoDeExecucao-processo_executando.tempo_de_entrada;
					executados.add(processo_executando);
					burstTimesAnteriores += processo_executando.burstTime;
					count++;
					if(count < processos.size()){
					processo_executando = filaDeEspera.get();
					tempoDeExecucao = processar(processo_executando.burstTime,tempoDeExecucao);
					processo_executando.tempoDeEspera = tempoDeExecucao-processo_executando.tempo_de_entrada;
					}
					
			}
				
		}		
		r1.Tempo_total = tempoDeExecucao;
		return executados;
	}
	public ArrayList<Processos> SJFP(ArrayList<Processos> processos){
		r1.cabecalho = "SJFP";
		SortBurstTime sb = new SortBurstTime();
		int currentTime = 0;
		Processos previousProcess;
		ArrayList<Processos> processesArrived = new ArrayList<Processos>();
		ArrayList<Processos> processesConcluded = new ArrayList<Processos>();
		// primeiro processo da lista de processos
		currentTime = processos.get(0).tempo_de_entrada;
		processesArrived.add(processos.remove(0));
		//this.processesArrived.get(0).setWaitingTime(0);
		previousProcess = processesArrived.get(0);
		
		while(true){
			
			// percorrer a lista de processos para efetuar verificacoes
			try{
				
				for(Processos p : processos){
					
					// verificar tempo de chegada
					if(p.tempo_de_entrada <= currentTime){
						processesArrived.add(p);
						processos.remove(p);
						
						// verificar se o processo que chegou tem o burst time menor
						if(p.burstTime<processesArrived.get(0).burstTime){
							processesArrived.get(0).setInterrupted(true);
							processesArrived.get(0).setLastTimeExecuting(currentTime);
							//sortListByBurstTime(this.processesArrived);
						}
					}
				}
			}
			catch(Exception e){}
			
			// Ordenar pelo tempo burst time
			Collections.sort(processesArrived,sb);
			
			//System.out.println(processesArrived.get(0).getpID() + " " + currentTime);
			
			// incrementar o tempo de execução
			processesArrived.get(0).tempoDeExecução +=1;
			
			// calculo do waitingTime
			try{
				if(!(previousProcess.equals(processesArrived.get(0)))){
					//System.out.println("teste");
					if(processesArrived.get(0).isInterrupted()){
						processesArrived.get(0).tempoDeEspera = currentTime - processesArrived.get(0).tempoDeExecução;
						processesArrived.get(0).setInterrupted(false);
					}
					else{
						processesArrived.get(0).tempoDeEspera = currentTime - processesArrived.get(0).tempo_de_entrada;
					}
				}
			}catch(IndexOutOfBoundsException e){}
			
			previousProcess = processesArrived.get(0);
			
			// verifica se o processo ja executou por completo
			if(processesArrived.get(0).tempoDeExecução == processesArrived.get(0).burstTime){
				
				processesConcluded.add(processesArrived.remove(0));
			}
			
			// verifica se a lista de processos que chegaram está vazia
			if(processesArrived.isEmpty()){
				break;
			}
			
			currentTime++;
		}
		r1.Tempo_total = currentTime;
		r1.n_processos = processesConcluded.size();
		return processesConcluded;
	
	}
	public ArrayList<Processos> PriorityP(ArrayList<Processos> processos){
		r1.cabecalho = "PriorityP";
		r1.n_processos = processos.size();
		int tempoDeExecucao = 0;
		Processos aux;
		ArrayList<Processos> executados = new ArrayList<Processos>(); 
		Iterator<Processos> it = processos.iterator();
			while(it.hasNext()){
				aux = it.next();
				aux.tempoDeEspera = tempoDeExecucao;
				tempoDeExecucao = processar(aux.burstTime,tempoDeExecucao);
				aux.tempoDeExecução = tempoDeExecucao - aux.tempo_de_entrada;
				executados.add(aux);			
			}
		r1.Tempo_total = tempoDeExecucao;	
		return executados;
	}
	public ArrayList<Processos> PriorityNP(ArrayList<Processos> processos){
		SortBurstTime sb = new SortBurstTime();
		int currentTime = 0;
		Processos previousProcess;
		ArrayList<Processos> processesArrived = new ArrayList<Processos>();
		ArrayList<Processos> processesConcluded = new ArrayList<Processos>();
		// primeiro processo da lista de processos
		currentTime = processos.get(0).tempo_de_entrada;
		processesArrived.add(processos.remove(0));
		//this.processesArrived.get(0).setWaitingTime(0);
		previousProcess = processesArrived.get(0);
		
		while(true){
			
			// percorrer a lista de processos para efetuar verificacoes
			try{
				
				for(Processos p : processos){
					
					// verificar tempo de chegada
					if(p.tempo_de_entrada <= currentTime){
						processesArrived.add(p);
						processos.remove(p);
						
						// verificar se o processo que chegou tem o burst time menor
						if(p.prioridade<processesArrived.get(0).prioridade){
							processesArrived.get(0).setInterrupted(true);
							processesArrived.get(0).setLastTimeExecuting(currentTime);
							//sortListByBurstTime(this.processesArrived);
						}
					}
				}
			}
			catch(Exception e){}
			
			// Ordenar pelo tempo burst time
			Collections.sort(processesArrived,sb);
			
			//System.out.println(processesArrived.get(0).getpID() + " " + currentTime);
			
			// incrementar o tempo de execução
			processesArrived.get(0).tempoDeExecução +=1;
			
			// calculo do waitingTime
			try{
				if(!(previousProcess.equals(processesArrived.get(0)))){
					//System.out.println("teste");
					if(processesArrived.get(0).isInterrupted()){
						processesArrived.get(0).tempoDeEspera = currentTime - processesArrived.get(0).tempoDeExecução;
						processesArrived.get(0).setInterrupted(false);
					}
					else{
						processesArrived.get(0).tempoDeEspera = currentTime - processesArrived.get(0).tempo_de_entrada;
					}
				}
			}catch(IndexOutOfBoundsException e){}
			
			previousProcess = processesArrived.get(0);
			
			// verifica se o processo ja executou por completo
			if(processesArrived.get(0).tempoDeExecução == processesArrived.get(0).burstTime){
				
				processesConcluded.add(processesArrived.remove(0));
			}
			
			// verifica se a lista de processos que chegaram está vazia
			if(processesArrived.isEmpty()){
				break;
			}
			
			currentTime++;
		}
		r1.Tempo_total = currentTime;
		r1.n_processos = processesConcluded.size();
		return processesConcluded;
	
	}
	public int processar(int bustTime,int tempoDeExecucao){
		return bustTime+tempoDeExecucao;
	}
	public double calc_media_Espera(ArrayList<Processos> array){
		Processos aux;
		double count=0;
		Iterator it  = array.iterator();
		while (it.hasNext()){
			aux = (Processos) it.next();
			count += aux.tempoDeEspera;
		}
		return count/array.size();
	}
	public double calc_media_TurnAround(ArrayList<Processos> array){
		Processos aux;
		double count=0;
		Iterator it  = array.iterator();
		while (it.hasNext()){
			aux = (Processos) it.next();
			count += aux.tempoDeExecução;
		}
		return count/array.size();
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
		r1.m_TurnAround = calc_media_TurnAround(array);
		r1.m_TempoDeEspera = calc_media_Espera(array);
		r1.m_Thoroughput = 1;
		r1.gerar_relatorio();
	}
}
