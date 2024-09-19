package tp4.tp4.punto3;


public class Principal {
    public static void main(String[] args) {
        Zoologico zoologico = new Zoologico();
        
        
        //Generar clientes
        int i = 1;
        while(true) {  
        	System.out.println("Cliente "+i+" llegando");
            Cliente cliente = new Cliente(i, zoologico);
            cliente.start();

            try {
                Thread.sleep(zoologico.getRandomInt(100, 201));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            i++;
        }
    }
}
