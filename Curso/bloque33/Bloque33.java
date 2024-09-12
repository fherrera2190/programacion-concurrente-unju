package bloque33;

import java.util.Random;

public class Bloque33 implements Runnable {
	private int id;
	private static Random cerrojoA = new Random();
	private static Thread cerrojoB = new Thread();
	
	
	private int cont_private;	
	private static int cont = 0;
	
	public Bloque33(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		for (int i = 0; i <20000; i++) {
			cont_private++;
		}
		synchronized (cerrojoA) {
			cont += cont_private;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime runtime = Runtime.getRuntime();
		int nNucleos = runtime.availableProcessors();
		Thread[] hilos = new Thread[nNucleos];

		for (int i = 0; i < hilos.length; i++) {
			Runnable runnable = new Bloque33(i);
			hilos[i] = new Thread(runnable);
			hilos[i].start();

		}
		
		for (int i = 0; i < hilos.length; i++) {
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("Fin principal");

	}

}
