package Class5_2609;

public abstract sealed class Figure permits Circle, Rectangle, Triangle {
    private final double x;
    private final double y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract double Area();
}
