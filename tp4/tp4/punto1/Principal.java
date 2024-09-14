package punto1;

import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cola cola = new Cola();
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			Productor productor= new Productor(cola);
			int tiempo = 100 + random.nextInt(101);
			try {
				Thread.sleep(tiempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			productor.start();
			
		}
		
		for (int i = 0; i < 10; i++) {
			Consumidor consumidor= new Consumidor(cola);
			int tiempo = 100 + random.nextInt(101);
			try {
				Thread.sleep(tiempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			consumidor.start();
			
		}
		

	}

}
