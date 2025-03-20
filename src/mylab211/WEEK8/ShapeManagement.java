package mylab211.WEEK8;


public class ShapeManagement {
    public static void main(String[] args) {
        Shape[] shapes = {  new Circle(3),
                            new Square(2),
                            new Triangle(3, 4),
                            new Sphere(2.3),
                            new Cube(6),
                            new Tetrahedron(5)};
        
        for(Shape shape: shapes){
            System.out.println(shape);
            System.out.println("Type: " + shape.getType());
            
            if(shape instanceof TwoDimensionalShape){
                System.out.println("Area: " + (((TwoDimensionalShape) shape).getArea()));
            }
            if(shape instanceof ThreeDimensionalShape){
                System.out.println("Area: " + ((ThreeDimensionalShape) shape).getArea());
                System.out.println("Volume: " + ((ThreeDimensionalShape) shape).getVolume());
            }
            System.out.println();
        }
    }
}
