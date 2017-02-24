import java.util.Scanner;
import java.text.DecimalFormat;
public class Currency {

    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    double exchangeRate, dollarAmount, rmbAmount;
    int userChoice;
    // Declaration of variables
    
    System.out.print("Enter the exchange rate from dollars to RMB: ");
    exchangeRate = s.nextDouble();
    // Collects current exchange from user
  
    System.out.print("Enter 0 to convert dollars to RMB or 1 vice versa: ");
    userChoice = s.nextInt();
    DecimalFormat y = new DecimalFormat("#.00");
    // Collects user choice for conversion
    
    if(userChoice == 0) {
        System.out.println("Enter the dollar amount: ");
        dollarAmount = s.nextDouble();
        // Collects dollar ammount from user
        rmbAmount = dollarAmount * exchangeRate;
        // logic to calculate RMB ammount
        System.out.print("$" + y.format(dollarAmount) + " is " + y.format(rmbAmount) + " Yuan\n");}
        // Displays coversion from USD to RMB
    
    else if(userChoice == 1) {
        System.out.println("Enter the RMB amount: ");
        rmbAmount = s.nextDouble();
        //Collects RMB ammount from user
        dollarAmount = rmbAmount * exchangeRate;
        // logic to calculate USD ammount
        System.out.print(y.format(rmbAmount) + " Yuan is $" + y.format(dollarAmount) + ("\n")); }
        // Displays coversion from RMB to USD
    
    else {
        // If user inputs anything other than a "1" or "0" then the user is informed of invalid choice
        System.out.print("Incorrect input");
        // Displays error for user.
  
         }
    }
}

        
