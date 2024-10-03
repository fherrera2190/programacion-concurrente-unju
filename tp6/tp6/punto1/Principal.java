package punto1;

public class Principal {
	public static void main(String[] args) {
		int i=1;
		while (i<100) {
			Hilo hilo = new Hilo(i);
			try {
				Thread.sleep(Hilo.generarNumeroAleatorio(150, 300));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hilo.start();
			i++;
		}
	}
}
