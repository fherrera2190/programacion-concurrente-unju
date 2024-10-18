package punto2;

import java.util.concurrent.Semaphore;

public class PlantaEnsamblado {
	Semaphore mesasDeTrabajo;
	Semaphore pinzas;
	Semaphore sargentos;
	Semaphore destornilladores;
	int tiempoDeTrabajo;

	public PlantaEnsamblado(int tiempoDeTrabajo) {
		this.mesasDeTrabajo = new Semaphore(3);
		this.pinzas = new Semaphore(4);
		this.sargentos = new Semaphore(4);
		this.destornilladores = new Semaphore(2);
		this.tiempoDeTrabajo = tiempoDeTrabajo;

	}

	public void Fase1(int idLotePiezas) {
		try {
			System.out.println("Lote: " + idLotePiezas + " Entrando a la Fase1");
			this.destornilladores.acquire();
			this.pinzas.acquire();
			Thread.sleep(this.tiempoDeTrabajo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.pinzas.release();
			this.destornilladores.release();
			System.out.println("Lote: " + idLotePiezas + " Saliendo Fase1");
		}

	}

	public void Fase2(int idLotePiezas) {
		try {
			System.out.println("Lote: " + idLotePiezas + " Entrando a la Fase2");
			this.sargentos.acquire();
			this.sargentos.acquire();
			Thread.sleep(this.tiempoDeTrabajo / 2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.sargentos.release();
			this.sargentos.release();
			System.out.println("Lote: " + idLotePiezas + " Saliendo Fase2");
		}

	}

	public void Fase3(int idLotePiezas) {
		try {

			System.out.println("Lote: " + idLotePiezas + " Entrando a la Fase3");
			this.pinzas.acquire();
			this.pinzas.acquire();
			Thread.sleep(this.tiempoDeTrabajo * 2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.pinzas.release();
			this.pinzas.release();
			System.out.println("Lote: " + idLotePiezas + " Saliendo Fase3, emsamblado terminado!");
			
		}

	}

	public void obtenerMesa(int idLotePiezas) {
		try {
			this.mesasDeTrabajo.acquire();
			this.Fase1(idLotePiezas);
			this.Fase2(idLotePiezas);
			this.Fase3(idLotePiezas);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			this.mesasDeTrabajo.release();
		}
		this.Fase1(idLotePiezas);

	}

}
