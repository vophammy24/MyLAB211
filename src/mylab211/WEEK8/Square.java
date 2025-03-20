package mylab211.WEEK8;

public class Square extends TwoDimensionalShape {
    double lenght;

    public Square(double lenght) {
        this.lenght = lenght;
    }

    @Override
    double getArea() {
        return lenght * lenght;
    }  

    @Override
    public String toString() {
        return "Square: " + "lenght = " + lenght;
    }
    
}
