package Class6_0310;

public final class Triangle extends Figure {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double Area(){
        double s = semiPerimeter(a, b, c);
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    private double semiPerimeter(double a, double b, double c){
        return (a + b + c) / 2;
    }
}
