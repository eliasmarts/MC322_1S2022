package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
	int tamanhoAquario, tamanhoLombriga, posInicioLombriga;
	boolean cabecaLadoEsquerdo;
	
	
	AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posCabecaLombriga) {
		if (tamanhoAquario > 0)
			this.tamanhoAquario = tamanhoAquario;
		else
			this.tamanhoAquario = 1;
	
		if (tamanhoLombriga > tamanhoAquario)
			this.tamanhoLombriga = tamanhoAquario;
		else
			this.tamanhoLombriga = tamanhoLombriga;
		
		if (posCabecaLombriga < 1 || posCabecaLombriga > tamanhoAquario)
			this.posInicioLombriga = 1;
		else
			this.posInicioLombriga = posCabecaLombriga;

		this.cabecaLadoEsquerdo = true;
	}
	
	
	void crescer() {
		if (cabecaLadoEsquerdo && posInicioLombriga + tamanhoLombriga - 1 < tamanhoAquario) {
				posInicioLombriga--;
				tamanhoLombriga++;
		} else if (posInicioLombriga > 1) {
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
