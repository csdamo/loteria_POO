package entidades;

public class ProcessadorDeApostas {

	private Aposta[] arrayApostas;
	private int [] gabarito;
	private int apostaComputada;
	
// construtor
	public ProcessadorDeApostas(int tamanhoArray) {
		this.arrayApostas = new Aposta [tamanhoArray];
		this.gabarito = new int [14];
	}
	
// metodos
	public void incluiAposta(Aposta novaAposta) {
		this.arrayApostas[apostaComputada] = novaAposta;
		this.apostaComputada++;
	}
	
	public void incluiGabarito(int [] gabarito) {
		this.gabarito = gabarito;
	}
	
	public String[] nomeAcertadores(int tamanhoArray) {
		
		String[] nomeAcertadoresTemp = new String[tamanhoArray];
		int numeroAcertos;
		int posicaoArray = 0;
		int tamanho = this.gabarito.length;
		
		for(int i = 0; i < tamanhoArray ; i++) {
			numeroAcertos = 0;
			for(int j = 0; j < tamanho; j++ ) {
				
				if(gabarito[i] == arrayApostas[i].getApostaDoJogador()[j]) {
					numeroAcertos += 1;
				}
				else{
					break;
				}
				if(numeroAcertos == tamanho) {
					nomeAcertadoresTemp[posicaoArray] = arrayApostas[i].getNome();
					posicaoArray += 1;
				}
			}
		}
		
		// Montado novo array com o tamanho exato do número de acertadores
		String[] nomeAcertadores = new String[posicaoArray];
		for(int i = 0; i < posicaoArray; i++) {
			nomeAcertadores[i] = nomeAcertadoresTemp[i];
		}
				
		return nomeAcertadores;
	}
	
//Setters and getters
	public int[] getGabarito() {
		return gabarito;
	}

	public void setGabarito(int[] gabarito) {
		this.gabarito = gabarito;
	}

	public Aposta[] getArrayApostas() {
		return arrayApostas;
	}

	public void setArrayApostas(Aposta[] arrayApostas) {
		this.arrayApostas = arrayApostas;
	}
	
	

}
