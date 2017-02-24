import java.util.Scanner;

public class SumDigits {
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int integer = input.nextInt();
    //Call sumDigits and then display the result for the user
    System.out.println("The sum of digits in " + integer + " is " + sumDigits(integer));
} //End main
		
public static int sumDigits(long n) {
    int val = (int)Math.abs(n);  // temp value
    int sum = 0; 
    //Sum of the digits
    //Enter while loop
    while (val > 0) {
        //Extract a digit and add it to sum
        sum += val % 10;
        //Now set temp to the value minus the extracted digit
        val = val / 10;
    }
    //Return the sum of the digits		
    return sum;
}//End of sumDigits
}
