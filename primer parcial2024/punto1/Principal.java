package punto1;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Caballo[] caballos = new Caballo[7];

		for (int i = 0; i < 7; i++) {
			caballos[i] = new Caballo("Caballo " + (i + 1));
		}

		for (int i = 1; i <= 5; i++) {

			Thread[] hilos = new Thread[7];

			for (int j = 0; j < 7; j++) {
				hilos[j] = new Thread(caballos[j]);
				hilos[j].start();
			}

			for (int j = 0; j < 7; j++) {
				try {
					hilos[j].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			System.out.println("Vuelta " + i);
			verPosiciones(caballos);
			verGanadorPorVuelta(caballos, i);
		}

		verGanador(caballos);
	}

	static void verPosiciones(Caballo[] caballos) {
		for (Caballo caballo : caballos) {
			System.out.println(caballo.caballoId + " tiempo: " + caballo.tiempoVueltaParcial);
		}
	}

	static void verGanador(Caballo[] caballos) {

		Caballo min = caballos[0];
		for (Caballo caballo : caballos) {
			if (caballo.tiempoTotal < min.tiempoTotal) {
				min = caballo;
			}
		}

		System.out.println("El caballo ganador fue el " + min.caballoId + " con un tiempo total de " + min.tiempoTotal);
	}

	static void verGanadorPorVuelta(Caballo[] caballos, int vuelta) {

		Caballo min = caballos[0];
		for (Caballo caballo : caballos) {
			if (caballo.tiempoVueltaParcial < min.tiempoVueltaParcial) {
				min = caballo;
			}
		}

		System.out.println("El caballo ganador de la vuelta " + vuelta + " fue el " + min.caballoId
				+ " con un tiempo de " + min.tiempoVueltaParcial);
	}

}
