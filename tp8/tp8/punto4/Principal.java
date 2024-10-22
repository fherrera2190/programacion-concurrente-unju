package punto4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskCheckFolder taskCheckFolder = new TaskCheckFolder();
		taskCheckFolder.showList();
		Runnable task = () -> {
			taskCheckFolder.checkFolder();
		};

		ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

		ses.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);

	}

}
