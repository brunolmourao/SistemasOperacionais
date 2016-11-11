import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class TratadorDeEntradas {
	ArrayList<Processos> fila = new ArrayList<Processos>();
	public void lerCsv(String nome_arq){
		String[] comandos;
		String arquivoCSV = nome_arq;
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ",";
		try {
			br = new BufferedReader(new FileReader(arquivoCSV));
	        	while ((linha = br.readLine()) != null) {
	        	comandos = (linha.split(csvDivisor));
	        	fila.add(new Processos(Integer.parseInt(comandos[0]),Integer.parseInt(comandos[1]),Integer.parseInt(comandos[2]),Integer.parseInt(comandos[3])));
	        	}
			}catch(Exception e){}
	finally {
        if (br != null) {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        	}		
		}
	}
}
