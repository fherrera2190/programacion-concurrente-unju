package punto4;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Supermercado extends Thread{
	private static Semaphore carrito = new Semaphore(15);
	private static Semaphore caja = new Semaphore(3);
	int cliente;
	
	public Supermercado(int cliente) {
		this.cliente= cliente;
	}
	
	public void run() {
		try {
			entrar(cliente);
			comprar(cliente);
			pagar(cliente);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void entrar(int cliente) throws InterruptedException {
		if(carrito.availablePermits()==0) {
			System.out.println("Cliente "+ cliente +" se encuentra haciendo fila para entrar.");
		}
		carrito.acquire();
		System.out.println("Cliente " + cliente + " entró al Súper y tomó un carrito.");
	}
	
	private void comprar(int cliente) throws InterruptedException {
		System.out.println("El cliente "+ cliente +" esta comprando.");
		Thread.sleep(generarNumeroAleatorio(4000, 7000));
	}
	
	private void pagar(int cliente) throws InterruptedException {
		if(caja.availablePermits()==0) {
			System.out.println("Cliente "+ cliente +" esta haciendo fila para pagar.");
		}
		caja.acquire();
		System.out.println("Cliente "+ cliente +" esta pagando en la caja ");
		Thread.sleep(generarNumeroAleatorio(2000, 4000));
		carrito.release();
		caja.release();
		System.out.println("Cliente "+ cliente +" dejo un carrito y abandono el Súper.");
	}
	
	
	 public static int generarNumeroAleatorio(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
