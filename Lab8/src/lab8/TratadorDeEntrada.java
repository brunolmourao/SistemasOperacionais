package lab8;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class TratadorDeEntrada {
	public ArrayList<Integer> processar(String entrada){
		ArrayList<Integer> Saida = new ArrayList<Integer>();
		 StringTokenizer st = new StringTokenizer(entrada, ",");
		 String aux;
	        while (st.hasMoreTokens()) { 
	        	aux = st.nextToken().toString();
	        	Saida.add(Integer.parseInt(aux));
	            }
	        return Saida;
	        }
	}

