package tp4.tp4.punto2;

public class Horno extends Thread {

	private int tiempo;
	private String tipo;

	private Panaderia panaderia;

	public Horno(int tiempo, String tipo, Panaderia panaderia) {
		this.tiempo = tiempo;
		this.tipo = tipo;
		this.panaderia = panaderia;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(this.tiempo);
				panaderia.agregarProducto(this.tipo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}