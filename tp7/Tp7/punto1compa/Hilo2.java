package punto1compa;

import java.util.concurrent.Semaphore;

public class Hilo2 extends Thread {
    Semaphore semaforo1;
    Semaphore semaforo2;
    Contador x;
    public Hilo2(Semaphore semaforo1, Semaphore semaforo2, Contador x) {
        this.semaforo1 = semaforo1;
        this.semaforo2 = semaforo2;
        this.x = x;
    }

    public void run() {
        try {
            semaforo1.acquire();
            x.setX(x.getX() * x.getX());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo1.release();
        }
    }
}

