package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	/*
	 * Representa um tabuleiro de resta um 7x7 usando uma matriz.
	 */
	Peca pecas[][];
	/*
	 * Representa as posicoes dentro e fora do tabuleiro,
	 * e o estado inicial.
	 * 'P' começa com peça
	 * '-' começa vazio
	 * ' ' fora do tabuleiro
	 */
	char posicoesTabuleiro[][] = {
	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
	         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
	         {'P', 'P', 'P', '-', 'P', 'P', 'P'},
	         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
	         {' ', ' ', 'P', 'P', 'P', ' ', ' '}
	};
	
	Tabuleiro() {
		
		pecas = new Peca[7][7];

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (posicoesTabuleiro[i][j] == 'P')
					pecas[i][j] = new Peca(this, true);
				else
					pecas[i][j] = new Peca(this, false);
			}
		}
	}
	
	/*
	 * retorna se uma posicao x y esta dentro do tabuleiro.
	 */
	boolean dentroTabuleiro(int x, int y) {
		if (x > 6 || x < 0 || y > 6 || y < 0)
			return false;
		if (posicoesTabuleiro[x][y] == ' ')
			return false;
		else
			return true;
	}
	
	
	void removerPeca(int x, int y) {
		if (dentroTabuleiro(x, y))
			pecas[x][y].remover();
	}
	

	void colocarPeca(int x, int y) {
		if (dentroTabuleiro(x, y))
			pecas[x][y].colocar();
	}
	
	
	boolean existePeca(int x, int y) {
		if (dentroTabuleiro(x, y))
			return pecas[x][y].existe;
		else
			return false;
	}
	
	
	/**
	 * Retorna um vetor de caracteres com o estado atual do tabuleiro,
	 * com 'P' onde tem peça e ' ' onde não tem.
	 */
	char[][] mostrarTabuleiro() {
		char tabuleiro_char[][] = new char[7][7];
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (posicoesTabuleiro[i][j] == ' ')
					tabuleiro_char[i][j] = ' ';
				else
					tabuleiro_char[i][j] = pecas[i][j].existe ? 'P' : '-';		
			}
		}
		
		return tabuleiro_char;
	}
	
	
	/*
	 * Dada a String no formato [coluna][linha] retorna
	 * um vetor de inteiro que na posicao 0 tem x e na
	 * posicao 1 tem y.
	 */
	int[] converterCoordenadasInteiro(String coord_str) {
		int coordInt[] = new int[2];
		// em ASCII 49 = '1' e 97 = 'a'
		coordInt[0] = ((int) coord_str.charAt(1)) - 49;
		coordInt[1] = ((int) coord_str.charAt(0)) - 97;
		
		return coordInt;
	}
	
	/*
	 * Dada as coordenadas x e y retorna a string no formato
	 * [coluna][linha]
	 */
	String converterCoordenadasString(int x, int y) {
		String coordStr = new String();

		coordStr += (char) (97 + y);
		coordStr += (char) (49 + x);
		
		return coordStr;
	}
	
	
	/*
	 * Se o movimento for possível, move a peça de posInicial a posFinal
	 * e retorna true. Se não for, retorna false.
	 */
	boolean mover(String posInicial, String posFinal) {
		int posIni[] = converterCoordenadasInteiro(posInicial);
		int posFim[] = converterCoordenadasInteiro(posFinal);
		int xi = posIni[0], yi = posIni[1], xf = posFim[0], yf = posFim[1];
		
		String pecaCapturada = pecas[xi][yi].mover(xi, yi, xf, yf);
		
		if (!pecaCapturada.equals("erro")) {
			int posCaptura[] = converterCoordenadasInteiro(pecaCapturada);
			int xc = posCaptura[0], yc = posCaptura[1];

			pecas[xc][yc].remover();
			pecas[xf][yf].colocar();
			
			return true;
		} else
			return false;
	}
}
