package Class6_0310;

public final class Circle extends Figure {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double Area(){
        return Math.PI * Math.pow(radius, 2);
    }
}
