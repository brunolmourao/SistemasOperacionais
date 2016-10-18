
public class Processos {
	public int id_do_porcesso;
	public int tempo_de_entrada;
	public int burstTime;
	public int prioridade;
	public int tempoDeExecução;
	public int tempoDeEspera;
	public int inicioDeExecucao;
	public int trocaDeContexto;
	private boolean isInterrupted = false;
	private int lastTimeExecuting ;
	public Processos(int id,int tempo_de_entrada,int burstTime,int prioridade){
		this.id_do_porcesso = id;
		this.tempo_de_entrada = tempo_de_entrada;
		this.burstTime = burstTime;
		this.prioridade = prioridade;
		this.lastTimeExecuting = 0;
		this.tempoDeExecução = 0;
		this.trocaDeContexto = 0;
	}
	public void setInterrupted(boolean b){
		isInterrupted = b;
	}
	public void setLastTimeExecuting(int lastTimeExecuting) {
		this.lastTimeExecuting = lastTimeExecuting;
	}
	public boolean isInterrupted() {
		return isInterrupted;
	}

}
