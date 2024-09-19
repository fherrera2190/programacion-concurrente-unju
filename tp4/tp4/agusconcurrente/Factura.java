package agusconcurrente;

import java.util.List;
import java.util.Random;

public class Factura extends Thread{
	
	private List<String> factura;
	private List<String> bizcocho;
	private Object Mostrador;
	
	public Factura(List<String> factura, List<String> bizcocho, Object mostrador) {
		this.factura = factura;
		this.bizcocho = bizcocho;
		this.Mostrador = mostrador;
	}
	
	public void run() {
		while(true) {
			Random r = new Random();
			try {
				Thread.sleep(r.nextInt(301)+1000);
				factura.add("Factura");
				System.out.println("Se ha producido una factura.");
				synchronized (Mostrador) {
					if(!factura.isEmpty() && !bizcocho.isEmpty()) {
						Mostrador.notify();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
