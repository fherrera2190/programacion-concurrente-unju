
public class Main {

	public static void main(String[] args) {

		Cadrilatero cuadrilatero = new Cadrilatero(5, 5, 5, 5);
		System.out.println(cuadrilatero.area());
		System.out.println(cuadrilatero.perimetro());

		Circulo circulo = new Circulo(5);
		System.out.println(circulo.area());
		System.out.println(circulo.perimetro());

	}

}
