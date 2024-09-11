package bloque23;

import java.util.Random;

public class Bloque23 extends Thread {
	private static int tam = 4;

	private static int[][] matriz = new int[tam][tam];

	public Bloque23(int i, int j) {
		// TODO Auto-generated constructor stub
		matriz=new int[i][j];
	}

	public void run() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random(System.nanoTime());

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j]= rand.nextInt(10);
			}
		}

		Bloque23 h1 = new Bloque23(0,2);
		Bloque23 h2 = new Bloque23(2,4);
		
		
		
		
		
		
	}

}
