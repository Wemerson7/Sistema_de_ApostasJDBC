package pojo;

public class Jogo {
	private String time1;
	private String time2;
	private String placar;
	private int id_jogo;

	public Jogo(String time1, String time2, String placar, int id_jogo) {
		super();
		this.time1 = time1;
		this.time2 = time2;
		this.placar = placar;
		this.id_jogo = id_jogo;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public String getPlacar() {
		return placar;
	}
	public void setPlacar(String placar) {
		this.placar = placar;
	}
	public int getId_jogo() {
		return id_jogo;
	}
	public void setId_jogo(int id_jogo) {
		this.id_jogo = id_jogo;
	}
	@Override
	public String toString() {
		return "[Jogo: "+ id_jogo +" [Casa: " + time1 + ", Fora:" + time2 + 
				", placar:" + placar +"]";
	}
	
	
}
