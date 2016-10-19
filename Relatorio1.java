import java.util.ArrayList;


public class Relatorio1 {
	public String cabecalho;
	public int Tempo_total;
	public double Percentual_de_uso_da_CPU;
	public double m_Thoroughput;
	public double m_TurnAround;
	public double m_TempoDeEspera;
	public double m_TrocaDeContexto;
	public double n_processos;
	public ArrayList<Double> n_processos_ready;
	public void gerar_relatorio(){
		System.out.println(cabecalho);
		System.out.println("Tempo Total "+Tempo_total);
		System.out.println("Tempo de Thoroughput "+ m_Thoroughput);
		System.out.println("Media de TurnAround "+m_TurnAround);
		System.out.println("Media de Espera "+m_TempoDeEspera);
		System.out.println("Media de Troca de Contexto"+m_TrocaDeContexto);
		System.out.println("Número de processos "+n_processos);
		
	}
}
