package punto1compa;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class Principal {
	public static Semaphore semaforo1 = new Semaphore(1);
	public static Semaphore semaforo2 = new Semaphore(0);

	public static void main(String[] args) {

		Set<Integer> valoresPosibles = new HashSet<>();

		for (int i = 0; i < 100; i++) {
			Contador x = new Contador(0);
			Hilo1 hilo1 = new Hilo1(semaforo1, semaforo2, x);
			Hilo2 hilo2 = new Hilo2(semaforo1, semaforo2, x);
			Hilo3 hilo3 = new Hilo3(semaforo1, semaforo2, x);

			hilo1.start();
			hilo2.start();
			hilo3.start();

			try {
				hilo1.join();
				hilo2.join();
				hilo3.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			valoresPosibles.add(x.getX());
		}

		System.out.println("Valores posibles finales de X");

		for (int num : valoresPosibles) {
			System.out.print(num+"  ");
		}
	}

}
