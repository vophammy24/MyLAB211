package mylab211.WEEK8;

abstract class TwoDimensionalShape extends Shape {
    abstract double getArea();

    @Override
    String getType() {return "Two-Dimensional"; }
}
