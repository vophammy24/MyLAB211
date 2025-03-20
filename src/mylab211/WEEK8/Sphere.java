package mylab211.WEEK8;

public class Sphere extends ThreeDimensionalShape {
    double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * 4 * radius * radius;
    }

    @Override
    double getVolume() {
        return (4 * Math.PI * Math.pow(radius, 3))/ 3;
    }

    @Override
    public String toString() {
        return "Sphere: " + "radius = " + radius;
    }
}
