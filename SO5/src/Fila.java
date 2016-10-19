import java.util.ArrayList;


public class Fila {
	private ArrayList<Processos> fila; 
	public Fila(){
		fila = new ArrayList<Processos>();
	}
	public Processos get(){
		return fila.remove(0);
	}
	public void  add(Processos p){
		fila.add(p);
	}
	public int size(){
		return fila.size();
	}
	public boolean isEmpty(){
		if(fila.size() == 0){
			return true;
		}
		return false;
	}	
}
