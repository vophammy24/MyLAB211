/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mylab211.WEEK2;

import java.util.Scanner;

/**
 *
 * @author MY
 */
    abstract class Shape{
             public abstract double getPerimeter();
             public abstract double getArea();
             public abstract void printResult();
    }

    class Rectangle extends Shape{
        private double width;
        private double length;

        public Rectangle(double width, double length) {
            this.width = width;
            this.length = length;
        }

        @Override
        public double getPerimeter() {
            return 2 * (width + length);
        }

        @Override
        public double getArea() {
            return width * length;
        }

        @Override
        public void printResult() {
            System.out.println("-----Rectangle-----");
            System.out.printf("Width: %.1f\nLength: %.1f\nArea: %.1f\nPerimeter: %.1f\n", width, length, getArea(), getPerimeter());
        }
    }
    class Circle extends Shape{
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }
          

        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public double getArea() {
            return radius * radius * Math.PI;
        }

        @Override
        public void printResult() {
            System.out.println("-----Circle-----");
            System.out.printf("Radius: %.1f\nArea: %.13f\nPerimeter: %.14f\n", radius, getArea(), getPerimeter());
        }
    }
        
    class Triangle extends Shape{
        private double sideA;
        private double sideB;
        private double sideC;

        public Triangle(double sideA, double sideB, double sideC) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }

        @Override
        public double getPerimeter() {
            return sideA + sideB + sideC;
        }

        @Override
        public double getArea() {
            double p = getPerimeter() / 2;
            return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        }

        @Override
        public void printResult() {
            System.out.println("-----Triangle-----");
            System.out.printf("Side A: %.1f\nSide B: %.1f\nSide C: %.1f\nArea: %.2f\nPerimeter: %.1f\n", sideA, sideB, sideC, getArea(), getPerimeter());
        }
    }

public class CalculatorShapeProgram {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=====Calculator Shape Program=====");
        
        System.out.println("Please input side width of Rectangle:");
        double width = scanner.nextDouble();
        System.out.println("Please input length of Rectangle:");
        double length = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(width, length);
        
        System.out.println("Please input radius of Circle:");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);
        
        System.out.println("Please input side A of Triangle:");
        double sideA = scanner.nextDouble();
        System.out.println("Please input side B of Triangle:");
        double sideB = scanner.nextDouble();
        System.out.println("Please input side C of Triangle:");
        double sideC = scanner.nextDouble();
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        
        
        System.out.println();
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
        
    }
}
