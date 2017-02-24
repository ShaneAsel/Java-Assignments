import java.util.Scanner;
import java.util.InputMismatchException;
public class IntEx {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter two integers: ");
        //Prompt user for integers
        int num1 = 0;
        int num2 = 0;
        //Declare num1 and num2 as int variables
        boolean isValid = false;
        while (!isValid) {
        //Enter while statement 
            try {
                num1 = input.nextInt();
                num2 = input.nextInt();
                isValid = true;
            } catch (InputMismatchException ex) {
                input.nextLine();
                System.out.print("Incorrect input and re-enter two integers: " );
                //If user enters something other than an integer
                //System prompts user for a correct integer
                //Program repeats until user enters two valid integers
            }
        }
        System.out.println("Sum is " + (num1 + num2));
        //Displays sum of two user provided integers
    }
}
