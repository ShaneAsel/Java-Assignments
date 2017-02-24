public class Rectangle extends RectangleDemo{ 
   
   private double length;
   private double width;


   public Rectangle(double len, double w){
      length = len;
      width = w;
   }

   public void setLength(double len){
      length = len;
   }
 
   public void setWidth(double w){
      width = w;
   }
 
   public double getLength(){
       return length;
   }
 
   public double getWidth(){
       return width;
   }
 
   public double getArea(){
       return length * width;
   }
    
    public double getPerimeter(){
        return 2*(length + width);
    }
  }

class RectangleDemo{
   public static void main(String[] args){
      
      Rectangle box1 = new Rectangle(4.0, 40.0);
      Rectangle box2 = new Rectangle(3.5, 35.9);
 
      System.out.println("Rectangle is 4.0 wide and 40.0 tall.");
      // Display the area.
      System.out.println("The area is " + box1.getArea() + " and the perimeter is " + box1.getPerimeter()+ ".");
        // Display the area and perimeter of the first rectangle .
        
      System.out.println("Rectangle is 3.5 wide and 35.9 tall.");
      System.out.println("The area is " + box2.getArea() + " and the perimeter is " + box2.getPerimeter()+ ".");
        // Display the area and perimeter of the second rectangle.
   }
} 

