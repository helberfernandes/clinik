package br.com.wofsolutions.model.cockpit;

import java.io.Serializable;

public class QtdMes implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private int janeiro;
	private int fevereiro;
	private int marco;
	private int abril;
	private int maio;
	private int junho;
	private int julho;
	private int agosto;
	private int setembro;
	private int outubro;
	private int novembro;
	private int dezembro;
	
	
	
	
	public QtdMes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QtdMes(String nome, int janeiro, int fevereiro, int marco,
			int abril, int maio, int junho, int julho,
			int agosto, int setembro, int outubro, int novembro,
			int dezembro) {
		super();
		this.nome = nome;
		this.janeiro = janeiro;
		this.fevereiro = fevereiro;
		this.marco = marco;
		this.abril = abril;
		this.maio = maio;
		this.junho = junho;
		this.julho = julho;
		this.agosto = agosto;
		this.setembro = setembro;
		this.outubro = outubro;
		this.novembro = novembro;
		this.dezembro = dezembro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getJaneiro() {
		return janeiro;
	}
	public void setJaneiro(int janeiro) {
		this.janeiro = janeiro;
	}
	public int getFevereiro() {
		return fevereiro;
	}
	public void setFevereiro(int fevereiro) {
		this.fevereiro = fevereiro;
	}
	public int getMarco() {
		return marco;
	}
	public void setMarco(int marco) {
		this.marco = marco;
	}
	public int getAbril() {
		return abril;
	}
	public void setAbril(int abril) {
		this.abril = abril;
	}
	public int getMaio() {
		return maio;
	}
	public void setMaio(int maio) {
		this.maio = maio;
	}
	public int getJunho() {
		return junho;
	}
	public void setJunho(int junho) {
		this.junho = junho;
	}
	public int getJulho() {
		return julho;
	}
	public void setJulho(int julho) {
		this.julho = julho;
	}
	public int getAgosto() {
		return agosto;
	}
	public void setAgosto(int agosto) {
		this.agosto = agosto;
	}
	public int getSetembro() {
		return setembro;
	}
	public void setSetembro(int setembro) {
		this.setembro = setembro;
	}
	public int getOutubro() {
		return outubro;
	}
	public void setOutubro(int outubro) {
		this.outubro = outubro;
	}
	public int getNovembro() {
		return novembro;
	}
	public void setNovembro(int novembro) {
		this.novembro = novembro;
	}
	public int getDezembro() {
		return dezembro;
	}
	public void setDezembro(int dezembro) {
		this.dezembro = dezembro;
	}
}
