import java.util.ArrayList;


public class Fila {
	ArrayList<Processos> fila; 
	int count;
	public Fila(){
		fila = new ArrayList<Processos>();
		count = 0;
	}
	public Processos get(){
		Processos p = fila.get(count);
		fila.remove(count); 
		count++;
		return p;
	}
	public void  add(Processos p){
		fila.add(p);
	}
	public int size(){
		return fila.size();
	}
}
