package ss07_AbstractClass_Interface.thuc_hanh.interface_comparator;

import ss06_Inheritance.thuc_hanh.geometric_objects.Shape;

public class Circle extends Shape {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "test.A Circle with Radius = "
                + getRadius()
                + ", which is a Subclass of "
                + super.toString();
    }
}