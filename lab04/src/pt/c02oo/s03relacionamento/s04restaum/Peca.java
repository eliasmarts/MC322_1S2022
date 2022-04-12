package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	/*
	 * Representa uma peça de um jogo de resta um.
	 */
	boolean existe;
	Tabuleiro tab;
	
	
	Peca(Tabuleiro tab, boolean existe) {
		this.existe = existe;
		this.tab = tab;
	}
	
	
	void remover() {
		existe = false;
	}
	
	
	void colocar() {
		existe = true;
	}
	
	/*
	 * se o movimento for possível, se remove e retorna 
	 * a String com as coordenadas da peça capturada,
	 * se não for, retorna a String "erro"
	 */
	String mover(int xi, int yi, int xf, int yf) {
		// posicoes fora do tabuleiro
		if (!tab.dentroTabuleiro(xi, yi) || !tab.dentroTabuleiro(xf, yf))
			return "erro";
		
		// distancia deve ser 2
		if ((xf - xi) * (xf - xi) + (yf - yi) * (yf - yi) != 4)
			return "erro";
		
		// posicao da peca capturada
		int xc = (xf + xi) / 2;
		int yc = (yf + yi) / 2;
		
		if (!tab.existePeca(xc, yc))
			return "erro";
		
		// se passou em tudo isso sabemos que o movimento é válido
		String pecaCapturada = new String();
		pecaCapturada = tab.converterCoordenadasString(xc, yc);
		
		// atualiza o estado da peça
		remover();
		
		return pecaCapturada;	
	}
}
