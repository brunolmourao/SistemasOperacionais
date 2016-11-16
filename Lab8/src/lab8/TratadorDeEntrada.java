package lab8;

import java.util.StringTokenizer;

public class TratadorDeEntrada {
	public int[] processar(String entrada){
		int[] Saida = new int[12];
		int count = 0;
		 StringTokenizer st = new StringTokenizer(entrada, ",");
		 String aux;
	        while (st.hasMoreTokens()) { 
	        	aux = st.nextToken().toString();
	        	Saida[count] = Integer.parseInt(aux);
	        	count++;
	            }
	        return Saida;
	        }
	}

