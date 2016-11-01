import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class ProcessarDados {
	private ArrayList<Processo> fila = new ArrayList<Processo>();
	public ArrayList<Processo> getFila(){
		return fila;
	}
	public void lerCsv(String nome_arq){
		int count = 0;
		String[] comandos;
		String arquivoCSV = nome_arq;
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ",";
		try {
			br = new BufferedReader(new FileReader(arquivoCSV));
	        	while ((linha = br.readLine()) != null) {
	        	comandos = (linha.split(csvDivisor));
	        	fila.add(new Processo(count,(comandos[0]),Integer.parseInt(comandos[1]),
	        			Integer.parseInt(comandos[2]),Integer.parseInt(comandos[3]),Integer.parseInt(comandos[4]),
	        			Integer.parseInt(comandos[5]),Integer.parseInt(comandos[6])));
	        	count++;
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