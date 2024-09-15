package punto2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Panaderia {
	private final Queue<Integer> colaClientes = new LinkedList<>();
	private final Queue<Integer> bandejaFacturas = new LinkedList<>();
	private final Queue<Integer> bandejaBizcochos = new LinkedList<>();

	private final Random random = new Random();
	private Horno hornoFacturas;
	private Horno hornoBizcochos;

	public Panaderia() {
		this.hornoFacturas = new Horno(getRandomInt(1000, 1300), "factura",bandejaFacturas);
		this.hornoBizcochos = new Horno(getRandomInt(400, 600), "bizcocho",bandejaBizcochos);
		this.hornoBizcochos.start();
		this.hornoFacturas.start();

	}

	public synchronized void comprar(int id) {
		colaClientes.add(id);
        System.out.println("Llego cliente: "+id);
		try {
			while (colaClientes.peek() != id && this.bandejaFacturas.isEmpty() && this.bandejaBizcochos.isEmpty()) {
				wait();
			}
			this.bandejaBizcochos.poll();
			this.bandejaFacturas.poll();
			colaClientes.poll();
			System.out.println("Cliente "+ id +" saco una factura y un bizcocho y se va para la caja");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		notifyAll();
	}

	public int getRandomInt(int min, int max) {
		return random.nextInt(max - min) + min;
	}

}
