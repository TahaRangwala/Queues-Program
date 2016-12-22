/*Name: Taha Rangwala
 * Date: December 21, 2016
 * Purpose: The purpose of this class is to hold the information for the jobs
 */

import BreezySwing.Format;//allows for formatting options

//Job class header
public class Job {

	//Declaring private instance variables
	private String Name;//Customer's name
	private String Description;//Description of the job
	
	/*Purpose: Constructor method to initialize instance variables
	 * @param Name This is the customer's name
	 * @param Description This is the description of the job
	 */
	public Job(String Name, String Description){
		this.Name = Name;
		this.Description = Description;
	}
	
	/*Purpose: This gets the customer's name
	 * @return This returns a string value of the customer's name
	 */
	public String Name(){
		return Name;
	}
	
	/*Purpose: This gets the description of the job
	 * @return This returns a string value of the description of the job
	 */
	public String Description(){
		return Description;
	}
	
	/*Purpose: This gets all of the information of the job
	 * @return This returns a string value of all of the information of the job
	 */
	public String toString(){
		String Output =  Format.justify('l', "Name", 15) + Format.justify('l', "Description", 15) + "\n";
		return Output += Format.justify('l', Name, 15) + Format.justify('l', Description, 15) + "\n";
	}
	
	/*Purpose: The purpose of this method is to error check all of the information in the job
	 * @param Name This is the customer's name
	 * @param Description This is the description of the job
	 */
	public static void errorCheckJobs(String Name, String Description){
		if(Name.trim().equals("") || Description.trim().equals(""))
			throw new IllegalArgumentException("Please Input Valid Information For The Jobs!");
	}
	
}
