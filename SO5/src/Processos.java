
public class Processos {
	public int id_do_porcesso;
	public int tempo_de_entrada;
	public int burstTime;
	public int prioridade;
	public int tempoDeExecução;
	public int tempoDeEspera;
	public Processos(int id,int tempo_de_entrada,int burstTime,int prioridade){
		this.id_do_porcesso = id;
		this.tempo_de_entrada = tempo_de_entrada;
		this.burstTime = burstTime;
		this.prioridade = prioridade;
	}
}
