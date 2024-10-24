package punto2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClaseMetodos claseMetodos = new ClaseMetodos();
		Runnable task1=()->{claseMetodos.task1();};
		Runnable task2=()->{claseMetodos.task2();};
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);

		ses.scheduleAtFixedRate(task1, 2, 2, TimeUnit.SECONDS);
		ses.scheduleAtFixedRate(task2, 2,2, TimeUnit.SECONDS);

	}

}
