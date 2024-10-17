package punto1;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tirada = 1;
		int[] resultados = new int[6];
		while (true) {
			try {
				System.out.println("Tirada: " + tirada);
				for (int i = 0; i < 6; i++) {
					Dado dado = new Dado(resultados, i);
					dado.start();

				}

				Thread.sleep(200);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < 6; i++) {
				System.out.print(resultados[i] + " ");
			}

			System.out.print(verParidad(resultados) + " ");
			System.out.print(verEscalera(resultados));
			System.out.println();
			tirada++;
		}

	}

	public static String verParidad(int[] resultados) {
		int suma = 0;
		for (int i = 0; i < 6; i++) {
			suma += resultados[i];
		}
		if (suma % 2 == 0) {
			return " | total: "+suma +" Es par";
		} else {
			return " | total: "+suma +" Es impar";
		}

	}

	public static String verEscalera(int[] resultados) {
		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				if (resultados[i] == resultados[j]) {
					return "";
				}
			}

		}
		return "SE HA PRODUCIDO UNA ESCALERA";
	}

}
