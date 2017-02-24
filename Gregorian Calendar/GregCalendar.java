//Author: Shane Asel

import java.util.*;

public class GregCalendar {

public static void main(String[] args) {
// Check terminal line data 
    if (args.length != 2) {
    System.out.println("Usage: java Exercise_13_04 month year");
    System.exit(1);
    }

//Cal object
Calendar calendar = new GregorianCalendar(Integer.valueOf(args[1]), Integer.valueOf(args[0]) - 1, 1);

//Cala header
printHeader(calendar); 

//Space before the first day of the month
for (int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++) 
System.out.print("    ");

//Display days in selected month
    while (calendar.get(Calendar.DATE) < calendar.getActualMaximum(Calendar.DATE)) {
if (calendar.get(Calendar.DAY_OF_WEEK) == 7)
System.out.printf("%4d\n", calendar.get(Calendar.DATE));
else
System.out.printf("%4d", calendar.get(Calendar.DATE));
//Add a day
    calendar.add(Calendar.DATE, 1);
}

System.out.printf("%4d\n", calendar.get(Calendar.DATE));
}


public static String[] getMonths() {
//Returns a String array of all the names of months
String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
return months;
}

public static void printHeader(Calendar calendar) {
// Display cal header
// Create an array of month names
String[] months = getMonths();
// Center month and year center format
int length = 29 / 2 - (months[calendar.get(Calendar.MONTH)].length() / 2 + 3);
    System.out.println();
for (int i = 0; i < length; i++)
System.out.print(" ");
    System.out.println(months[calendar.get(Calendar.MONTH)] + ", " + calendar.get(Calendar.YEAR));
//Display day names
System.out.println("-----------------------------");
System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}
}
