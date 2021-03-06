package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
	AquarioLombriga aqLombriga;
	String acoes;
	int tamanhoAquario, tamanhoLombriga, posicaoCabeca, passoAnimacao;
	

	Animacao(String sequenciaAcoes) {
		this.tamanhoAquario = 10 * ((int) sequenciaAcoes.charAt(0) - 48) + ((int) sequenciaAcoes.charAt(1) - 48);
		this.tamanhoLombriga = 10 * ((int) sequenciaAcoes.charAt(2) - 48) + ((int) sequenciaAcoes.charAt(3) - 48);
		this.posicaoCabeca = 10 * ((int) sequenciaAcoes.charAt(4) - 48) + ((int) sequenciaAcoes.charAt(5) - 48);
		
		this.aqLombriga = new AquarioLombriga(tamanhoAquario, tamanhoLombriga, posicaoCabeca);
		
		this.acoes = sequenciaAcoes;
		
		this.passoAnimacao = 6;
	}
	

	String apresenta() {
		return aqLombriga.apresenta();
	}
	
	
	void passo() {
		switch (acoes.charAt(passoAnimacao)) {
			case 'C':
				aqLombriga.crescer();
				break;
			case 'M':
				aqLombriga.mover();
				break;
			case 'V':
				aqLombriga.virar();
				break;
		}
	
		this.passoAnimacao++;
	}
}
