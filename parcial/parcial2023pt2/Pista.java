package parcial2023pt2;

import java.util.concurrent.Semaphore;

public class Pista {
	Semaphore capacidad;
	String nombrePista;
	
	public Pista(String nombrePista, int capacidad) {
		this.nombrePista = nombrePista;
		this.capacidad = new Semaphore(capacidad);
	}
	
	public void utilizarPista(String nombreAspirante) {
		try {
			this.capacidad.acquire();
			System.out.println(nombreAspirante +" entro a la "+ this.nombrePista);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void abandonarPista(String nombreAspirante) {
		System.out.println(nombreAspirante +" abandona la "+ this.nombrePista);
		this.capacidad.release();
	}
	
}
