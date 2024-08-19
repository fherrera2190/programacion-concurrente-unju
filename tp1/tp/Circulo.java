public class Circulo extends Forma {

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {

        return Math.PI * Math.pow(this.radio, 2);
    }

    @Override
    public double perimetro() {

        return 2 * Math.PI * this.radio;
    }

}
