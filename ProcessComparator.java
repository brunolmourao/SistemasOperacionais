import java.util.Comparator;

public class ProcessComparator implements Comparator<Processos> {

	@Override
	public int compare(Processos arg0, Processos arg1) {
		if(arg0.prioridade<arg1.prioridade){
			return -1;
		}
		if(arg0.prioridade>arg1.prioridade){
			return 1;
		}
		return 0;
	}

}
