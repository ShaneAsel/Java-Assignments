import java.util.Scanner;
public class CD_Value {
    @SuppressWarnings("empty-statement")
    public static void main (String [] args){
    double InitialDeposit = 0;
    //setting the initial deposit to 0
    
    Scanner input = new Scanner(System.in);
   
    System.out.print("Enter the initial deposit amount: ");
    // user unputs initial deposit ammount
    InitialDeposit = input.nextDouble();
  
    System.out.print("Enter annual percentage yield: ");
    // user inputs the apy
    double apy = input.nextDouble();
   
    System.out.print("Enter maturity period (number of months): \n"); 
    // user inputs the maturity period
    double months = input.nextDouble();
   
    System.out.println("Month\t\tCD Value");
    for (int value= 1; value <= months; value++){ 
    // the maturity loop value starts at 1 then ends at the maturity period
    InitialDeposit = InitialDeposit + InitialDeposit * (apy / 1200); 
    // app will loop the initial deposit and calculates the future investment
    
    System.out.printf("   %2s           % 4.2f\n", value, InitialDeposit);
    }
}   
}
