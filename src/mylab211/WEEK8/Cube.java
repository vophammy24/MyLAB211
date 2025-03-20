package mylab211.WEEK8;

public class Cube extends ThreeDimensionalShape {
    double lenght;

    public Cube(double lenght) {
        this.lenght = lenght;
    }

    @Override
    double getArea() {
        return 6 * lenght * lenght;
    }

    @Override
    double getVolume() {
        return Math.pow(lenght, 3);
    }

    @Override
    public String toString() {
        return "Cube: " + "lenght = " + lenght;
    }
    
    
}
