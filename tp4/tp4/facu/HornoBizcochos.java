package tp4.tp4.facu;


import java.util.List;
import java.util.Random;

public class HornoBizcochos extends Thread{
	
	private List<String> bizcochos;
	private Random ran;
	
	public HornoBizcochos(List<String> bizcochos, Random ran) {
		this.bizcochos=bizcochos;
		this.ran=ran;
	}

	@Override
	public void run() {
		
		while(true) {
			try {
				sleep(ran.nextInt(600 - 400 + 1) + 400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(bizcochos) {
				bizcochos.add("X");
				System.out.println("Se hizo un bizcocho");
				bizcochos.notify();
			}
		}
		
	}

}
