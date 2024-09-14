package prueba1;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> fila = new ArrayList<>();
		for (int i = 1; i < 11; i++) {
			fila.addLast(i);
		}
		
		
		Cajero cajero = new Cajero(fila);
		
		cajero.start();
/*		System.out.println(fila.toString());
		System.out.println(fila.getFirst());
		System.out.println(fila.getLast());
		System.out.println(fila.toString());
		
		System.out.println(fila.removeFirst());
		System.out.println(fila.toString());*/
	}

}
