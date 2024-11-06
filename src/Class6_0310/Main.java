package Class6_0310;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FigureRepo r = new FigureRepo();

        for (int i = 0; i < 50; i++) {
            r.createCircle(i);
            r.createRectangle(i, i);
            r.createTriangle(i, i, i);
        }

        List<Figure> figures = r.getFigures();
        double areaSum = 0;

        for (Figure f : figures) {
            areaSum += f.Area();
        }

        System.out.println("Sum of every area: " + areaSum);
    }
}
