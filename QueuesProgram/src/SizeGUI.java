/*Name: Taha Rangwala
 * Date: December 21, 2016
 * Purpose: The purpose of this class is to allow the user to select a custom size for the array queue if the user 
 * selects the array queue
 */

import BreezySwing.*;//imports more window objects

import javax.swing.*;//imports more window objects

import java.awt.Color;//adds more colors

//SizeGUI class header
public class SizeGUI extends GBDialog{

	//Declaring window objects
	private JLabel sizeLabel;
	private IntegerField sizeField;
	private JButton customSize, Exit;
	
	/*Purpose: Constructor method to initialize window objects
	 * @param F This is the frame object sent in
	 */
	public SizeGUI(JFrame F){
		super(F);
		setSize(300,100);//size of the GUI interface
		setTitle("Choose The Type Of Queue");//title of GUI interface
		setLocationRelativeTo(null);//Location is in center of screen
		getContentPane().setBackground(new Color(169,229,255));//background of GUI is light blue
		sizeLabel = addLabel("Size",1,1,1,1);
		sizeField = addIntegerField(0,1,2,1,1);
		customSize = addButton("Custom Size",2,1,1,1);
		Exit = addButton("Exit",2,2,1,1);
	}
	
	/*Purpose: The purpose of this method is to detect which button the user presses and then it performs whatever task
	 * that the user wants
	 * @param buttonObj This is the button object which holds the value of what button the user has pressed
	 */
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == customSize){//choose a custom size for the array queue
			if(isNumber()){
				try{
					checkNumber(sizeField.getNumber());
					GUI.queueObj = new ArrayQueue(sizeField.getNumber());
					setVisible(false);
				}
				catch(Exception E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(new JFrame(),"The Size Is Not An Integer", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else{//chooses the default size for the array queue
			GUI.queueObj = new ArrayQueue();
			setVisible(false);
		}
	}
	
	/*Purpose: The purpose of this method is to check that the size field has valid integer values
	 * @return It returns a boolean value on whether or not the number is valid
	 */
	private boolean isNumber(){
		return sizeField.isValidNumber();
	}
	
	/*Purpose: The purpose of this method is to error check that the size field is a valid size
	 * @param Number This is the number being checked
	 */
	public static void checkNumber(int Number){
		if(Number <= 0)
			throw new IllegalArgumentException("This Number Is Less Than Or Equal To 0!");
	}
	
}
