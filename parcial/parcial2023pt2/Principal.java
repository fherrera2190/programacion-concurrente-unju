package parcial2023pt2;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pista pista1 = new Pista("Pista 1", 20);
		Pista pista2 = new Pista("Pista 2", 10);
		for (int i = 1; i <= 200; i++) {
			Aspirante aspirante = new Aspirante("Aspirante " + i, pista1, pista2);
			aspirante.start();

		}
	}

}
