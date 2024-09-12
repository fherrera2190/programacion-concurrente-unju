package bloque23;

import java.util.Random;

public class Bloque23 extends Thread {
	private static int tam = 4;

	private static int[][] matriz = new int[tam][tam];

	private int inicio, fin;

	public Bloque23(int inicio, int fin) {
		// TODO Auto-generated constructor stub
		this.inicio = inicio;
		this.fin = fin;
	}

	public void run() {
		for (int i = inicio; i < fin; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j]*=10;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double tiempo_inicio, tiempo_final;
		Random rand = new Random(System.nanoTime());

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = rand.nextInt(10);
			}
		}
		
		tiempo_inicio =System.nanoTime();
		Bloque23 h1 = new Bloque23(0, 2);
		Bloque23 h2 = new Bloque23(2, 4);
		
		h1.start();
		h2.start();
		
		try {
			h1.join();
			h2.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		tiempo_final =System.nanoTime()-tiempo_inicio;
		System.out.println(tiempo_final/1000000 + " milisengundos");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j]+" ");
				
			}
			System.out.println();
		}

	}

}
