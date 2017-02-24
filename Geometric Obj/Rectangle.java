//Author: Shane Asel

package Ex13_5;

//All the logic pertaining to the rectangle
public class Rectangle extends GeometricObject {
    private double width;
    private double height;

    public Rectangle(
        double width, double height) {
        this.width = width;
        this.height = height;
    }

	public Rectangle(
            double width, double height, String color, boolean filled) {
            this.width = width;
            this.height = height;
            setColor(color);
            setFilled(filled);
	}

	//Returns width
	public double getWidth() {
            return width;
	}

	//Set new width
	public void setWidth(double width) {
            this. width = width;
	}

	//Return height
	public double getheight() {
            return height;
	}

	//Set new height
	public void setheight(double height) {
            this.height = height;
	}

	@Override //Returns area
	public double getArea() {
            return width * height;
	}

	@Override //Returns perimeter
	public double getPerimeter() {
            return 2 * (width * height);
	}

	@Override //Returns all data of rectangle obj
	public String toString() {
            return super.toString() + "\nWidth: " + width + "\nHeight: " + height + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter();
	}
}