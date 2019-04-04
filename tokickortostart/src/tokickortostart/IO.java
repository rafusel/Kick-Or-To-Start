package tokickortostart;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;
import java.util.Date;

public class IO {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
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
		Calendar cal2 = Calendar.getInstance();
		cal2.set(year,  month, day);
		Date end = cal2.getTime();
		
		//duration is the duration of the input project. Pass this to the Project constructor.
		double duration = Math.abs((begin.getTime() - end.getTime())/86400000);
		
		boolean us = true;
		//us is for the Project constructor.
		System.out.println("Is your project based out of the United States? (y/n)");
		input = new Scanner(System.in);
		if(input.next().equals("y")) {
			us = true;
		} else {
			us = false;
		}
		
		System.out.println("Which one of these categories is your project in?");
		System.out.println("Enter the number that corresponds with your category.");
		
		Scanner categories = new Scanner(new File("categories.txt"));
		categories.useDelimiter("\n");
		String[] cat = new String[134];
		for (int i = 0; i < cat.length; i++) {
			cat[i] = categories.next();
		}
		
		for (int i = 0; i <  cat.length; i++) {
			System.out.print((i + 1) + " " + cat[i]);
		}
		input = new Scanner(System.in);
		int x =  input.nextInt();
		//Category is for the input project constructor.
		String category = cat[x - 1];
		category = category.substring(0, category.length() - 1);
		
		System.out.println("What is your project's target funding?");
		input = new Scanner(System.in);
		//Goal is for the input project constructor.
		double goal = input.nextDouble();
		//input.close();
		
		System.out.println("Please input your project description.");
		input = new Scanner(System.in);
		String description = input.nextLine();
		int descriptionWords = 0;
		for (int i  = 0; i < description.length(); i++) {
			if(description.charAt(i) == ' ') {
				descriptionWords++;
			}
		}
		descriptionWords++;
		//descriptionWOrds is for the input constructor. 
		
		System.out.println("Please input your project title.");
		input = new Scanner(System.in);
		String title = input.nextLine();
		int titleWords = 0;
		for (int i  = 0; i < title.length(); i++) {
			if(title.charAt(i) == ' ') {
				titleWords++;
			}
		}
		titleWords++;
		
		//titleWOrds is for the input constructor. 
		/*
		System.out.println(duration);
		System.out.println(us);
		System.out.println(category);
		System.out.println(goal);
		System.out.println(descriptionWords);
		System.out.println(titleWords);
		*/
		
		Project userProj = new Project(duration, us, category, goal, descriptionWords, titleWords);
		//0input.close();
		
		////////////////////////////////////////////////////
		//           END OF READING FROM USER             //
		////////////////////////////////////////////////////
		
		Project [] arr = Read.reading();
		Likeness.allLikeness(arr, userProj);
		double prob = Probability.probability(arr);
		Project best = SimilarProject.MostSimilar(arr);
		Fitness.allFitness(arr);
		Project bestest = Score.BestProject(arr);
		
		Writer output = new BufferedWriter(new FileWriter(new File("output.txt")));
		
		output.write("The probability that your project will succeed is: ");
		output.write((prob*100) + "%. \n");
		output.write("\n");
		output.write("The most similar project in our data base to the project you entered \ncan be found here: \n ");
		output.write(best.getURL() + "\n");
		output.write("\n");
		output.write("The project you should model your project off of can be found here: \n");
		output.write(bestest.getURL() + "\n");
		output.close();
	}
}
