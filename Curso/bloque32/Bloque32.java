package bloque32;

import java.util.Random;

public class Bloque32 implements Runnable {
	private int id;
	private static Random cerrojo = new Random();
	private static int cont=0;
	public Bloque32(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		synchronized (cerrojo) {
			while(id!=cont) {
				try {
					cerrojo.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Soy el hilo: "+this.id);
			cont++;
			cerrojo.notifyAll();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime runtime = Runtime.getRuntime();
		int nNucleos = runtime.availableProcessors()	;
		Thread[]hilos = new Thread[nNucleos];
		
		for (int i = 0; i < hilos.length; i++) {
			Runnable runnable = new Bloque32(i);
			hilos[i]= new Thread(runnable);
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
