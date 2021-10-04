package visualizacao;

import java.util.Scanner;
import entidades.Aposta;
import entidades.ProcessadorDeApostas;

public class InterfaceDeUsuario {
	
	public void menuLoteriaEsportiva() { 
		
		Scanner entrada = new Scanner(System.in);
		
		mostrarMenu ();
		int opcao = entrada.nextInt();
		int proximoLivre = 0;
		
		ProcessadorDeApostas processadorApostas = new ProcessadorDeApostas(1000);
		
		while(opcao !=0) {
					
			switch(opcao) {
			
				case 1:
				// Ler nome do apostador:
					System.out.println("\nNome do apostador: ");
					entrada.nextLine();
					String nomeApostador = entrada.nextLine();
					
				// Ler numeros da aposta:
					instruçõesAposta();
					int[] placarJogo = new int [14];
					int index = 0;
					while(index <placarJogo.length) {
						posicaoPlacar(index);
						placarJogo[index] = entrada.nextInt();
						if(placarJogo[index] >2) {
							System.out.println("numero inválido");
						}
						else {
							index++;
						}
					}
					
					
				// Instanciando objeto Aposta, já com valores atribuidos
					Aposta novaAposta = new Aposta(nomeApostador, placarJogo);
					System.out.println("Aposta concluida");
					
				// Atribuindo os valores aos arrays
					processadorApostas.incluiAposta(novaAposta);

					proximoLivre++;
					break;
					
				case 2:					
					int[] novoGabarito = new int [14];
					
					int index2 = 0;
					while (index2 < novoGabarito.length) {
						posicaoPlacar(index2);
						novoGabarito[index2] = entrada.nextInt();
						// Conferir de o numero está dentro do range
						if (novoGabarito[index2] > 2) {
							System.out.println("numero inválido");
						} else {
							index2++;
						}
					}
					processadorApostas.incluiGabarito(novoGabarito);

					break;

				case 3:
					
					int tamanhoArray = processadorApostas.nomeAcertadores(proximoLivre).length;

					System.out.println("Confira os vencedores: ");

					if (tamanhoArray > 0) {
						String[] nomeAcertadores = new String[tamanhoArray];
						nomeAcertadores = processadorApostas.nomeAcertadores(proximoLivre);

						for (int i = 0; i < tamanhoArray; i++) {
							System.out.println(nomeAcertadores[i]);
						}
					} else {
						System.out.println("Não houve vencedor");
					}

					break;
				}
			
			mostrarMenu();
			opcao = entrada.nextInt();
		}

		System.out.println("Programa encerrado");
	}

// metodos para interface
	private void mostrarMenu () {
		System.out.println("\nDigite o numero da opção:\n");
		System.out.println("1. Fazer uma nova aposta");
		System.out.println("2. Informar o resultado dos jogos (gabarito)");
		System.out.println("3. Ver nome dos vencedores");
		System.out.println("0. Encerrar as apostas");
	}
	private void instruçõesAposta() {
		System.out.println("\nInforme os 14 placares da sua aposta: ");
		System.out.println("\n0 -> empate");
		System.out.println("1 -> vitória do time A");
		System.out.println("2 -> vitória do time B\n");
	}
	
	private void posicaoPlacar(int index) {
		System.out.println((index+1) + "º placar: ");
	}
}
