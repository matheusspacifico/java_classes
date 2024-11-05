package Class5_2609;

public final class Rectangle extends Figure {
    private final double width;
    private final double length;

    public Rectangle(double x, double y, double width, double length) {
        super(x, y);
        this.width = width;
        this.length = length;
    }

    public double Area(){
        return width * length;
    }
}
