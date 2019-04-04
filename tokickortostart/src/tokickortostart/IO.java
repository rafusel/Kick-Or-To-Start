package tokickortostart;

import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

public class IO {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the begin date of your project: (dd/mm/yyyy)");
		String beginString = input.next();
		input = new Scanner(beginString);
		input.useDelimiter("/");
		int day = Integer.parseInt(input.next());
		int month = Integer.parseInt(input.next());
		int year = Integer.parseInt(input.next());
		Calendar cal = Calendar.getInstance();
		cal.set(year,  month, day);
		Date begin = cal.getTime();
		
		System.out.println("Please enter the end date of your project: (dd/mm/yyyy)");
		input = new Scanner(System.in);
		String endString = input.next();
		input = new Scanner(endString);
		input.useDelimiter("/");
		day = Integer.parseInt(input.next());
		month = Integer.parseInt(input.next());
		year = Integer.parseInt(input.next());
		cal = Calendar.getInstance();
		cal.set(year,  month, day);
		Date end = cal.getTime();
		
		double duration = Math.abs((begin.getTime() - end.getTime())/8640000);
		
		System.out.println("Does is your project based out of the United States? (y/n)");
		input = new Scanner(System.in);
		if(input.next().equals("y")) {
			boolean us = true;
		} else {
			boolean us = false;
		}
		
		System.out.println("Which one of these categories is your project in?");
		System.out.println("Enter the number that corresponds with your category.");
		
		
		
		
	}
}
