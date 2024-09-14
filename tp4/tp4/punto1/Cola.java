package punto1;

import java.util.ArrayList;

public class Cola {

	private ArrayList<Elemento> cola;

	public Cola() {

		this.cola = new ArrayList<Elemento>();

	}

	public synchronized void consumir() {
		while (this.cola.isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (this.cola.size() > 0) {
			this.cola.removeFirst();

		}
	}

	public synchronized void producir(int tiempo) {
		this.cola.addLast(new Elemento());
		System.out.println("Nuevo elemento: " + this.cola.size() + " Tiempo de fabricación " + tiempo + " seg");
		this.notifyAll();
	}

}
