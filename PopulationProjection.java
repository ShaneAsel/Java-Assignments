import java.util.Scanner;
import java.text.DecimalFormat;

public class PopulationProjection {

    public static void main(String[] args) {
        //logic here
        Scanner input = new Scanner(System.in);
        
        // Prompt user to enter years
        System.out.print("Enter the number of years: ");
        double years = input.nextDouble();
        DecimalFormat y = new DecimalFormat("##");
        
        // Compute new population
        double population = years * 158796339.5;
        DecimalFormat f = new DecimalFormat("##");
        
        // Display new population
        System.out.println("The population in " + y.format(years) + " years is " + f.format(population));
    }
    
}
