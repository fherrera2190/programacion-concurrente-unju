package parcial2023pt1;

import java.util.concurrent.Semaphore;

public class Proceso extends Thread {

	Semaphore sem1 ;
	Semaphore sem2 ;
	String nombre;

	public Proceso(String nombre, Semaphore semA, Semaphore semB) {
		this.nombre = nombre;
		this.sem1 = semA;
		this.sem2= semB;
	}

	public void run() {
		while(true) {
			try {
				this.sem1.acquire();
				System.out.print(this.nombre);
				Thread.sleep(100);
				this.sem2.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
