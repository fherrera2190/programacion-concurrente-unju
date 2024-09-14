package punto1;

import java.util.Random;

public class Productor  extends Thread{

	private Cola cola;
	
	
	public Productor(Cola cola) {
		this.cola = cola;
	}
	
	public void run() {
		Random random = new Random();
		while(true) {
			int tiempo =1000 + random.nextInt(501);
			try {
				Thread.sleep(tiempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cola.producir(tiempo);
		}
	}
	
	
}
