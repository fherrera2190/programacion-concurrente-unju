package tp4.tp4.punto3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
class Zoologico {
    private boolean pasilloOcupado = false; 
    private final Queue<Integer> colaEntrada = new LinkedList<>(); 
    private final Queue<Integer> colaSalida = new LinkedList<>();   
    private final Random random = new Random();  

    public synchronized void hacerFilaParaEntrar(int id) {
    	
    	
        colaEntrada.add(id);  
        System.out.println("Cliente " + id + " esta en la fila para entrar.");

        try {
        	while (pasilloOcupado || colaEntrada.peek() != id) {
        		wait();  
        	}
        	
        	pasilloOcupado = true;  
        	colaEntrada.poll(); 
        	System.out.println("Cliente " + id + " esta entrando por el pasillo.");
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

        
        pasilloOcupado = false;  
        notifyAll(); 
    }

    public synchronized void hacerFilaParaSalir(int id) {
        colaSalida.add(id); 
        System.out.println("Cliente " + id + " esta en la fila para salir.");

        try {
        	while (pasilloOcupado || colaSalida.peek() != id) {
        		wait();  
        	}
        	
        	pasilloOcupado = true; 
        	colaSalida.poll();  
        	System.out.println("Cliente " + id + " esta saliendo por el pasillo.");
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  


        pasilloOcupado = false; 
        notifyAll(); 
    }


    public int getRandomInt(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
