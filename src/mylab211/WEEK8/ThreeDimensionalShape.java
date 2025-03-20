package mylab211.WEEK8;

abstract class ThreeDimensionalShape extends Shape {
    abstract double getArea();
    abstract double getVolume();

    @Override
    String getType() {return "Three-Dimensional"; };
}
