package punto3b;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EstacionPeaje estacionPeaje = new EstacionPeaje();

		for (int cliente = 1; cliente <= 50; cliente++) {
			Thread hiloIniciarCliente = new Thread(new Cliente(cliente, estacionPeaje));
			hiloIniciarCliente.start();
		}

		try {
			Thread.sleep(15000);
			estacionPeaje.HabilitarCabina3();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

	}

}
