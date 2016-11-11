
public class Processo {
	private String nome;
	private int recAt0;
	private int recBt0;
	private int recCt0;
	private int recA;
	private int recB;
	private int recC;
	private int id;
	public Processo (int id,String nome,int recAt0,int recBt0,int recCt0,int recA,int recB,int recC){
		this.nome = nome;
		this.recAt0 = recAt0;
		this.recBt0 = recBt0;
		this.recCt0 = recCt0;
		this.recA = recA;
		this.recB = recB;
		this.recC = recC;
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getRecAt0() {
		return recAt0;
	}
	public void setRecAt0(int recAt0) {
		this.recAt0 = recAt0;
	}
	public int getRecBt0() {
		return recBt0;
	}
	public void setRecBt0(int recBt0) {
		this.recBt0 = recBt0;
	}
	public int getRecCt0() {
		return recCt0;
	}
	public void setRecCt0(int recCt0) {
		this.recCt0 = recCt0;
	}
	public int getRecA() {
		return recA;
	}
	public void setRecA(int recA) {
		this.recA = recA;
	}
	public int getRecB() {
		return recB;
	}
	public void setRecB(int recB) {
		this.recB = recB;
	}
	public int getRecC() {
		return recC;
	}
	public void setRecC(int recC) {
		this.recC = recC;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	
}
