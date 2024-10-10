package punto6;

import java.util.Random;

public class GenerarClientes extends Thread {
	Cola cola;
	Barbero barbero;
	public GenerarClientes(Cola cola,Barbero barbero) {
		this.cola = cola;
		this.barbero=barbero;
	}

	public void run() {
		int cliente = 1;
		while (true) {
			Random random = new Random();
			try {
				Thread.sleep(500 + random.nextInt(1001));
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.cola.agregarCliente("Cliente "+cliente);
			this.barbero.despertarBarbero();
			cliente++;
		}
	}

}
