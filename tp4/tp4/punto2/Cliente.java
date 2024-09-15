package punto2;

import java.util.Queue;

class Cliente extends Thread {
    private  int id;
    private  Panaderia panaderia;
    
    public Cliente(int id, Panaderia panaderia) {
        this.id = id;
        this.panaderia = panaderia;
    }

    public void run() {
        this.panaderia.comprar(this.id);
        try {
        	System.out.println("Cliente "+ this.id+" pagando");
			Thread.sleep(this.panaderia.getRandomInt(200, 401));
			System.out.println("Cliente "+ this.id+" saliendo");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

