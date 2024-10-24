package parcial2023pt1;

import java.util.concurrent.Semaphore;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaphore semA = new Semaphore(1);
		Semaphore semB = new Semaphore(0);
		Semaphore semC = new Semaphore(0);

		Proceso procesoA = new Proceso("A", semA, semB);
		Proceso procesoB = new Proceso("B", semB, semC);
		Proceso procesoC = new Proceso("C", semC, semA);
		procesoA.start();
		procesoB.start();
		procesoC.start();
	}

}
