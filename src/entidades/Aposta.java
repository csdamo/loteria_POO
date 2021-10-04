package entidades;

public class Aposta {
	
	private String nome;
	private int [] apostaDoJogador = new int [14];
	
// construtor
	public Aposta (String nome, int[] apostaDoJogador ) {
		this.nome = nome;
		this.apostaDoJogador = apostaDoJogador;
	}

// Getters and setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int[] getApostaDoJogador() {
		return apostaDoJogador;
	}

	public void setApostaDoJogador(int[] sequenciaJogos) {
		this.apostaDoJogador = sequenciaJogos;
	}

}
