/*Name: Taha Rangwala
 * Date: December 21, 2016
 * Purpose: The purpose of this class is to allow the user to choose whether or not they want
 * a array queue or a linked list queue when using the program.
 */

import BreezySwing.*;//imports more window objects

import javax.swing.*;//imports more window objects

import java.awt.Color;//adds more colors

//QueueGUI class header
public class QueueGUI extends GBDialog{
	
	//Declaring private instance variables
	private JFrame frame;//frame object sent in
	//Declaring window objects
	private JButton Array, LinkedList;
	
	/*Purpose: Constructor method to initialize window objects
	 * @param F This is the frame object sent in
	 */
	public QueueGUI(JFrame F){
		super(F);
		frame = F;
		setSize(300,100);//size of the GUI interface
		setTitle("Choose The Type Of Queue");//title of GUI interface
		setLocationRelativeTo(null);//Location is in center of screen
		getContentPane().setBackground(new Color(169,229,255));//background of GUI is light blue
		Array = addButton("Array",1,1,1,1);
		LinkedList = addButton("Linked List",1,2,1,1);
	}
	
	/*Purpose: The purpose of this method is to detect which button the user presses and then it performs whatever task
	 * that the user wants
	 * @param buttonObj This is the button object which holds the value of what button the user has pressed
	 */
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == Array){//chooses array queue
			this.dispose();
			SizeGUI size = new SizeGUI(frame);
			size.setVisible(true);//opens size gui for array queue
		}
		else if(buttonObj == LinkedList){//chooses linked list queue
			GUI.queueObj = new LinkedListQueue();
			setVisible(false);
		}
	}
}
