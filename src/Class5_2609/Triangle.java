package Class5_2609;

public final class Triangle extends Figure {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double x, double y, double a, double b, double c) {
        super(x, y);
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
