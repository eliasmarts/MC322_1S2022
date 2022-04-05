package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

	public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      Animacao anim;
      
      String lombrigas[] = tk.recuperaLombrigas();
      
      for (int l = 0; l < lombrigas.length; l++) {
    	  anim = new Animacao(lombrigas[l]);
  
    	  tk.gravaPasso("=====");
    	  for (int j = 0; j < lombrigas[l].length() - 6; j++) {
    		  tk.gravaPasso(anim.apresenta());
    		  anim.passo();
    	  }
    	  // grava o ultimo passo
    	  tk.gravaPasso(anim.apresenta());
      }
      
      tk.stop();
   }

}
