package tokickortostart;

public class Project implements Comparable<Project> {
	private double Duration;
	private boolean US;
	private String Category;
	private double Goal;
	private int BlurbWords;
	private int TitleWords;
	private double Pledge;
	private String URL;
	private int ID;
	private double Likeness;
	private double Fitness;
	
	public Project(double duration, boolean us, String cat, double goal, int blurb, int title, double pledge, String url) {
		this.Duration = duration;
		this.US = us;
		this.Category = cat;
		this.Goal = goal;
		this.BlurbWords = blurb;
		this.TitleWords = title;
		this.Pledge = pledge;
		this.URL = url;
		//Defaults:
		this.ID = -1;
		this.Likeness = -1;
		this.Fitness = -1;
	}
	
	public Project(double duration, boolean us, String cat, double goal, int blurb, int title) {
		this.Duration = duration;
		this.US = us;
		this.Category = cat;
		this.Goal = goal;
		this.BlurbWords = blurb;
		this.TitleWords = title;
		//Defaults:
		this.Pledge = -1;
		this.URL = "";
		this.ID = -1;
		this.Likeness = -1;
		this.Fitness = -1;
	}
	
	public double getDuration() {
		return this.Duration;
	}
	
	public boolean getUS() {
		return this.US;
	}
	
	public String getCategory() {
		return this.Category;
	}
	
	public double getGoal() {
		return this.Goal;
	}
	
	public int getBlurbWords() {
		return this.BlurbWords;
	}

	public int getTitleWords() {
		return this.TitleWords;
	}
	
	public double getPledge() {
		return this.Pledge;
	}
	
	public String getURL() {
		return this.URL;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public double getLikeness() {
		return this.Likeness;
	}
	
	public double getFitness() {
		return this.Fitness;
	}
	
	public void setID(int id) {
		this.ID = id;
	}
	
	public void setLikeness(double likeness) {
		this.Likeness = likeness;
	}
	
	public void setFitness(double fitness) {
		this.Fitness = fitness;
	}

	public int compareTo(Project in) {
		return (int) (in.getLikeness() - this.getLikeness());
	}
}
