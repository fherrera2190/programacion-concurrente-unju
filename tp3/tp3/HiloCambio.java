public class HiloCambio extends Thread{
	private int fila;
	private int[][] a;
	private int[][] b;
	
	
	public HiloCambio (int i, int[][] a, int[][] b) {
		this.fila= i;
		this.a = a;
		this.b = b;
	}
	
	@Override
	public void run() {
		
		//System.out.println("Empezo fila :"+ fila);
		for(int j = 0; j<a[0].length;j++) {
			if (a[fila][j] != b[j][fila]) {
				int aux = a[fila][j];
				a[fila][j] = b[j][fila];
				b[j][fila] = aux;
			}
		}
		//System.out.println("Termino fila :"+ fila);
	}
}
