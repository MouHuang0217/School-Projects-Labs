package RPNEuation;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Parser {
	//check if its an int to determine if it should be converted to an integer/
	public static boolean isNumber(String str) {
		for (int i=0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))){
	            return false;
	        }
	    }
	    return true;
	}
	
	public static ArrayList<Object> convertRPN (String[] token) {
		//dictionary to create a "precedence"
		Map <String, Integer> precedence = new HashMap<>(); 
		precedence.put("^", 4);
		precedence.put("*", 3);
		precedence.put("/", 3);
		precedence.put("+", 2);
		precedence.put("-", 2);
		precedence.put("(", 1); // ) isnt included because it doesn't really get added into the stack
		
		ArrayList<Object> queue = new ArrayList<Object>();
		
		Stack<String> symStack = new Stack<String> (); 	
		
		for (String i : token) {
			if (isNumber(i)) { //if its a number, goes straight to the queue
				queue.add(Integer.parseInt(i)); //convert to integer
				continue;
			}
			if (i.equals("(")) { //if its a ( then goes to queue as well
				symStack.push(i);
				continue;
			} 
			if (i.equals(")")) { //when it is a ) go through and seek the top of the stack and as long it isn't "(" then add the top of the stack
				while (!symStack.peek().equals("(")){
					queue.add(symStack.pop());
				}
				symStack.pop(); //pop "(" out
				continue;
			}
			//while symStack is empty and the precedence of the value on top of the stack is greater than the precedence,
			//pop the stack
			if (precedence.containsKey(i)) { //checks if the operators are part of the dictionary
				while (!symStack.isEmpty() && precedence.get(i) <= precedence.get(symStack.peek())) { //if the stack is not empty and the precedence of the top of the stack is greater than the one trying to get added
					queue.add(symStack.pop());
				}
				symStack.push(i); //if the precedence is greater than the one on top of the list or stack is empty.
				continue;
			
			}
		}
		
		while (!symStack.isEmpty()) { //after everything if there still something in the list, pop and add to the end of the queue.
			queue.add(symStack.pop());
		}
		System.out.print("RPN: ");
		for (Object object : queue) {
			System.out.print(object + " "); 
		}  
		return queue;
		
	}
	public static int calcRPN (ArrayList<Object> queueList) {
		Stack<Object> calcStack = new Stack<Object> (); 
		
		System.out.print("\nCalculate:");
		for (Object i : queueList) {
			if (i instanceof Integer) {
				calcStack.push(i);
			}
			if (i.equals("+")){
				int x = (int)calcStack.pop();
				int y = (int)calcStack.pop();
				int sum = y + x;
				calcStack.push(sum);	
			}
			if(i.equals("-")) {
				int x = (int)calcStack.pop();
				int y = (int)calcStack.pop();
				int diff = y - x;
				calcStack.push(diff);	
			}
			if(i.equals("*")) {
				int x = (int)calcStack.pop();
				int y = (int)calcStack.pop();
				int prod = y * x;
				calcStack.push(prod);
			}
			if(i.equals("/")) {
				int x = (int)calcStack.pop();
				int y = (int)calcStack.pop();
				int divide = y/ x;
				calcStack.push(divide);
			}
			if (i.equals("^")) {
				int x = (int)calcStack.pop();
				int y = (int)calcStack.pop();
				int exp = (int) Math.pow(y ,x);
				calcStack.push(exp);
			}
			
			
		}
		
		return (int)calcStack.pop();
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String expr;
		System.out.print("Enter your equation: ");
		expr = in.nextLine();
		
		String exprCopy = expr;
		
		exprCopy = exprCopy.replaceAll("\\+", " + ");
		exprCopy = exprCopy.replaceAll("\\-", " - ");
		exprCopy = exprCopy.replaceAll("\\*", " * ");
		exprCopy = exprCopy.replaceAll("\\/", " / ");
		exprCopy = exprCopy.replaceAll("\\(", " ( ");
		exprCopy = exprCopy.replaceAll("\\)", " ) ");
		exprCopy = exprCopy.replaceAll("\\^", " ^ ");
		String delims = "[ ]+"; // one or more spaces
		String[] token = exprCopy.split(delims);

		ArrayList<Object> queueList = convertRPN(token);
		int answer = calcRPN(queueList);
		System.out.print((double)answer);
		in.close();
	}
	

}
