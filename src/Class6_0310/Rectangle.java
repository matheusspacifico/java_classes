package Class6_0310;

public final class Rectangle extends Figure {
    private final double width;
    private final double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double Area(){
        return width * length;
    }
}
