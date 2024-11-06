package Class6_0310;

import java.util.ArrayList;
import java.util.List;

public class FigureRepo {
    private final List<Figure> figures;

    public FigureRepo() {
        this.figures = new ArrayList<>();
    }

    public void createCircle(double radius) {
        figures.add(new Circle(radius));
    }

    public void createRectangle(double width, double length) {
        figures.add(new Rectangle(width, length));
    }

    public void createTriangle(double a, double b, double c) {
        figures.add(new Triangle(a, b, c));
    }

    public List<Figure> getFigures(){
        return List.copyOf(figures);
    }
}
