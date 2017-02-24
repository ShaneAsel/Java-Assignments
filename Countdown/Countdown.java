import java.util.Scanner;
import java.text.DecimalFormat;
public class Countdown {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the beginning number: \n");
        // prompt user for start number
        double begNum = input.nextDouble();
        
        for (double i = begNum; i > 1; i--){
            // logic to countdown from start number
            DecimalFormat f = new DecimalFormat("#");
            // formating the output
            System.out.println(f.format(i) + " ... ");
            // print countdown in list
        } 
        System.out.print("1\n");  
        System.out.print("Stopped");
    }
}
