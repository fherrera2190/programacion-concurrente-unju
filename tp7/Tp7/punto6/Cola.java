package punto6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

public class Cola {
	ArrayBlockingQueue<String> cola;
	int nroSillas;
	Semaphore permisoAcceso;

	public Cola(int nroSillas) {
		this.cola = new ArrayBlockingQueue<String>(nroSillas);
		this.nroSillas = nroSillas;
		this.permisoAcceso = new Semaphore(1);
	}

	public void agregarCliente(String cliente) {
		try {
			this.permisoAcceso.acquire();
			String nombreCliente =  cliente;

			if (this.cola.offer(nombreCliente)) {
				System.out.println(nombreCliente + " tomo asiento");
			} else {
				System.out.println(nombreCliente + " se fue");
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			this.permisoAcceso.release();
		}
	}

	public String atenderCliente() {
		String clienteAtendido = "";
		try {
			this.permisoAcceso.acquire();
			clienteAtendido = this.cola.take();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			this.permisoAcceso.release();
		}
		return clienteAtendido;
	}

	public boolean checkearCola() {
		int estado = 0;
		try {
			this.permisoAcceso.acquire();
			estado = this.cola.remainingCapacity();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			this.permisoAcceso.release();
		}

		if (estado == this.nroSillas) {
			//No hay nadie
			return false;
		}else {
			//Hay cliente
			return true;
		}
	}

}
