/*Name: Taha Rangwala
 * Date: December 21, 2016
 * Purpose: The purpose of this class is to allow the user to use input and output fields, buttons, and
 * other window objects to perform tasks that this program offers using array and linked list queues.
 */

import BreezySwing.*;//imports more window objects

import javax.swing.*;//imports more window objects

import java.awt.Color;//adds more colors

//GUI class header
public class GUI extends GBFrame{

	//Declaring private instance variables
	public static QueueADT queueObj;//QueueADT interface objects
	//Declaring window objects
	private JLabel nameLabel, descriptionLabel;
	private JTextField nameField, descriptionField;
	private JTextArea outputArea;
	private JButton Add, Display, Remove, Exit;
	
	//Constructor method to initialize window objects
	public GUI(){
		nameLabel = addLabel("Name",1,1,1,1);
		nameField = addTextField("",1,2,1,1);
		descriptionLabel = addLabel("Description",2,1,1,1);
		descriptionField = addTextField("",2,2,1,1);
		Add = addButton("Add",3,1,1,1);
		Remove = addButton("Remove",3,2,1,1);
		outputArea = addTextArea("",4,1,2,1);
		Display = addButton("Display",5,1,1,1);;
		Exit = addButton("Exit",5,2,1,1);
		QueueGUI queue = new QueueGUI(this);
		queue.setVisible(true);
	}
	
	/*Purpose: The purpose of this method is to detect which button the user presses and then it performs whatever task
	 * that the user wants
	 * @param buttonObj This is the button object which holds the value of what button the user has pressed
	 */
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == Add){//Adds jobs to the queue
			try{
				Job.errorCheckJobs(nameField.getText(), descriptionField.getText());
				queueObj.enqueue(new Job(nameField.getText(), descriptionField.getText()));
			}
			catch(Exception E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(buttonObj == Remove){//Removes jobs from the queue
			try{
				queueObj.dequeue().toString();
				outputArea.setText("");
			}
			catch(Exception E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(buttonObj == Display){//Displays all jobs
			try{
				outputArea.setText(queueObj.toString());
			}
			catch(Exception E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else
			this.dispose();//closes the program
	}
	
	//Main method to set up the GUI
	public static void main (String [] args){
		GUI theMainGUI;
		theMainGUI = new GUI();
		theMainGUI.setSize(380,300);//size of the GUI interface
		theMainGUI.setTitle("Taha's Desktop Publishing Company Queue");//title of GUI interface
		theMainGUI.setVisible(true);//visibility of interface
		theMainGUI.setLocationRelativeTo(null);//Location is in center of screen
		//theMainGUI.setLookAndFeel("MOTIF");//This changes the look of the GUI interface
		theMainGUI.getContentPane().setBackground(new Color(169,229,255));//background of GUI is light blue
	}
	
}
