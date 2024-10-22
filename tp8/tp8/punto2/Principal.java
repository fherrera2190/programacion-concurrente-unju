package punto2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable task1=()->{ClaseMetodos.task1();};
		Runnable task2=()->{ClaseMetodos.task2();};
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);

		ses.scheduleAtFixedRate(task1, 2, 2, TimeUnit.SECONDS);
		ses.scheduleAtFixedRate(task2, 2, 2, TimeUnit.SECONDS);

	}

}
