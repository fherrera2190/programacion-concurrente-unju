package agusconcurrente;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulacion {
	public static void main(String[] args) {
		Object Mostrador = new Object();
		List<String> factura = new ArrayList<String>();
		List<String> bizcocho = new ArrayList<String>();
		int i=0;
		
		Bizcocho b = new Bizcocho(factura, bizcocho, Mostrador);
		Factura f = new Factura(factura, bizcocho, Mostrador);
		Random r = new Random();
		
		f.start();  
		b.start(); 
		
		while(true) { 
			i++;			
			Cliente c = new Cliente(factura, bizcocho, Mostrador, i);
			c.start();
			try {
				Thread.sleep(r.nextInt(701)+800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
