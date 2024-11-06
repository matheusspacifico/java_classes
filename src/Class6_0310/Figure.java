package Class6_0310;

public abstract sealed class Figure permits Circle, Rectangle, Triangle {
    public abstract double Area();
}
