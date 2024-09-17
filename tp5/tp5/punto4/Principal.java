package punto4;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int valor1 = 20;
		int valor2 = 15;
		int[][] matrizA = new int[valor1][valor2];
		int[][] matrizB = new int[valor2][valor1];
		Operaciones.inicializarMatriz(matrizA);
		Operaciones.inicializarMatriz(matrizB);
		Operaciones.mostrarMatriz(matrizA);
		Operaciones.mostrarMatriz(matrizB);
		System.out.println("***************************");

		double[][] matrizC = new double[valor1][valor1];

		Thread[][] hilos = new Thread[valor1][valor1];

		for (int i = 0; i < hilos.length; i++) {
			for (int j = 0; j < hilos[0].length; j++) {
				hilos[i][j] = new Thread(new CalculoConcurrente(i, j, matrizA, matrizB, matrizC));
				hilos[i][j].start();
				;
			}
		}

		for (int i = 0; i < hilos.length; i++) {
			for (int j = 0; j < hilos[0].length; j++) {
				try {
					hilos[i][j].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				;
			}
		}


		
		Operaciones.mostrarMatriz(matrizC);
	}

}
