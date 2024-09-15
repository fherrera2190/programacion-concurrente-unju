package tp4.tp4.facu;

import java.util.List;
import java.util.Random;

public class HornoFacturas extends Thread{
	
	private List<String> facturas;
	private Random ran;
	
	public HornoFacturas(List<String> facturas, Random ran) {
		this.facturas=facturas;
		this.ran=ran;
	}

	@Override
	public void run() {
		
		while(true) {
			try {
				sleep(ran.nextInt(1000 - 800 + 1) + 800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(facturas) {
				facturas.add("X");
				System.out.println("Se hizo una factura");
				facturas.notify();
			}
		}
		
	}

}
