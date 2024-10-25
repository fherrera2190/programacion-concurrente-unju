package punto1;

import java.util.Random;

public class Caballo implements Runnable {
	String caballoId;
	int tiempoVueltaParcial;
	int tiempoTotal;
	
	public Caballo(String nombre) {
		this.caballoId = nombre;
	}
		
	public void run() {
		Random random = new Random();
        int randomNumber = random.nextInt(1001) + 2500;
        try {
			Thread.sleep(randomNumber);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        tiempoTotal+=randomNumber;
        tiempoVueltaParcial=randomNumber;
	}
	
}
