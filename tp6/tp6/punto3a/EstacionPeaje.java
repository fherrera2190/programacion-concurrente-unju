package punto3a;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class EstacionPeaje {

	Semaphore cabinas;

	public EstacionPeaje() {
		this.cabinas = new Semaphore(2);

	}

	public void PagarPeaje(int id) {
		try {
			this.cabinas.acquire();
			System.out.println("Cliente "+id+" entro a una cabina");
			Random random = new Random();
			Thread.sleep(1000 + random.nextInt(2001));
			System.out.println("Cliente "+id+" Pago peaje");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.cabinas.release();
		}
	}

	public void HabilitarCabina() {
		System.out.println("Cabina 3 Habilitada ");
		this.cabinas.release();

	}

}
