package bloque13;


public class MainBloque13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		principal[] vec = new principal[1000];
		for (int i = 0; i < vec.length; i++) {

			vec[i] = new principal();

			vec[i].start();
		}
		

			try {
				for (int i = 0; i < vec.length; i++) {
				vec[i].join();
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		System.out.println(principal.cont);
	}

}
