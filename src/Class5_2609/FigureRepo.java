package Class5_2609;

public class FigureRepo {
    public static Circle createCircle(double x, double y, double radius){
        return new Circle(x, y, radius);
    }

    public static Rectangle createRectangle(double x, double y, double width, double length){
        return new Rectangle(x, y, width, length);
    }

    public static Triangle createTriangle(double x, double y, double a, double b, double c){
        return new Triangle(x, y, a, b, c);
    }
}
