package bloque21;

import java.util.Random;

public class Bloque21 extends Thread {
	
	
	private static int tam =8;
	private static int[] vec = new int[tam];
	
	private int ini,fin;
	
	public Bloque21(int ini,int fin) {
		this.ini=ini;
		this.fin =fin;
	}
	
	public void run() {
		for (int i = ini; i < fin; i++) {
			vec[i]*=10;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random(System.nanoTime());
		for (int i = 0; i < vec.length; i++) {
			vec[i]= rand.nextInt(10);
		}
		
		Bloque21 h1 = new Bloque21(0,4);
		Bloque21 h2= new Bloque21(4,8);
		
		h1.start();
		h2.start();
		
		try {
			h1.join();
			h2.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		for (int i = 0; i < vec.length; i++) {
			System.out.print(vec[i]+" ");
		}

	}

}
