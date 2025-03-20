package mylab211.WEEK8;

public class Triangle extends TwoDimensionalShape {
    double base;
    double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double getArea() {
        return (base * height) / 2;
    }    

    @Override
    public String toString() {
        return "Triangle: " + "base = " + base + ", height = " + height;
    }
    
}
