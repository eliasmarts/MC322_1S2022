package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {
	
	public static void main(String[] args) {
		AppRestaUm.executaJogo(null, null);
	}


	public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
		/*
		 * Executa o jogo de resta um com os movimentos recebidos da
		 * entrada enquanto eles são válidos.
		 */
		Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
		      
		String commands[] = tk.retrieveCommands();
		      
		String comandosSep[];
		String origem, destino;
		boolean continua = true;
		      
		Tabuleiro tab = new Tabuleiro();

		      
		char board[][] = tab.mostrarTabuleiro();
		tk.writeBoard("Tabuleiro inicial", board);

		
		// vai realizando os movimentos enquanto eles são válidos
		for (int l = 0; l < commands.length; l++) {
			if (continua) {
				comandosSep = commands[l].split(":");
				origem = comandosSep[0];
				destino = comandosSep[1];
	
				continua = tab.mover(origem, destino);
				  
				board = tab.mostrarTabuleiro();
				tk.writeBoard("source: " + origem + "; target: " + destino, board);
			}
		}
		  
		tk.stop();
	}
}
