package prueba1;

import java.util.ArrayList;

public class Cajero extends Thread {
	
	ArrayList<Integer> fila ;
	
	public Cajero(ArrayList<Integer> fila) {
		// TODO Auto-generated constructor stub
		this.fila = fila;
	}

	public void run() {
		while(!fila.isEmpty()) {
			System.out.println(fila.removeFirst());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
