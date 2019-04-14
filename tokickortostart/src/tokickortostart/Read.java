package tokickortostart;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * This class contains the method for reading
 * the info from the csv containing the info
 * on past kickstarter projects.
 *
 */
public class Read 
{
	
	/**
	 * The file to read project info from
	 */
	private static final String FILE_PATH = "Book7.csv";

	/**
	 * Reads in the dataset of projects and takes in the cateogry of the users inputted
	 * project. Uses this information to create a hash table and return an array of projects
	 * of the same type as the user.
	 * 
	 * @param type The category of the inputted project
	 * @return returns and array of projects of the same type as the inputted project
	 * @throws FileNotFoundException Thrown when the file to read info from cannot be found
	 */
	public static Project[] reading(String type) throws FileNotFoundException
	{
		/**
		 * Used for reading the rows of the dataset
		 */
		Scanner scanner = new Scanner(new File(FILE_PATH));
		
		/**
		 * Hash table is of the size of the number of project categories in the dataset
		 */
		Hashing hash = new Hashing(143); 
		
		/**
		 * Creating and initalizing the variables of the projects to be read
		 */
		String url = "";
		double duration = 0;
		boolean usa = true;
		String category = "";
		double goal = 0;
		double pledge = 0;
		int blurbwords = 0;
		int titlewords = 0;
		
		/**
		 * Used for keeping track of which data item the scanner is currently on
		 */
		int index = 0;

		/**
		 * Iterates over every row in the dataset
		 */
		while(scanner.hasNextLine())
		{
			/**
			 * Used for iterating over every column of a row
			 */
		    Scanner valueScanner = new Scanner(scanner.nextLine());
		    valueScanner.useDelimiter(",");

		    /**
		     * Iterating over every columns in the row
		     */
		    while (valueScanner.hasNext()) {
		    	String data = valueScanner.next();
		    	
		    	/**
		    	 * Depending on the current column, different variables are updated for the current project
		    	 */
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
		    		int tmp = Integer.parseInt(data);
		    		if (tmp == 1)
		    			usa = true;
		    		else
		    			usa = false;
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
		    
		    /**
		     * The read project is placed into the hash table
		     */
		    hash.put(category ,new Project(duration, usa, category, goal, blurbwords, titlewords, pledge, url));
		        
		}
		
		/**
		 * Retrieving the row of projects of the same type of the inputted project in the hash table
		 * and them creating an array out of said row and returning the array
		 */
		Object[] x =  hash.get(type).toArray();
		Project[] v = new Project[x.length];		
		for(int i = 0; i < x.length; i++ )
		{
			v[i] = (Project) x[i];
		}
		return v; 
         
	}
}
