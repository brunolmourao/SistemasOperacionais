package lab8;

import java.util.ArrayList;
import java.util.Iterator;

public class Algoritimos {
	public void FIFO (ArrayList<Integer> Entradas,int TamanhoDaMemoria){
		int[] Memoria = new int[TamanhoDaMemoria];
		for(int i=0;i<TamanhoDaMemoria;i++){
			Memoria[i] = 0;
		}
		Iterator it = Entradas.iterator();
		int aux,firstIn = 0,count = 0;
		while(it.hasNext()){
			aux = (int) it.next();
			if(Memoria.length<TamanhoDaMemoria){
				Memoria[count] = aux;
				printVector(Memoria);
				count++;
			}
			if(Memoria.length >= TamanhoDaMemoria){
				Memoria[firstIn] = aux;
				if(firstIn == TamanhoDaMemoria-1){
					firstIn = 0;
				}else{	
					firstIn ++;
				}	
				printVector(Memoria);
			}
			
		}
	}
	public void printVector (int[] Vector){
		System.out.println("FiFO");
		for(int i=0;i<Vector.length;i++){
			if(Vector[i] != 0)
				System.out.println(i+" "+Vector[i]);
		}
	}

}
