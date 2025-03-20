package mylab211.WEEK8;

public class Circle extends TwoDimensionalShape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle: " + "radius = " + radius;
    }
}
