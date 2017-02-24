//Author: Shane Asel

import java.util.Scanner;
public class Exam3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a list of characters: ");
        String stInput = sc.nextLine();
        System.out.println("Enter search character: ");
        char ch = sc.next().charAt(0);

        char[] chars = stInput.replaceAll(" ", "").toCharArray();
        System.out.println(count(chars, ch));
    }

    private static int count(char[] chars, char ch) {
        return count(chars, ch, chars.length - 1);
    }

    private static int count(char[] chars, char ch, int high) {

        int count = (chars[high] == ch) ? 1 : 0;

        if (high == 0)
            return count;
        else
            return count + count(chars, ch, high - 1);
    }

}