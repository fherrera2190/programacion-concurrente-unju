package punto1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Hilo extends Thread{
	private static Semaphore semaforo = new Semaphore(20);
	private static Semaphore semEntrada = new Semaphore(2);
	private static Semaphore semSalida = new Semaphore(2);
	private int auto;
	
	public Hilo(int auto) {
		this.auto = auto;
	}
	
	public void run() {
		try {
			if (semaforo.availablePermits() == 0) {
                System.out.println("Auto " + auto + " está esperando porque el estacionamiento está lleno.");
            }
			semaforo.acquire();
			System.out.println("Hay espacio disponible en el estacionamiento.");
			if (semEntrada.availablePermits() == 0) {
                System.out.println("Auto " + auto + " está esperando porque la entrada esta ocupada.");
            }
			semEntrada.acquire();
			System.out.println("Auto "+ auto + " entrando.");
			Thread.sleep(50);
            semEntrada.release();
            int tiempo = generarNumeroAleatorio(15000, 20000);
            System.out.println("Auto estacionado por "+ (tiempo/1000) + " segundos.");
            Thread.sleep(tiempo);
            if (semSalida.availablePermits() == 0) {
                System.out.println("Auto " + auto + " está esperando porque la salida esta ocupada.");
            }
            semSalida.acquire();
			System.out.println("Auto "+ auto + " saliendo.");
			Thread.sleep(50);
			semSalida.release();
			semaforo.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static int generarNumeroAleatorio(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
	
}
