package punto4;

public class CalculoConcurrente extends Operaciones implements Runnable {

	private int[][] matrizA, matrizB;
	private double[][] matrizC;
	private int posCi, posCj;

	public CalculoConcurrente(int i, int j, int[][] matrizA, int[][] matrizB, double[][] matrizC) {
		this.matrizA = matrizA;
		this.matrizB = matrizB;
		this.matrizC = matrizC;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizB[0].length; j++) {
            	//matrizC[i][j] = 0;
            	int root = 0;
                for (int k = 0; k < matrizA[0].length; k++) {
                	root += matrizA[i][k] * matrizB[k][j];
                }
                matrizC[i][j]=sumRootN(root);
            }
        }
	}

}
