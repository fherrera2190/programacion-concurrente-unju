package punto2;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (double i = -5; i <= 5; i +=0.1) {
			double x = Math.round(i * 10) / 10.0;
			new Thread(new Hilo(x)).start();
		}
	}

}
