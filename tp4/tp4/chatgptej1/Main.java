package chatgptej1;
class Bandeja {
    private boolean disponible = false;

    // Método para el consumidor
    public synchronized void consumir() {
        while (!disponible) {
            try {
                System.out.println(Thread.currentThread().getName() + " esperando...");
                wait();  // El consumidor espera a que el producto esté disponible
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " consumió el producto.");
        disponible = false;  // El producto fue consumido
        notify();  // Notifica al productor que puede producir más
    }

    // Método para el productor
    public synchronized void producir() {
        while (disponible) {
            try {
                wait();  // El productor espera a que se consuma el producto
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        disponible = true;  // El producto ahora está disponible
        System.out.println(Thread.currentThread().getName() + " produjo un producto.");
        notify();  // Notifica al consumidor que puede consumir
    }
}

public class Main {
    public static void main(String[] args) {
        Bandeja bandeja = new Bandeja();

        // Hilo del consumidor
        Thread consumidor = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    bandeja.consumir();
                }
            }
        }, "Consumidor");

        // Hilo del productor
        Thread productor = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    bandeja.producir();
                }
            }
        }, "Productor");

        consumidor.start();
        productor.start();
    }
}
