package tp4.tp4.facu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Principal {
	
	public static void main(String[] arg) {
		
		Random ran = new Random();
		
		List<String> facturas = new ArrayList<String>();
		List<String> bizcochos = new ArrayList<String>();
		
		HornoFacturas hornoFacturas = new HornoFacturas(facturas, ran);
		HornoBizcochos hornoBizcochos = new HornoBizcochos(bizcochos, ran);
 		
		hornoFacturas.start();
		hornoBizcochos.start();
		
		for(int i=0;i<20;i++) {
			Cliente cliente = new Cliente(i, bizcochos, facturas);
			cliente.start();
		}
	}
	
}
