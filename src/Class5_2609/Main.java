package Class5_2609;

import static Class5_2609.FigureRepo.*;

public class Main {
    public static void main(String[] args) {
        Circle circle = createCircle(0, 0, 30);
        Rectangle rectangle = createRectangle(0, 0, 30, 20);
        Triangle triangle = createTriangle(0, 0, 30, 45, 50);

        System.out.println("Circle area: " + circle.Area());
        System.out.println("Rectangle area: " + rectangle.Area());
        System.out.println("Triangle area: " + triangle.Area());
    }
}
