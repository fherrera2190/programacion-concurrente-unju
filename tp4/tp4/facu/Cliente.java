package tp4.tp4.facu;

import java.util.List;
import java.util.Random;

public class Cliente extends Thread{
	
	private int idCliente;
	private List<String> bizcochos, facturas;
	
	private static final Object mostrador = new Object();
	private static final Random ran = new Random();
	
	public Cliente(int idCliente, List<String> bizcochos, List<String> facturas) {
		this.bizcochos=bizcochos;
		this.facturas=facturas;
		this.idCliente=idCliente;
	}

	@Override
	public void run() {
		while(true) {
			System.out.println("Cliente "+this.idCliente+" llegando");
			dormir(800,1500);
			synchronized(mostrador) {
				if(bizcochos.size()==0|facturas.size()==0) {
					System.out.println("Cliente "+this.idCliente+" esperando");
					synchronized(bizcochos) {
						synchronized(facturas) {
							try {
								bizcochos.wait();
								facturas.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
				System.out.println("Cliente "+this.idCliente+" comprando");
				bizcochos.removeFirst();
				facturas.removeFirst();
				dormir(200,400);
				System.out.println("Cliente "+this.idCliente+" se retira");
				dormir(200,400);
			}
		}
	}
	
	public void dormir(int min, int max) {
		try {
			sleep(ran.nextInt(max - min + 1) + min);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
