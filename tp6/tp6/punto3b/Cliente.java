package punto3b;

public class Cliente implements Runnable {

	private EstacionPeaje estacionPeaje;
	private int idCliente;

	public Cliente(int idCliente, EstacionPeaje estacionPeaje) {
		this.idCliente = idCliente;
		this.estacionPeaje = estacionPeaje;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.estacionPeaje.PagarPeaje(this.idCliente);

	}

}
