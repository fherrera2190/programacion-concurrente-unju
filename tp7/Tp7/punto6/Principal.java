package punto6;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nroDeSillas=5;
		
		Cola cola = new Cola(nroDeSillas);
		
		Barbero barbero = new Barbero(cola);
		barbero.start();
		
		GenerarClientes generarClientes= new GenerarClientes(cola,barbero);
		generarClientes.start();

	}

}
