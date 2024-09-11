package bloque11;

public class Principal extends Thread {
    private int id;

    public Principal(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
    	System.out.println("Inicio Hilo principal");
        /*Principal h1= new Principal(1);
        Principal h2= new Principal(2);

        Principal h3= new Principal(3);

        h1.start();
        h2.start();
        h3.start();*/

        //System.out.println("Hola");
        
        
        HiloPadre hp1 = new HiloPadre();
        hp1.start();
        System.out.println("Termino Hilo principal");
       

    }

    public void run(){

        System.out.println("Soy hilo "+this.id);
    }
}
