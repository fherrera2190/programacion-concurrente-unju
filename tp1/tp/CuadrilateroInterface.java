

public class CuadrilateroInterface implements FormaInterface {

    private double lado1;
    private double lado2;
    private double lado3;
    private double lado4;

    public CuadrilateroInterface(double lado1, double lado2, double lado3, double lado4) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.lado4 = lado4;
    }

    @Override
    public double area() {
        return this.lado1 * this.lado2;
    }

    @Override
    public double perimetro() {
        return this.lado1 + this.lado2 + this.lado3 + this.lado4;
    }

}
