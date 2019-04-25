package RPNEuation;

//MouLue Huang
//CECS 274-05
//Program 5- RPN equation
//October 27, 2018
import java.util.ArrayList;
public class Stack<typeA>{
	
	private ArrayList<typeA> stackOne;
	
	public Stack() { //create an object
		stackOne = new ArrayList<typeA>(); //a stack that is created from an ArrayList <type A>
											//is a placeholder of what the ArrayList is composed of. 
	}
	//add an object into the stack
	public void push(typeA object) {
		stackOne.add(object); 
	}
	//remove the last item out of the stack
	public typeA pop() {
		if (!stackOne.isEmpty()) {
			return stackOne.remove(stackOne.size()-1);
		}
		else {
			return null;	
		}
	}
	
	public boolean isEmpty() {
		return (stackOne.size() == 0);
	}
	//peek at the last item of the card
	public typeA peek() {
		if (!stackOne.isEmpty()) {
			return (stackOne.get(stackOne.size()-1));
		} 
		else {
			return null;
		}
		
	}

	public int size() {
		return stackOne.size();
	}
	
	
}
