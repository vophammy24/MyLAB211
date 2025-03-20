package mylab211.WEEK8;

public class Tetrahedron extends ThreeDimensionalShape {
    double lenght;

    public Tetrahedron(double lenght) {
        this.lenght = lenght;
    }

    @Override
    double getArea() {
        return Math.sqrt(3) * lenght * lenght;
    }

    @Override
    double getVolume() {
        return (Math.sqrt(2) * Math.pow(lenght, 3))/ 12;
    }    

    @Override
    public String toString() {
        return "Tetrahedron: " + "lenght = " + lenght;
    }
}
