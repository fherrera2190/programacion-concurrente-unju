package prueba2;

public class HiloDespertador extends Thread{

	private Object cerrojo;
	
	public HiloDespertador(Object cerrojo) {
		// TODO Auto-generated constructor stub
		this.cerrojo = cerrojo;
		
	}
	
	public void run() {
	
		synchronized (cerrojo) {
			System.out.println("Bro despertarte!!");
			cerrojo.notify();
			System.out.println("Termine, lo desperte");
		}
	}

}
