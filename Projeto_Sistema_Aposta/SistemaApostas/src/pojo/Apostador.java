package pojo;

public class Apostador {
	private int id_apostador;
	private String nome_apostador;
	private double ganho;
	private int pontos;
	
	
	public Apostador(int id_apostador, String nome_apostador,double ganho, int pontos) {
		super();
		this.id_apostador = id_apostador;
		this.nome_apostador = nome_apostador;
		this.ganho = ganho;
		this.pontos = pontos;
	}
	public int getId_apostador() {
		return id_apostador;
	}
	public void setId_apostador(int id_apostador) {
		this.id_apostador = id_apostador;
	}
	public String getNome_apostador() {
		return nome_apostador;
	}
	public void setNome_apostador(String nome_apostador) {
		this.nome_apostador = nome_apostador;
	}
	public double getGanho() {
		return ganho;
	}
	public void setGanho(float ganho) {
		this.ganho = ganho;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public String toString() {
		return "[Apostador: " + id_apostador + ", Nome: " + nome_apostador + ", Ganho: " + ganho
				+ ", Pontos: " + pontos + "]";
	}

	
	
	
	
}
