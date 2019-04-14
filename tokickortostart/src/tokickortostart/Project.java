package tokickortostart;

/**
 * 
 * This is the ADT for project types.
 * All the projects in the input data are made 
 * into project types and so is the users inputted project
 * 
 */
public class Project implements Comparable<Project> {
	/**
	 * Duration of the project campaign 
	 */
	private double Duration;
	/**
	 * Whether or not the project is based in the USA
	 */
	private boolean US;
	
	/**
	 * The category type of the project.
	 */
	private String Category;
	
	/**
	 * THe goal amount of the project in USD
	 */
	private double Goal;
	
	/**
	 * The number of words in the project blurb
	 */
	private int BlurbWords;
	
	/**
	 * The number of words in the project title
	 */
	private int TitleWords;
	
	/**
	 * The amount of money the project received
	 */
	private double Pledge;
	
	/**
	 * The URL of the project
	 */
	private String URL;
	
	/**
	 * The ID number of the project
	 */
	private int ID;
	
	/**
	 * The likeness of the project to the inputted project
	 */
	private double Likeness;
	
	/**
	 * How successful the project was
	 */
	private double Fitness; 
	
	/**
	 * Constructor used for projects in the dataset
	 * 
	 * @param duration Duration of the project campaign 
	 * @param us Whether or not the project is based in the USA
	 * @param cat The category type of the project.
	 * @param goal THe goal amount of the project in USD
	 * @param blurb The number of words in the project blurb
	 * @param title The number of words in the project title
	 * @param pledge The amount of money the project received
	 * @param url The URL of the project
	 */
	public Project(double duration, boolean us, String cat, double goal, int blurb, int title, double pledge, String url) {
		this.Duration = duration;
		this.US = us;
		this.Category = cat;
		this.Goal = goal;
		this.BlurbWords = blurb;
		this.TitleWords = title;
		this.Pledge = pledge;
		this.URL = url;
		
		/**
		 * THese values will be calculated later on using the other modules.
		 * These are default values.
		 */
		this.ID = -1;
		this.Likeness = -1;
		this.Fitness = -1;
	}
	
	/**
	 * Constructor used for users inputted project
	 * 
	 * @param duration Duration of the project campaign 
	 * @param us Whether or not the project is based in the USA
	 * @param cat The category type of the project.
	 * @param goal THe goal amount of the project in USD
	 * @param blurb The number of words in the project blurb
	 * @param title The number of words in the project title
	 */
	public Project(double duration, boolean us, String cat, double goal, int blurb, int title) {
		this.Duration = duration;
		this.US = us;
		this.Category = cat;
		this.Goal = goal;
		this.BlurbWords = blurb;
		this.TitleWords = title;
		
		/**
		 * These are default values which cannot be given for an inputted project
		 */
		this.Pledge = -1;
		this.URL = "";
		this.ID = -1;
		this.Likeness = -1;
		this.Fitness = -1;
	}
	
	/**
	 * Accessor for project duration
	 * @return The project duration
	 */
	public double getDuration() {
		return this.Duration;
	}
	
	/**
	 * Accessor for whether or not the project is in the USA
	 * @return Whether or not the project is in the USA
	 */
	public boolean getUS() {
		return this.US;
	}
	
	/**
	 * Accessor for project category
	 * @return The project category
	 */
	public String getCategory() {
		return this.Category;
	}
	
	/**
	 * Accessor for project goal
	 * @return The project goal
	 */
	public double getGoal() {
		return this.Goal;
	}
	
	/**
	 * Accessor for project blurb words
	 * @return The project blurb words
	 */
	public int getBlurbWords() {
		return this.BlurbWords;
	}

	/**
	 * Accessor for project title words
	 * @return The project title words
	 */
	public int getTitleWords() {
		return this.TitleWords;
	}
	
	/**
	 * Accessor for project Pledge
	 * @return The project Pledge
	 */
	public double getPledge() {
		return this.Pledge;
	}
	
	/**
	 * Accessor for project URL
	 * @return The project URL
	 */
	public String getURL() {
		return this.URL;
	}
	
	/**
	 * Accessor for project ID
	 * @return The project ID
	 */
	public int getID() {
		return this.ID;
	}
	
	/**
	 * Accessor for project likeness
	 * @return The project likeness
	 */
	public double getLikeness() {
		return this.Likeness;
	}
	
	/**
	 * Accessor for project fitness
	 * @return The project fitness
	 */
	public double getFitness() {
		return this.Fitness;
	}
	
	/**
	 * Mutator for project ID
	 * @param id The new ID for the project
	 */
	public void setID(int id) {
		this.ID = id;
	}
	
	/**
	 * Mutator for project likeness
	 * @param likeness The new likeness for the project
	 */
	public void setLikeness(double likeness) {
		this.Likeness = likeness;
	}
	
	/**
	 * Mutator for project fitness
	 * @param fitness The new fitness for the project
	 */
	public void setFitness(double fitness) {
		this.Fitness = fitness;
	}

	/**
	 * Compares projects by likeness to allow for easy sorting
	 * @param in The Project to compare to this project
	 * @return Integer indicating which project has higher likeness value 
	 */
	public int compareTo(Project in) {
		return (int) (in.getLikeness() - this.getLikeness());
	}
}
