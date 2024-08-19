
public class CuentaSueldo extends CuentaBancaria  {
	int legajo;
	String institucion;
	String beneficios;
	long cbu;
	double tope;

	public CuentaSueldo() {

	}

	public CuentaSueldo(long dni, double saldoActual, double interesAnual, int legajo, String institucion,
			String beneficios, long cbu) {
		super(dni, saldoActual, interesAnual);
		this.legajo = legajo;
		this.institucion = institucion;
		this.beneficios = beneficios;
		this.cbu = cbu;
	}

	public CuentaSueldo(long dni, double saldoActual, double interesAnual,long cbu,double tope) {
		super(dni, saldoActual, interesAnual);
		this.cbu = cbu;
		this.tope = tope;
	}

	@Override
	public void retirar(double monto) {

		if ((monto <= this.saldoActual) && (monto <= tope)) {
			this.retirar(monto);
			System.out.println("Transaccion exitosa");
		} else if (monto > tope) {
			System.out.println("No puede realizar la acción por que el monto supera su tope diario");
		} else {
			System.out.println("Saldo insuficiente.");
		}
	}
	
	public void transferir(double monto, String alias) {
		if (monto <= this.saldoActual) {
			this.retirar(monto);
			System.out.println("Transferencia realizada con exito, su nuevo saldo es: " + this.saldoActual);
		} else {
			System.out.println("Saldo insuficiente.");
		}
	}
	public void transferir(double monto, long cbuDestino) {
		if (monto <= this.saldoActual) {
			this.retirar(monto);
			System.out.println("Transferencia realizada con exito, su nuevo saldo es: " + this.saldoActual);
		} else {
			System.out.println("Saldo insuficiente.");
		}
	}


}
