package bloque24;

import java.util.Random;

public class Bloque24 extends Thread {
	private static int tam = 16;

	private static int[][] matriz = new int[tam][tam];

	private int inicio, fin;

	public Bloque24(int inicio, int fin) {
		// TODO Auto-generated constructor stub
		this.inicio = inicio;
		this.fin = fin;
	}

	public void run() {
		for (int i = inicio; i < fin; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] *= 10;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime runtime = Runtime.getRuntime();

		int nNucleos = runtime.availableProcessors();
		System.out.println(nNucleos);
		Random rand = new Random(System.nanoTime());

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = rand.nextInt(10);
			}
		}

		Thread[] hilos = new Thread[nNucleos];

		int rango = tam / nNucleos;

		int start = 0;
		int finish = rango;

		for (int i = 0; i < nNucleos; i++) {
			if(i!= nNucleos-1) {
				
				hilos[i] = new Bloque24(start, finish);
				hilos[i].start();
				
				start = finish;
				finish += rango;
			}
			else {
				hilos[i] = new Bloque24(start, tam);
				hilos[i].start();
			}
		}

		for (int i = 0; i < nNucleos; i++) {

			try {
				hilos[i].join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + " ");

			}
			System.out.println();
		}

	}

}
