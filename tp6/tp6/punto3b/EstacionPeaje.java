package punto3b;

import java.util.Random;

public class EstacionPeaje {

	Cabina[] cabinas;

	public EstacionPeaje() {
		this.cabinas = new Cabina[3];
		
		for (int i = 0; i < cabinas.length; i++) {
			if(i==2) {				
				cabinas[i]=new Cabina("Cabina "+(i+1),0);
			}else {
				cabinas[i]=new Cabina("Cabina "+(i+1),1);
			}
			
		}
		

	}

	public void PagarPeaje(int idCliente) {
		
		Random random = new Random();
        int cabina = random.nextInt(3);
        
        this.cabinas[cabina].UsarCabina(idCliente);
        

	}

	public void HabilitarCabina3() {
		this.cabinas[2].HabilitarCabina();

	}

}
