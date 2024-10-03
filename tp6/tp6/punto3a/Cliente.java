package punto3a;

public class Cliente implements Runnable {

	private EstacionPeaje estacionPeaje;
	private int id;

	public Cliente(int cliente, EstacionPeaje estacionPeaje) {
		this.id = cliente;
		this.estacionPeaje = estacionPeaje;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.estacionPeaje.PagarPeaje(this.id);

	}

}
