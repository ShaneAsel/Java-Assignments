import java.util.Scanner; 

public class ArrayIndex {
public static void main(String[] args) {

        //Setting the array with 100 random integers
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index: ");
        
        //Logic for determining the outcome after user enters index.
        try {
            int index = input.nextInt();
            System.out.println("array[" + index + "] = " + array[index]);
        } 
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Out of Bounds");
        } 
        catch (Exception ex) {
            System.out.println("INVALID INPUT");
        }
}
}
