import java.util.ArrayList;


public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> Disponiveis = recDispo();
		Algoritmos alg = new Algoritmos();
		int[][] Max = new int[3][3];
		ArrayList<Processo> array;
		ProcessarDados pc = new ProcessarDados();
		String arquivo = args[0];
		pc.lerCsv(arquivo);
		array = pc.getFila();
		int[] Availible = criarAvailible(Disponiveis,array);
		int[][] Need = criarNeed(array);
		int[][] Alocation = criarAlocation(array);
		int[] Request = {1,1,1};
		if(alg.Safety(Alocation, Availible, Need)){
			System.out.println("O Sistema está em estado seguro");
		}
		else{
			System.out.println("O Sistema não está em estado seguro");
		}
		if(alg.Avoid(array.get(2), Request, Alocation, Availible, Need)){
			System.out.println("Recursos Alocados com sucesso");
		}

	}
	public static int[] criarAvailible(ArrayList<Integer> recDispo,ArrayList<Processo> array){
		int[] Available = new int[3];
		for(int k=0;k<3;k++){
			Available[k] = recDispo.get(k);
		}
		for(int i=0;i<recDispo.size();i++){
				for(int j=0;j<=array.size();j++){
					if(j==0)
						Available[i] -=  array.get(j).getRecAt0();
					if(j==1)
						Available[i]-= array.get(j).getRecBt0();
					if(j==2)
						Available[i]-= array.get(j).getRecCt0();
				}
				
		}
		return Available;
	}
	public static ArrayList<Integer> recDispo(){
		ArrayList<Integer> Disponiveis = new ArrayList<Integer>();
		Disponiveis.add(3);
		Disponiveis.add(4);
		Disponiveis.add(4);
		return Disponiveis;
	}
	public static int[][] criarMax(ArrayList<Processo> array){
		int[][] Max = new int[3][3];
		for(int i=0;i<=array.size();i++){
			for(int j=0;j<=array.size();j++){
				if(j==0)
					Max[i][j] = array.get(i).getRecA();
				if(j==1)
					Max[i][j] = array.get(i).getRecB();
				if(j==2)
					Max[i][j] = array.get(i).getRecC();
			}
		}
		return Max;
	}
	public static int[][] criarNeed(ArrayList<Processo> array){
		int[][] Need = new int[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(j==0)
					Need[i][j] = array.get(i).getRecA() - array.get(i).getRecAt0();
				if(j==1)
					Need[i][j] = array.get(i).getRecB() - array.get(i).getRecBt0();
				if(j==2)
					Need[i][j] = array.get(i).getRecC() - array.get(i).getRecCt0(); 
			}
		}
		return Need;
	}
	public static int[][] criarAlocation(ArrayList<Processo> array){
		int[][] Alocation = new int[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(j==0)
					Alocation[i][j] = array.get(i).getRecAt0();
				if(j==1)
					Alocation[i][j] = array.get(i).getRecBt0();
				if(j==2)
					Alocation[i][j] = array.get(i).getRecCt0(); 
			}
		}
		return Alocation;
	}
 }
