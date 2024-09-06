public class Ejercicio6 {
    public static void main(String[] args) {
        int matrizA[][] = new int[10][20];
        int matrizB[][] = new int[20][10];

        cargarMatriz(matrizA);
        cargarMatriz(matrizB);
        mostrarMatriz(matrizA);
        mostrarMatriz(matrizB);

    }

    public static void cargarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = (int) (Math.random() * 100);
            }
        }
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
