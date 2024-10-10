package punto6;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Barbero extends Thread {
	Semaphore estadoBarbero;
	Cola cola;
	public Barbero(Cola cola) {
		this.estadoBarbero = new Semaphore(0);
		this.cola = cola;
	}
	
	public void despertarBarbero() {
		this.estadoBarbero.release();
	}
	
	
	public void run() {
		
		while(true) {
			try {
				Random random = new Random();
				this.estadoBarbero.acquire();
				Thread.sleep(1000 + random.nextInt(301));
				System.out.println("Barbero atendio "+ this.cola.atenderCliente());
				if(!this.cola.checkearCola()) {
					System.out.println("Se durmio el barbero");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
