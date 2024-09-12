package bloque31;

public class Bloque31 implements Runnable {

	private static int cont=0;
	private static Object object = new Object();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Runnable runnable = new Bloque31(); Thread hilo=new Thread(runnable);
		 * hilo.start(); try { hilo.join(); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
		Runtime runtime = Runtime.getRuntime();
		int nNucleos = runtime.availableProcessors();
		System.out.println("Nucleos: "+nNucleos);
		Thread[] hilos = new Thread[nNucleos];
		
		
		for (int i = 0; i < hilos.length; i++) {
			Runnable runnable = new Bloque31();
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
		System.out.println(cont);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// System.out.println("Hola");

			synchronized (object) {
				for (int i = 0; i < 100000; i++) {
				cont++;
				
			}

		}

	}

}
