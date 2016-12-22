/*Name: Taha Rangwala
 * Date: December 21, 2016
 * Purpose: The purpose of this class is to use an array queue which implements the QueueADT interface
 * which allows it to use the methods of a queue
 */

//ArrayQueue class header
public class ArrayQueue <T> implements QueueADT{
	
	//Declaring private instance variables
	private T queueArray [];//the array queue
	private int Front;//Front of the queue
	private int Rear;//Last value in the queue
	private int Count;//Number of values in the queue
	
	//Constructor method to initialize private instance variables
	public ArrayQueue(){
		queueArray = (T[])(new Object[25]);
		Front = 0;
		Rear = 0;
		Count = 0;
	}
	
	/*Purpose: Constructor method to initialize private instance variables 
	 * @param Size This is the custom size of the array queue the user inputted
	 */
	public ArrayQueue(int Size){
		queueArray = (T[])(new Object[Size]);
		Front = 0;
		Rear = 0;
		Count = 0;
	}

	/*Purpose: This method adds an element to the back of the queue
	 * @param element This is the element being added to the queue
	 */
	public void enqueue(Object element) {
		queueArray[Rear] = (T) element;
		Rear++;
		Count++;
		if(Rear == queueArray.length && Front > 0){
			Rear = 0;
		}
		else if(Rear == queueArray.length)
			expandArray();
	}
	
	/*This method expands the array queue if there is no space left in the array queue when the user
	 tries to input something*/
	private void expandArray(){
		T newArray [] = (T[])(new Object[queueArray.length*2]);
		int length = queueArray.length;
		int oldFront = Front;
		for(int i = 0; i < queueArray.length; i++){
			newArray[i] = queueArray[oldFront];
			oldFront++;
		}
		for(int i = queueArray.length; i < Front; i++){
			newArray[i] = queueArray[Rear];
			Rear++;
		}
		Front = 0;
		Rear = length;
		queueArray = newArray;
	}

	/*Purpose: This method takes the first element of the queue off
	 * @return This returns the element taken off
	 */
	public Object dequeue() {
		if(isEmpty())
			throw new IllegalArgumentException("The Queue Is Empty!");
		T element = queueArray[Front];
		Front++;
		if(Front == queueArray.length)
			Front = 0;
		Count--;
		if(isEmpty()){
			Front = 0;
			Rear = 0;
		}
		return element;
	}

	/*Purpose: This method takes gets the first element in the queue
	 * @return This returns the first element in the queue
	 */
	public Object peekFront() {
		if(isEmpty())
			throw new IllegalArgumentException("The Queue Is Empty!");
		return queueArray[Front];
	}

	/*Purpose: This method gets the size of the queue
	 * @return This returns the size of the queue in an integer value
	 */
	public int size() {
		return Count;
	}

	/*Purpose: This method checks to see if the queue is empty
	 * @return This returns a boolean value of whether or not the queue is empty
	 */
	public boolean isEmpty() {
		return Count <= 0;
	}
	
	/*Purpose: This method gets all of the information in the queue
	 * @return This returns all of the information in the queue in a string value
	 */
	public String toString(){
		String Output = "";
		if(isEmpty())
			throw new IllegalArgumentException("The Queue Is Empty!");
		if(Front < Rear){
			for(int i = Front; i < Rear;i++){
				if(queueArray[i] != null)
					Output += queueArray[i];
			}
		}
		else if(Front > Rear){
			for(int i = Front; i < queueArray.length;i++){
				Output += queueArray[i];
			}
			for(int i = 0; i < Rear; i++){
				Output += queueArray[i];
			}
		}
		else
			Output += queueArray[Front];
		return Output;
	}

}
