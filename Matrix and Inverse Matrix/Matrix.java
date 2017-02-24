//Author: Shane Asel

package matrix;

import java.util.Scanner;

public class Matrix {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
	
        int i, j;
	int array[][] = new int[3][3];
        // Prompt user for 9 numbers to fill a 3X3 matrix
	System.out.print("Enter 9 numbers (e.g. 1 2 3) to form a 3X3 matrix: ");
 	for(i = 0; i < 3; i++){
   	    for(j = 0; j < 3; j++){
        	array[i][j] = s.nextInt();
            }
  	} 
        
        System.out.println("");
        // To make it less cluttered
	System.out.println("The matrix for the given values is: ");
        // Display the matrix of given values
  	for(i = 0; i < 3; i++){
      	    for(j = 0; j < 3; j++){    
            System.out.print(array[i][j]+" ");
            }
            System.out.println(" ");
        }
        
        
        System.out.println("");
        // To make it less cluttered
 	System.out.println("The transposed matrix of the above matrix is: ");
        // Display the transposed matrix
  	for(i = 0; i < 3; i++){
      	    for(j = 0; j < 3; j++){
            System.out.print(array[j][i]+" ");
            }
            System.out.println(" ");
        }
    }
}
