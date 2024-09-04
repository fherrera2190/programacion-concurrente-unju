import java.time.Duration;
import java.time.Instant;

public class Ejercicio5 {
    public static void main(String[] args) {

        //Sin Hilos
        // Instant start = Instant.now();
        // for (int i = 1; i <= 50; i++) {

        // System.out.println(SumRootN(i));
        // }
        // Instant end = Instant.now();

        // Duration timeElapsed = Duration.between(start, end);

        // System.out.println("Tiempo de ejecución: " + timeElapsed.toMillis() + " milisegundos");

        // Con HILOS
        for (int i = 1; i <= 50; i++) {
            new Thread(new HiloSumRootN("Hilo "+i, i)).start();
        }

    }

    public static double SumRootN(int root) {

        double result = 0;
        for (int i = 0; i < 10000000; i++) {
            result += Math.exp(Math.log(i) / root);
        }
        return result;
    }
}

class HiloSumRootN extends Thread {
    String name;
    int root;

    HiloSumRootN(String name, int root) {
        this.name = name;
        this.root = root;
    }

    public void run() {
        Instant start = Instant.now();
        double result = Ejercicio5.SumRootN(this.root);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println(this.name+" Resultado: "+result+" Tiempo de ejecución: " + timeElapsed.toMillis() + " milisegundos");

    }

}