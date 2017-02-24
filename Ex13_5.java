//Author: Shane Asel

package Ex13_5;
public class Ex13_5 {
    public static void main(String[] args) {
        // Create two Circle objects
        Circle circle1 = new Circle(10.1, "Red", true);
        Circle circle2 = new Circle(10, "Pink", false);

        // Display circle1
        System.out.println("\nCircle 1: ");
        print(circle1);

        // Display circle2
        System.out.println("\nCircle 2: ");
        print(circle2);

        // Display larger circle
        print("\nThe larger of the two circles was: ");
        print(Circle.max(circle1, circle2));

        // Create two Rectangle objects
        Rectangle rectangle1 = new Rectangle(5, 5, "Purple", true);
        Rectangle rectangle2 = new Rectangle(4.2, 5, "Blue", true);

        // Display rectangle1
        System.out.println("\nRectangle 1: ");
        print(rectangle1);

        // Display rectangle2
        System.out.println("\nRectangle 2: ");
        print(rectangle2);

        // Display larger circle
        print("\nThe larger of the two rectangles was: ");
        print(Rectangle.max(rectangle1, rectangle2));
    }

	// Displays a string
	public static void print(String s) {
            System.out.println(s);
	}

	// Displays a GeometricObject
	public static void print(GeometricObject o) {
            System.out.println(o);
	}
}