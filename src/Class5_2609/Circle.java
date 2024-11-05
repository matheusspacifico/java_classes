package Class5_2609;

public final class Circle extends Figure {
    private final double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    public double Area(){
        return Math.PI * Math.pow(radius, 2);
    }
}
