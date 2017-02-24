//Author: Shane Asel

package Ex13_5;
public abstract class GeometricObject implements Comparable<GeometricObject> {
    private String color = "while";
    private boolean filled;
    private java.util.Date dateCreated;

    //Create default geometric obj
    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    //Create a geometric obj with a color and a filled value
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    //Returns color of obj
    public String getColor() {
        return color;
    }

    //Sets new color
    public void setColor(String color) {
            this.color = color;
    }

    //Returns filled == True
    public boolean isFilled() {
            return filled;
    }

    //Sets new filled
    public void setFilled(boolean filled) {
            this.filled = filled;
    }

    //Gets dateCreated
    public java.util.Date getDateCreated() {
            return dateCreated;
    }

    @Override
    public String toString() {
            return "Created On: " + dateCreated + "\nColor: " + color + "\nFilled(T/F): " + filled;
    }

    @Override //Implement compareTo method
    public int compareTo(GeometricObject o) {
        if (this.getArea() > o.getArea())
            return 1;
        else if (this.getArea() < o.getArea())
            return -1;
        else
            return 0;
    }

    //Method to getMax
    public static GeometricObject max(GeometricObject o1, GeometricObject o2) {
        return o1.compareTo(o2) == 1 ? o1 : o2;
    }

    //Method getArea
    public abstract double getArea();

    //Method getPerimeter
    public abstract double getPerimeter();
}
