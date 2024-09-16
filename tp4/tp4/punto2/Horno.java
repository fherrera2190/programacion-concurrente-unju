package tp4.tp4.punto2;

import java.util.Queue;

public class Horno extends Thread {

	private int tiempo;
	private String tipo;
	private Queue<Integer> bandeja;
    public Horno(int tiempo,String tipo,Queue<Integer> bandeja){
    	this.tiempo=tiempo;
    	this.tipo = tipo;
    	this.bandeja= bandeja;
    }
    public void run(){
        while(true){
            try {
				Thread.sleep(this.tiempo);
				synchronized (bandeja) {
					bandeja.add(1);
				}
				System.out.println("Producción de: "+ this.tipo+ " en total hay : "+ bandeja.size());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}