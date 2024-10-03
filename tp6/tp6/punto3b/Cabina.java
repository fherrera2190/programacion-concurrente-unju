package punto3b;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cabina {

	private String id;
	private Semaphore cabina;

	public Cabina(String id, int estado) {
		this.id = id;
		this.cabina = new Semaphore(estado,true);

	}

	public void UsarCabina(int idCliente) {
		try {
			this.cabina.acquire();
			System.out.println("Cliente " + idCliente + " entro a " + this.id);
			Random random = new Random();
			Thread.sleep(1000 + random.nextInt(2001));
			System.out.println("Cliente " + idCliente + " Pago peaje en "+this.id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.cabina.release();
		}
	}

	public void HabilitarCabina() {
		System.out.println(this.id + " Habilitada ");
		this.cabina.release();
	}

}
