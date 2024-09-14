package prueba1;

import java.util.ArrayList;

public class ProductorClientes extends Thread{
	ArrayList<Cliente> cola;
	public ProductorClientes(ArrayList<Cliente> cola){
		this.cola = cola;
	}
	public void run() {
		while(true) {
			synchronized (cola) {
				cola.addLast(new Cliente());
			}
		}
	}

}
