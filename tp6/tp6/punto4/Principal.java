package punto4;

public class Principal {
	public static void main(String[] args) {
		int i = 1;
		while (true) {
			Supermercado hilo = new Supermercado(i);
			try {
				Thread.sleep(Supermercado.generarNumeroAleatorio(300, 500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hilo.start();
			i++;
		}
	}
			
	

}
