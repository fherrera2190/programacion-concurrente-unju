public class Ejercicio6 {
    public static void main(String[] args) {
        int matrizA[][] = new int[5][10];
        int matrizB[][] = new int[10][5];

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

    public static void intercambiarValores(int[][] matriz1, int[][] matriz2) {
        for (int[] fila : matriz1) {
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
    }}

// public Class Hilo{
// }