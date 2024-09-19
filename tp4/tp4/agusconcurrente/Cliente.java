package agusconcurrente;

import java.util.List;
import java.util.Random;

public class Cliente extends Thread{
	private List<String> factura;
	private List<String> bizcocho;
	private Object Mostrador;
	private int cliente;
	
	public Cliente(List<String> factura, List<String> bizcocho, Object mostrador, int cliente) {
		this.factura = factura;
		this.bizcocho = bizcocho;
		this.Mostrador = mostrador;
		this.cliente = cliente;
	}
	public void run() {
		Random r = new Random();
		try {
			synchronized (Mostrador) {
				System.out.println("El cliente N�"+cliente+" entro a la panaderia.");
				while(factura.isEmpty() || bizcocho.isEmpty()) {
					System.out.println("El cliente N�"+cliente+" tiene que esperar.");
					if(factura.isEmpty() && bizcocho.isEmpty()) {
						System.out.println("Mostrador vacio.");
					}
					Mostrador.wait();
				}
				Cliente.sleep(r.nextInt(201)+200);
				factura.remove(0);
				bizcocho.remove(0);
				System.out.println("El cliente N�"+cliente+" esta comprando.");
			}
			Thread.sleep(r.nextInt(201)+200);
			System.out.println("El cliente N�"+cliente+" se ha retirado del local.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
