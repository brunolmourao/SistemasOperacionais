package lab8;

import java.util.ArrayList;
import java.util.Iterator;

public class Algoritimos {
	public void FIFO (int[]Entradas,int TamanhoDaMemoria){
		String nome = "FIFO";
		int[] Memoria = new int[TamanhoDaMemoria];
		for(int i=0;i<TamanhoDaMemoria;i++){
			Memoria[i] = 0;
		}
		int aux,firstIn = 0,count = 0,pageFault = 0;
		for(int i=0;i<Entradas.length;i++){
			aux = Entradas[i];
				if(checkVector(Memoria,aux,TamanhoDaMemoria)){
					printVector(Memoria,nome);
				}
				else{
					Memoria[firstIn] = aux;
					pageFault++;
					if(firstIn == TamanhoDaMemoria-1){
						firstIn = 0;
					}else{	
						firstIn ++;
					}	
					printVector(Memoria,nome);
				}	
			}
			
		System.out.println("Total de PageFault "+pageFault);
	}
	public void LRU(int[]Entradas,int TamanhoDaMemoria){
		String nome = "LRU";
		int[] Memoria = new int[TamanhoDaMemoria];
		int[] Contador = new int [TamanhoDaMemoria];
		for(int i=0;i<TamanhoDaMemoria;i++){
			Memoria[i] = 0;
			Contador[i] = 0;
		}
		int aux,count = 0,pageFault = 0,min,clock = 0;
		for(int i=0;i<Entradas.length;i++){
			aux = Entradas[i];
			if(count<TamanhoDaMemoria){
				Memoria[count] = aux;
				Contador[count] = clock;
				printVector(Memoria,nome);
				count++;
				pageFault++;
			}
			if(count >= TamanhoDaMemoria){
				if(checkVector(Memoria,aux,TamanhoDaMemoria)){
					printVector(Memoria,nome);
				}
				else{
					min = minVector(Contador,TamanhoDaMemoria);
					Memoria[min] = aux;
					Contador[min] = clock;
					pageFault++;
					printVector(Memoria,nome);
				}	
			}
			clock++;
			
		}
		System.out.println("Total de PageFault "+pageFault);
	}
	public void LFU(int[] Entradas,int TamanhoDaMemoria){
		String nome = "LFU";
		int[] Memoria = new int[TamanhoDaMemoria];
		int[] Contador = new int [6];
		for(int i=0;i<TamanhoDaMemoria;i++){
			Memoria[i] = 0;
		}
		for(int i=0;i<6;i++){
			Contador[i] = 0;
		}
		int aux,count = 0,pageFault = 0,min;
		for(int i=0;i<Entradas.length;i++){
			aux = Entradas[i];
			if(count<TamanhoDaMemoria){
				Memoria[count] = aux;
				Contador[aux]++;
				printVector(Memoria,nome);
				count++;
				pageFault++;
			}
			if(count >= TamanhoDaMemoria){
				if(checkVector(Memoria,aux,TamanhoDaMemoria)){
					printVector(Memoria,nome);
					Contador[aux]++;
				}
				else{
					min = minVector(Contador,TamanhoDaMemoria);
					Memoria[min] = aux;
					Contador[aux]++;
					pageFault++;
					printVector(Memoria,nome);
				}	
			}
			
			
		}
		System.out.println("Total de PageFault "+pageFault);
	}
	public boolean checkVector(int[] Memoria,int x,int tamanho){
		for(int i=0;i<tamanho;i++){
			if(Memoria[i] == x){
				return true;
			}
		}
		return false;
	}
	public void printVector (int[] Vector,String Nome){
		System.out.println(Nome);
		for(int i=0;i<Vector.length;i++){
			if(Vector[i] != 0)
				System.out.println(i+" "+Vector[i]);
		}
	}
	public int minVector(int[]Contador,int tamanho){
		int min = Contador[0];
		int indicie = 0;
		for(int i=1;i<tamanho;i++){
			if(Contador[i]<min){
				min = Contador[i];
				indicie = i;
			}
		}
		return indicie;
	}
	public int maxVector(int[]Contador,int tamanho){
		int max = Contador[0];
		int indicie = 0;
		for(int i=1;i<tamanho;i++){
			if(Contador[i]>max){
				max = Contador[i];
				indicie = i;
			}
		}
		return max;
	}

}
