package punto2;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tiempoDeTrabajo = 400;
		PlantaEnsamblado plantaDeEmsamblado = new PlantaEnsamblado(tiempoDeTrabajo);

		for (int i = 0; i < 100; i++) {
			LotePiezas lotePiezas = new LotePiezas(i+1, plantaDeEmsamblado);
			lotePiezas.start();
		}
	}

}
