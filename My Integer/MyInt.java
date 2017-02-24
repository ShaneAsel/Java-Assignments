import java.util.Scanner;
public class MyInt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer: \n");
        int int1 = input.nextInt();
        // Collects first integer from user
        
        MyInteger testInt = new MyInteger(int1);
        System.out.printf("%d is even? %s%n", testInt.getValue(), testInt.isEven()); 
        // Displays if first integer is even
        System.out.printf("%d is prime? %s%n", testInt.getValue(), testInt.isPrime());
        // Displays if first integer is prime
        
        System.out.print("Enter another integer: \n");
        int int2 = input.nextInt();
        // Collects second integer from user
        
        MyInteger int5 = new MyInteger(5);
        //Sets 5 as variable
        MyInteger testInt2 = new MyInteger(int2);
        System.out.printf(testInt2.getValue() + " is odd? %s%n", testInt2.isOdd());
        // Displays if second integer is odd
        System.out.printf("%d is equal to %d? %s%n", testInt.getValue(), testInt2.getValue(), testInt.equals(testInt2));
        // Displays if first integer is equal to second integer 
        System.out.printf("%d is equal to %d? %s%n", testInt.getValue(), int5.getValue(), testInt.equals(int5));
        // Displays if first integer is equal to 5
        // I think I was overthinking this. I didn't think of 5 as a constant, instead I assumed 5 was just a variable the user selected. 
        // Making it a constant made this a lot easier.
        
        System.out.print("Enter a string to parse to an integer: \n");
        String numAsString = input.next();
        // Collects string from user to parse
        
        int parseNum = MyInteger.parseInt(numAsString);
        System.out.print(parseNum + "\n");
        // Displays new integer from parse string

    }
}


class MyInteger {
    private int mValue;

    public MyInteger(int value) {
        mValue = value;
    }

    public int getValue() {
        return mValue;
    }

    public boolean isEven() {
        return (mValue % 2) == 0;
    }

    public boolean isOdd() {
        return (mValue % 2) == 1;
    }

    public boolean isPrime() {
        if (mValue % 2 == 0) {
            return false;
        }
        else {
            for (int i = 3; i * i <= mValue; i += 2) {
                if (mValue % i == 0) return false;
            }
        }
        return true;
    }

    public static boolean isEven(int myInt) {
        return (myInt % 2) == 0;
    }

    public static boolean isOdd(int myInt) {
        return (myInt % 2) == 1;
    }

    public static boolean isPrime(int myInt) {
        if (myInt == 1 || myInt == 2) {
            return true;
        }
        else {
            for (int i = 2; i < myInt; i++) {
                if (i % myInt == 0) return false;
            }
        }
        return true;
    }    

    public static boolean isEven(MyInteger myInt) {
        return myInt.isEven();
    }

    public static boolean isOdd(MyInteger myInt) {
        return myInt.isOdd();
    }

    public static boolean isPrime(MyInteger myInt) {
        return myInt.isPrime();
    }

    public boolean equals(int testInt) {
        return testInt == mValue;
    }

    public boolean equals(MyInteger myInt) {
        return myInt.mValue == this.mValue;
    }

    public static int parseInt(String s) {      
        int result = 0;    
            for (int i = 0; i < s.length(); i++) {      
            result = result * 10 + (s.charAt(i) - '0'); 
            }
        return result;  
    }


}
