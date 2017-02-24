import java.util.Scanner;

public class Palindrome {
     public static void main(String args[]){
        
        System.out.println("Enter a positive integer: ");
        // Prompting user for positive integer
        int palindrome = new Scanner(System.in).nextInt();
        
        if(isPalindrome(palindrome)){
            System.out.println(palindrome + " is a palindrome");
        }
        else{
            System.out.println(palindrome + " is not a palindrome");
        }       
        
    }
    
    public static int reverse(int palindrome)
    { // missing return?
        int y;
        int n;
        for (n = 0; n <= palindrome; n++)
        { // parameters
            y = palindrome % 10; // remainder
            palindrome = palindrome / 10; // gets rid of last digit
            n = n * 10 + y; // sets reverse values
        }
        return n; // returns reversed number  
    }
  
    // Logic to check if integer is a plaindrome
    public static boolean isPalindrome(int number) {
        int palindrome = number; 
        // Copied integer into variable
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }
        return number == reverse;
        // Returns result - is integer a palindrome.
    } 
}
