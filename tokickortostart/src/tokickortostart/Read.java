package tokickortostart;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read 
{
	
	private static final String FILE_PATH = "Book6.csv";
	public static Project[] reading() throws FileNotFoundException
	{
		Project[] projects = new Project[1118];
		Scanner scanner = new Scanner(new File(FILE_PATH));
		
		String url = "";
		double duration = 0;
		boolean usa = true;
		String category = "";
		double goal = 0;
		double pledge = 0;
		int blurbwords = 0;
		int titlewords = 0;
		boolean staff = true;
		
		int index = 0;
		int otherindex = 0;
		
		
		while(scanner.hasNextLine())
		{
		    Scanner valueScanner = new Scanner(scanner.nextLine());
		    valueScanner.useDelimiter(",");


		    while (valueScanner.hasNext()) {
		    	String data = valueScanner.next();
		    	if (index == 1){
		    		pledge = Double.parseDouble(data);
		    	}
		    	else if (index == 2){
		    		duration = Double.parseDouble(data);
		    	}
		    	else if (index == 3){
		    		goal = Double.parseDouble(data);
		    	}
		    	else if (index == 4){
		    		usa = Boolean.parseBoolean(data);
		    	}
		    	else if (index == 5){
		    		blurbwords = Integer.parseInt(data);
		    	}
		    	else if (index == 6){
		    		titlewords = Integer.parseInt(data);
		    	}
		    	else if (index == 7){
		    		url = data;
		    	}
		    	else if (index == 8){
		    		category = data;
		    	}
		    	index++;
		    }
		    index = 0;
		    //System.out.println(category);
		    if (category.equals("television"))
		    {
		    	projects[otherindex] = new Project(duration, usa, category, goal, blurbwords, titlewords, pledge, staff, url);
				otherindex++; 	
				//System.out.println(otherindex);
		    }
		    
		   	
		}
		
		

        return projects;
         
	}
}
