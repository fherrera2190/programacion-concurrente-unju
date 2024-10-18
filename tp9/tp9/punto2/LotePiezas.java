package punto2;

public class LotePiezas extends Thread {
	int idLotePiezas;
	PlantaEnsamblado plantaDeEmsamblado;

	public LotePiezas(int idLotePiezas, PlantaEnsamblado plantaDeEmsamblado) {
		this.idLotePiezas = idLotePiezas;
		this.plantaDeEmsamblado = plantaDeEmsamblado;

	}

	public void run() {

		this.plantaDeEmsamblado.obtenerMesa(this.idLotePiezas);

	}
}
