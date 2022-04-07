package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
	int tamanhoAquario, tamanhoLombriga, posInicioLombriga;
	boolean cabecaLadoEsquerdo;
	
	
	AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posCabecaLombriga) {
		// se o tamanho do aquário é inválido
		if (tamanhoAquario > 0)
			this.tamanhoAquario = tamanhoAquario;
		else
			this.tamanhoAquario = 1;
	

		// se a posição da cabeça é inválida
		if (posCabecaLombriga < 1 || posCabecaLombriga > tamanhoAquario)
			this.posInicioLombriga = 1;
		else
			this.posInicioLombriga = posCabecaLombriga;
		
		
		if (tamanhoLombriga > tamanhoAquario)
			this.tamanhoLombriga = tamanhoAquario;
		// se a lombriga passa da borda direita do aquário, considera que ela vai
		// até a borda
		else if (posCabecaLombriga + tamanhoLombriga > tamanhoAquario)
			this.tamanhoLombriga = tamanhoAquario - posCabecaLombriga;
		else
			this.tamanhoLombriga = tamanhoLombriga;
		

		this.cabecaLadoEsquerdo = true;
	}
	
	
	void crescer() {
		if (cabecaLadoEsquerdo && posInicioLombriga + tamanhoLombriga - 1 < tamanhoAquario) {
				tamanhoLombriga++;
		} else if (!cabecaLadoEsquerdo && posInicioLombriga > 1) {
			posInicioLombriga--;
			tamanhoLombriga++;
		}
		
	}
	
	
	void mover() {
		if (cabecaLadoEsquerdo) {
			if (posInicioLombriga == 1)
				virar();
			else
				posInicioLombriga--;
		} 
		else {
			if (posInicioLombriga + tamanhoLombriga - 1 == tamanhoAquario)
				virar();
			else
				posInicioLombriga++;
		}
	}
	
	
	void virar() {
		cabecaLadoEsquerdo = !cabecaLadoEsquerdo;
	}
	
	
	String apresenta() {
		String apresentacao = new String();
		
		for (int i = 0; i < this.tamanhoAquario; i++) {
			// se a posicao da string é dentro da lombriga
			if (posInicioLombriga <= i + 1 && i + 1 <= posInicioLombriga + tamanhoLombriga - 1) {
				// se é a cabeça
				if (cabecaLadoEsquerdo && i + 1 == posInicioLombriga)
					apresentacao += 'O';
				else if (!cabecaLadoEsquerdo && i + 1 == posInicioLombriga + tamanhoLombriga - 1)
					apresentacao += 'O';

				else
					apresentacao += '@';
			}
			else {
				apresentacao += '#';
			}
		}
		
		return apresentacao;
	}
}
