package prueba2;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * for (int i = 0; i < 10; i++) { Hilo hilo = new Hilo(i); hilo.start(); }
		 */

		Object cerrojo = new Object();

		HiloDormilon hiloDormilon = new HiloDormilon(cerrojo);

		hiloDormilon.start();

		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HiloDespertador hiloDespertador = new HiloDespertador(cerrojo);

		hiloDespertador.start();

	}

}
