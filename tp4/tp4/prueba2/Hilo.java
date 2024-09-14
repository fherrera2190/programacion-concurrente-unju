package prueba2;

public class Hilo extends Thread{

	
	private int id;
	private static Integer variable=0;
	private static Object cerrojo = new Object();
	
	public Hilo(int id) {
		this.id =id;
		
		
	}
	
	public void run() {
		
		synchronized (cerrojo) {
			
			System.out.println("Hilo: "+id+" valor: "+variable);
			this.variable++;
		}
	}
}
