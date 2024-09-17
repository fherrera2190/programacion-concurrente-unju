package punto4;

import java.util.Random;

public class Operaciones {

	public static double sumRootN(int root) {
		double result = 0;
		for (int i = 0; i < 10000000; i++) {
			result += Math.exp(Math.log(i) / root);

		}
		return result;
	}

	public static void inicializarMatriz(int[][] matriz) {
		Random random = new Random();

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = random.nextInt(11) + 5;
			}
		}
	}

	public static void mostrarMatriz(int[][] matriz) {
		for (int[] fila : matriz) {
			for (int elemento : fila) {

				String valor = Integer.toString(elemento);

				if (valor.length() < 2) {
					System.out.print("0" + elemento + " ");
				} else {
					System.out.print(elemento + " ");
				}
			}
			System.out.println();
		}
	}

	public static void mostrarMatriz(double[][] matriz) {
		// TODO Auto-generated method stub
		for (double[] fila : matriz) {
			for (double elemento : fila) {

				System.out.print(elemento + " ");

			}
			System.out.println();
		}
	}
}
