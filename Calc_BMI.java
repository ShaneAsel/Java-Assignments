import java.util.Scanner;

public class Calc_BMI {

    public static void main(String[] args) {
        // logic input 
        Scanner input = new Scanner(System.in);
        
        //Prompt user for weight in lbs
        System.out.print("Enter weight in pounds: ");
        double weight = input.nextDouble();
        double kilo = weight * 0.45359237;
        
        //Prompt for user height
        System.out.print("Enter height in inches: ");
        double height = input.nextDouble();
        double meter = height * 0.0254;
        
        //Compute BMI
        double BMI = (kilo/(meter * meter));
        
       
        //Display BMI
        System.out.print("BMI is " + BMI);
        
        
        
    }
    
}
