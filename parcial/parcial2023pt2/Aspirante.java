package parcial2023pt2;

import java.util.Random;

public class Aspirante extends Thread {
	String nombre;
	Pista pista1, pista2;

	public Aspirante(String nombre, Pista pista1, Pista pista2) {
		this.nombre = nombre;
		this.pista1 = pista1;
		this.pista2 = pista2;
	}

	public void run() {
		try {
			Random random = new Random();
			this.pista1.utilizarPista(this.nombre);
			int randomNumber = 1100 + random.nextInt(201);
			Thread.sleep(randomNumber);

			this.pista1.abandonarPista(this.nombre);
			System.out.println(this.nombre + " ingresando al pasillo");

			this.pista2.utilizarPista(this.nombre);
			randomNumber = 600 + random.nextInt(201);
			Thread.sleep(randomNumber);

			this.pista2.abandonarPista(this.nombre);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
