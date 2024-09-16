package tp5.tp5.punto3;

public class HiloLeerNota implements Runnable {
	private int id;
	private String link;

	public HiloLeerNota(String link, int id) {
		this.id = id;
		this.link = link;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		long startTime = System.currentTimeMillis();
		String nota = Principal.obtenerNota(link);
		long endTime = System.currentTimeMillis();

		long tiempo = endTime - startTime;

		System.out.println("Hilo " + this.id + " encontro:\n" + nota + "\nTiempo de ejecución: " + tiempo + " milisegundos\n");

	}

}
