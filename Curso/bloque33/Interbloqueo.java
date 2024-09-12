package bloque33;

import java.util.Random;

public class Interbloqueo implements Runnable {
	private int id;
	private static Random cerrojoA = new Random();
	private static Thread cerrojoB = new Thread();

	public Interbloqueo(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		if (id % 2 == 0) {
			synchronized (cerrojoA) {
				mostrarA();
			}
		} else {
			synchronized (cerrojoB) {
				mostrarB();
			}
		}
	}

	private void mostrarA() {
		synchronized (cerrojoB) {
			System.out.println("Soy el hilo: " + id);
		}

	}

	private void mostrarB() {
		synchronized (cerrojoA) {
			System.out.println("Soy el hilo: " + id);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime runtime = Runtime.getRuntime();
		int nNucleos = runtime.availableProcessors();
		Thread[] hilos = new Thread[nNucleos];

		for (int i = 0; i < hilos.length; i++) {
			Runnable runnable = new Interbloqueo(i);
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
