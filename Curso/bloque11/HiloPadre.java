package bloque11;

public class HiloPadre extends Thread {

	public HiloPadre() {


	}

	public void run() {
		
		System.out.println("Inicie (Padre)");
		HiloHijo hh1 = new HiloHijo("Hijo1");
		HiloHijo hh2 = new HiloHijo("Hijo2");
		hh1.start();
		hh2.start();
		try {
			
			hh1.join();
			hh2.join();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Termine (Padre)");
	}
}
