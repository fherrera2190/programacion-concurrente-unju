package tp4.tp4.punto2;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Panaderia panaderia = new Panaderia();
		
		//Creador de Clientes

        int i = 1;
        while(true) {  

            try {
                Thread.sleep(panaderia.getRandomInt(800, 1501));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Cliente cliente = new Cliente(i, panaderia);
            cliente.start();
            i++;
        }
	}

}
