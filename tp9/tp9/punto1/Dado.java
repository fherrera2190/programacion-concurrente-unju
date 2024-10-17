package punto1;

import java.util.Random;

public class Dado extends Thread {
	private int[] resultado;
	int pos;

	public Dado(int[] resultado, int pos) {
		// TODO Auto-generated constructor stub
		this.resultado = resultado;
		this.pos = pos;
	}

	public void run() {
		this.resultado[this.pos]=this.tirarDado() ;
	}

	private int tirarDado() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}
}
