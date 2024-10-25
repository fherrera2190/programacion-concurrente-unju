package punto2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Hilo implements Runnable {

	double x;
	double y;
	public Hilo(double x) {
		
		this.x = x;
	}

	public void run() {
		y = this.funcion(this.x);
		String escribir ="(x:"+x + ", y: "+ y +")\n";
		escribirResultado("Puntos.txt",escribir);
	}

	public double funcion(double x) {
        return 1 / (1 + Math.pow(x, 2));
    }
	
	public void escribirResultado(String path, String text) {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {

			writer.write(text);
			System.out.println(text);
		} catch (IOException e) {

			System.out.println("Error" + e.getMessage());
		}
		
	}
}
