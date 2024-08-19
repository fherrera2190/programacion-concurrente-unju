
public class CuentaBancaria implements OperacionesImportantes, OperacionesComunes {
	static long nroCuenta = 100001;
	long dni;
	double saldoActual;
	double interesAnual;


	public CuentaBancaria(){

	}

	public CuentaBancaria(long dni, double saldoActual, double interesAnual) {
		this.dni = dni;
		this.saldoActual = saldoActual;
		this.interesAnual = interesAnual;
	}

	public void actualizarSaldo() {
		this.saldoActual += this.saldoActual * this.interesAnual / 365;
	}

	public void ingresar(double monto) {
		this.saldoActual += monto;
	}

	public void retirar(double monto) {
		if (this.saldoActual > monto) {
			this.saldoActual -= monto;
		} else {
			System.out.println("No posee saldo suficiente para realizar esta extracción");
		}
	}

	public void mostrarCuenta() {
		System.out.println(nroCuenta);
		System.out.println(this.dni);
		System.out.println(this.saldoActual);
	}

	@Override
	public void pagarServicio() {
	
	}

	@Override
	public void CambiarAlias() {

	}

	@Override
	public void transferenciaAltoMonto(double monto) {

	}
}
