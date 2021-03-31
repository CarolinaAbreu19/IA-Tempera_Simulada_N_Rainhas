package nRainhasTempera;

import java.util.Random;

public class Problema {
	
	private int estadoInicial[]; //modelagem de um estado do tabuleiro
	private Random rand = new Random();
	
	public Problema() {} //construtor

	public Problema(int n) { //n é o número de rainhas
		estadoInicial = new int[n]; //[]
		
		povoarVetor(estadoInicial); //define o estado inicial [1,2,3,4,5,6..n]
	}//fim do construtor
	
	public int[] getEstadoInicial() {
		return estadoInicial;
	}
	
	public void setEstadoInicial(int[] estadoInicial) {
		this.estadoInicial = estadoInicial;
	}
	
	//quantidade de ataques é a temperatura
	public int heuristica(int[] estado) { // [1,2,3,4,5,6..n]
		int ataques = 0;
		int limite = estado.length;
		
		for (int i = 0; i < limite ;i++) {
			for (int j = i+1; j < limite; j++) { 

				int atakDiag = estado[i] - estado[j];
				int atak =  i-j; //verifica se tem ataque ou não

				if (Math.abs(atakDiag) == Math.abs(atak)) { //se tem ataque então incrementa ataques.
					ataques++;
				}
			}
		}
		return ataques;
	}//fim do metodo hueristica
	
	//define o estado inicial
	public void povoarVetor(int[] vetor) { 
		for (int i = 0; i< vetor.length; i++) {
			vetor[i] = i+1;
		}
		printar(vetor);
	}//fim do metodo povoarVetor
	
	public int[] sucessora(int[] estado) { //[1,2,3,4,5,6..n]
		int novoEstado[] = new int[estado.length];
		copiar(novoEstado, estado);
		
		int tam = estado.length;
		int c1 = rand.nextInt(tam); //coordenada 1
		int c2 = rand.nextInt(tam); //coordenada 2
		
		while(c1 == c2) {
			c2 = rand.nextInt(tam);
		}

		int aux = novoEstado[c1];
		novoEstado[c1] = novoEstado[c2];
		novoEstado[c2] = aux;
		
		return novoEstado; // c1=1 c2=2 [1,3,2,4,5,6..n]
	}//fim sucessora
	
	public void printar(int[] estadoInicial) {
		for(int i=0; i< estadoInicial.length;i++) System.out.print("["+estadoInicial[i]+"]");
	}//fim de printar
	
	//vetor1 = vetor2
	public void copiar(int[] vetor1, int[] vetor2) {
		for(int i = 0; i < vetor1.length; i++) {
			vetor1[i] = vetor2[i];
		}
	}//fim do metodo copiar
}