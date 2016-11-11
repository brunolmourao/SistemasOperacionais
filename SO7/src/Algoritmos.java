import java.util.ArrayList;


public class Algoritmos {
	public boolean Safety(int[][] Alocation,int[]Availible,int[][] Need){
		boolean[] Finish = new boolean[3];
		int[] Work = Availible;
		for(int i=0;i<3;i++){
			Finish[i] = false;
		}
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					if(!Finish[i]){
						if(Need[i][j]<=Work[i]){
							//for(int m=0;m<3;m++){
									Work[j] = Work[j] + Alocation[i][j]; 
							//}
						}
					Finish[i] = true;	
				}
			}
		}
		for(int i=0;i<3;i++){
			if(!Finish[i])
				return false;
		}
		return true;
	}
	public boolean Avoid (Processo p,int[] Request,int[][] Alocation,int[]Availible,int[][] Need){
		boolean safe = false;
		for(int i=0;i<Request.length;i++){
			if(Request[i]<Need[p.getId()][i]){
				//System.out.println(Availible[i]);
				if(Request[i]<Availible[i]){
					//System.out.println("oi2");
					Availible[i] -= Request[i];
					Alocation[i][p.getId()] += Request[i]; 
					Need[i][p.getId()] -= Request[i];
					safe = (Safety(Alocation,Availible,Need));
						
				}
				else{
					System.out.println("O Processos espera");
					return false;
				}
			}
			else{
				System.out.println("Erro Detectado");
				return false;
			}
		}
		return safe;
	}
	public boolean Detection(Processo p,int[][] Request ,int[][] Alocation,int[]Availible,int[][] Need){
		int[] Work = Availible;
		boolean[] Finish = new boolean[3];
		for(int i=0;i<3;i++){
			if(Availible[i] != 0){
				Finish[i] = false;
			}else{
				Finish[i] = true;
			}			
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(!Finish[i]&& Request[i][j]<Need[i][j]){
					for(int k=0;k<3;k++){
						Work[k] += Alocation[i][k];
					}
					Finish[i] = true;
				}
			}
		}
		for(int i=0;i<3;i++){
			if(Finish[i] == false){
				return false;
			}
		}
		return true;
	}
}


