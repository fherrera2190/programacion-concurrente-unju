package tp4.tp4.punto3;

class Cliente extends Thread {
    private final int id;
    private final Zoologico zoologico;

    public Cliente(int id, Zoologico zoologico) {
        this.id = id;
        this.zoologico = zoologico;
    }

    public void run() {
        try {
            //Entrada
            Thread.sleep(zoologico.getRandomInt(100, 201));
            zoologico.hacerFilaParaEntrar(id);

            //Recorriendo zoologico
            System.out.println("Cliente " + id + " esta recorriendo el zoologico.");
            Thread.sleep(zoologico.getRandomInt(400, 701));
            System.out.println("Cliente " + id + " termino de recorrer zoologico.");
            //Salida
            zoologico.hacerFilaParaSalir(id);
            System.out.println("Cliente " + id + " salio del zoologico.");
        } catch (InterruptedException e) {
        	// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

