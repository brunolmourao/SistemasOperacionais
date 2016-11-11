
import java.util.Comparator;

public class SortBurstTime implements Comparator<Processos> {

	@Override
	public int compare(Processos arg0, Processos arg1) {
		if(arg0.burstTime<arg1.burstTime){
			return 1;
		}
		if(arg0.prioridade>arg1.prioridade){
			return -1;
		}
		return 0;
	}

}
