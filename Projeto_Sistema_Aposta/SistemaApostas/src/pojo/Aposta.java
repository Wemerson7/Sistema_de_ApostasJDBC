package pojo;

public class Aposta {
	private int id_aposta;
	private String gols;
	private String resultado;
	private int total_pontos =0;
	private int id_jogo;
	private int id_apostador;

	public Aposta(int id_aposta, String gols, 
			String resultado,int id_jogo,int id_apostador) {
		super();
		this.id_aposta = id_aposta;
		this.gols = gols;
		this.resultado = resultado;
		this.id_jogo = id_jogo;
		this.setId_apostador(id_apostador);
	}
	public int getId_aposta() {
		return id_aposta;
	}
	public void setId_aposta(int id_aposta) {
		this.id_aposta = id_aposta;
	}
	public String getGols() {
		return gols;
	}
	public void setGols(String gols) {
		this.gols = gols;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public int getTotalPontos() {
		return total_pontos;
	}
	public void setPtsResultado(int ptsResultado) {
		this.total_pontos = ptsResultado;
	}
	public int getId_jogo() {
		return id_jogo;
	}
	public void setId_jogo(int id_jogo) {
		this.id_jogo = id_jogo;
	}
	@Override
	public String toString() {
		return "[Aposta: " + id_aposta + ", placar : " + gols + ","
				+ " resultado: " + resultado + ", Pontos: " + total_pontos
				+ ", id_jogo: " + id_jogo + "]";
	}
	public int getId_apostador() {
		return id_apostador;
	}
	public void setId_apostador(int id_apostador) {
		this.id_apostador = id_apostador;
	}




}
