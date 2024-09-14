

import java.util.Random;

public class Principal2 {
	
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
	
	public static void comMatriz(int[][] matriz,int filas,int columnas, Random random) {
		for(int i = 0;i<filas;i++) {
			for(int j = 0;j<columnas;j++) {
				int num = random.nextInt(100);
				matriz[i][j] = num;
			}
		}
	}
	
	public static void main(String[] args) {
		int filas= 100;
		int columnas=200;
		int[][] a = new int[filas][columnas];
		int[][] b = new int[columnas][filas];
		Random random =new Random();
		
		comMatriz(a, filas, columnas, random);
		comMatriz(b, columnas, filas, random);

		System.out.println();
		System.out.println("Matriz A");
		System.out.println();
		mostrarMatriz(a);
		
		System.out.println();
		System.out.println("Matriz B");
		System.out.println();
		mostrarMatriz(b);
		System.out.println();
		
		Thread[] hilos = new Thread[filas];
		for (int i = 0;i<filas;i++) {
			hilos[i] = new Thread(new HiloCambio(i, a, b));
			hilos[i].start();
		}
		
		for (int i =0;i < hilos.length;i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		
		System.out.println();
		System.out.println("Matriz A despues");
		System.out.println();
		mostrarMatriz(a);
		
		System.out.println();
		System.out.println("Matriz B despues");
		System.out.println();
		mostrarMatriz(b);
		System.out.println();
	}
	
}
		
