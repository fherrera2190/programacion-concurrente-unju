package punto1;

import java.util.Random;

public class Consumidor extends Thread {
private Cola cola;
	
	
	public Consumidor(Cola cola) {
		this.cola = cola;
	}
	
	public void run() {
		Random random = new Random();
		while(true) {

			try {
				Thread.sleep(400 + random.nextInt(401));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cola.consumir();
			System.out.println("Consumi un elemento");
		}
	}
}
