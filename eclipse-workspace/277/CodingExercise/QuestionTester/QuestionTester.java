package QuestionTester;

import java.util.ArrayList;
import java.util.Scanner;

import kapiva.Question;
public class QuestionTester {
	public static void main(String[] args) {
		ArrayList<Question> quiz = new ArrayList<Question>();
		quiz.add(new Question("What is the capital of CA?","Sacramento"));
		quiz.add(new Question("What is the capital of the U.S.?","Washington D.C."));
		
		MCQuestion mc = new MCQuestion("What animal barks?");
		mc.addChoice("cats", false);
		mc.addChoice("elephant", false);
		mc.addChoice("dog", true);
		mc.addChoice("rhino", false);
		
		quiz.add(mc);
		
		double score = 0;
		Scanner in = new Scanner(System.in);
		for(Question q: quiz) {
			q.display();
			String response = in.nextLine();
			
			boolean isCorrect = q.checkAnswer(response);
			if(isCorrect) {
				System.out.println("Correct!");
				score ++;
			}
			else {
				System.out.println("Sorry that is inccrreoct.");
				System.out.println("Correct answer is:" + q.getAnswer());
			}
		}
	}

}
