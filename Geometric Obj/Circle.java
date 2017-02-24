//Author: Shane Asel
package Ex13_5;

//All the logic pertaining to the circle
public class Circle extends GeometricObject {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, 
        String color, boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }

    //Returns radius
    public double getRadius() {
        return radius;
    }

    //Sets new radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override //Returns area
    public double getArea() {
        return radius * radius * Math.PI;
    }

    //Returns diameter
    public double getDiameter() {
        return 2 * radius;
    }

    @Override //Returns perimeter
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override // Returns all data of Circle obj
    public String toString() {
            return super.toString() + "\nRadius: " + radius + "\nArea: " + getArea() + "\nDiameter: " + getDiameter() + "\nPerimeter: " + getPerimeter();
	}
}