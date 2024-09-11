package bloque11;

public class HiloHijo extends Thread {

	private String name;
	public HiloHijo(String name) {
		this.name= name;
		
	}

	public void run() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Termine, soy "+this.name);
	}
}
