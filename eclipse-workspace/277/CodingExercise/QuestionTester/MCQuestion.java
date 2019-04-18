package QuestionTester;

import java.util.ArrayList;

import kapiva.Question;

public class MCQuestion extends Question{
	private ArrayList<String> choices; //initilizes the inherited instance vars

	public MCQuestion(String question) {
		super(question);
		choices = new ArrayList<String>();
	}
	/**
	 * creates a multiplechoice question with given text and correct answer
	 * @param question
	 */
	public MCQuestion(String question, String trueAnswer) {
		super(question,trueAnswer); //initializes the inherited instance
		choices = new ArrayList<String>();
		choices.add(trueAnswer);
	}

	public void addChoice(String choice, boolean isCorrect) {
		choices.add(choice);
		if(isCorrect) {
			super.setAnswer(choice); //updating instance variable
			//in the super class that holds the correct answer to the answer passed in.
		}
	}
	/**
	 * overrides the checkAnswer method in the questino super class
	 */
	
	public boolean checkAnswer(String answer) {
		int c = Integer.parseInt(answer);
		return super.getAnswer().equalsIgnoreCase(choices.get(c-1));
		
	}
	/**
	 * Overrides the display method in Question so that it also 
	 * displays answers options
	 * **/
	public void display() {
		super.display();
		for(int i = 1; i <= choices.size(); i ++) {
			
		}
	}

}
