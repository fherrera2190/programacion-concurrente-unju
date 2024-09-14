package prueba2;

public class HiloDormilon extends Thread{

	private Object cerrojo;
	
	public HiloDormilon(Object cerrojo) {
		// TODO Auto-generated constructor stub
		this.cerrojo = cerrojo;
		
	}
	
	public void run() {
		
		synchronized (cerrojo) {
			
			try {
				System.out.println("Me dormi");
				cerrojo.wait();
				System.out.println("Gracias por despertarme");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Termine");
			
		}
	}

}
