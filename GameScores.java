//Author: Shane Asel

package gamescores;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class GameScores {
    public static void main(String[] args) {
        //Import scores to array
        ArrayList<Integer> scores = new ArrayList<>();
        try {
            URL url = new URL("http://cs.armstrong.edu/liang/data/Scores.txt");
            Scanner input = new Scanner(url.openStream());
            while (input.hasNextInt()) {
                scores.add(input.nextInt());
            }

        } catch (IOException e) {
            System.exit(0);
        }
        
        //Print out the sum of the scores
        System.out.println("Total = " + getTotal(scores));
        //Print out the average of the scores
        System.out.println("Average = " + getAverage(scores));

    }
    
    //Find the average of the array 
    private static double getAverage(ArrayList<Integer> scores) { 
        double total = getTotal(scores);
        return total / scores.size();
    }
    
    //Find the total of the array
    private static int getTotal(ArrayList<Integer> scores) {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }
}