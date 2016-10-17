import java.util.ArrayList;


public class Fila {
	private ArrayList<Processos> fila; 
	private int inicio;
	private int fim;
	
	public Fila(){
		fila = new ArrayList<Processos>();
		inicio = 0;
		fim = 0;
	}
	public Processos get(){
		Processos p = fila.get(inicio);
		//fila.remove(inicio); 
		inicio++;
		return p;
	}
	public void  add(Processos p){
		fila.add(p);
		fim++;
	}
	public Processos acess(){
		if(inicio == fim){
			return new Processos(0,0,9999999,0);
		}
		return fila.get(inicio);
	}
	public int size(){
		return fila.size();
	}
}
