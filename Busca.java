package nRainhasTempera;

public class Busca {
	private double e;
	private Problema problema;
	private int iteraMax, tam;
	private float alpha, tempInicial, temperatura;
	
	public Busca(int n, int iteraMax, float alpha) { //n é o número de rainhas
		if(n<4) {
			System.out.println("\nPara as dimensões do tabuleiro, insira um valor maior que 3.");
		} else {
			problema = new Problema(n);
			
			this.iteraMax = iteraMax;
			this.alpha = alpha;
			this.tam = n;
			this.e = 2.71828182845;
			
			temperaSimulada();
		}
	}
	
	public void temperaSimulada() {
		
		int estadoAtual[] = new int[tam];
		int estadoFinal[] = new int[tam];
		
		problema.copiar(estadoFinal, problema.getEstadoInicial()); 
		tempInicial = problema.heuristica( problema.getEstadoInicial());
		temperatura = tempInicial;
		
		//Loop principal – Verifica se foram atendidas as condições de termino do algoritmo 
		while(temperatura > (float)0.1) {	
			System.out.println("\n" + temperatura + "\n");
			int i = 0;
			
			while(i < iteraMax) { //Loop Interno – Realização de perturbação em uma iteração
				//estadoAtual = encosta.pertubacao(estadoFinal, pertMax); //gera novo estado de exploracao{
				estadoAtual = problema.sucessora(estadoFinal); 
				problema.printar(estadoFinal); //impirmir solucao
				System.out.println(problema.heuristica(estadoFinal));
				
				int deltafi = problema.heuristica(estadoAtual) - problema.heuristica(estadoFinal); //variacao de energia
				double random = randomiza(); //gera numero aleatorio entre zero e 1
				
				if((deltafi <= 0)) { //Teste de aceitação de uma nova solução
					problema.copiar(estadoFinal, estadoAtual);	
				}//fim do if
				else{
					if ((Math.pow(e, -deltafi/temperatura) > random)) {
						problema.copiar(estadoFinal, estadoAtual);	
					}
				}
				
				i++;
			}//fim loop interno
			
			if(problema.heuristica(estadoAtual) == 0) {
				problema.copiar(estadoFinal, estadoAtual);
				break;
			}
			temperatura = alpha * temperatura;

		}//fim loop externo
		
		System.out.println("\n\ntemperatura: "+temperatura);
		problema.printar(estadoFinal); //impirmir solucao
		System.out.println("\nQuant Ataques: "+problema.heuristica(estadoFinal));
		tabuleiro(estadoFinal);
	}//fim do metodo temperaSimulado
	
	public double randomiza() {
		double random = 0 + Math.random() * (1 - 0);
		//System.out.println(random);
		return random;
	}
	
	public void tabuleiro(int[] vetor) {
		int tam = vetor.length;
		char m[][] = new char[tam][tam];
		
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				m[i][j] = '-';
			}
		}
		
		for (int i = 0; i < tam; i++) {
			m[vetor[i]-1][i] = 'r';
		}
		
		for (int l = 0; l < tam; l++)  {  
			for (int c = 0; c < tam; c++)     { 
				System.out.print(m[l][c] + " "); //imprime caracter a caracter
		    }  
		    System.out.println(" "); //muda de linha
		}

	}//fim tabuleiro

}
