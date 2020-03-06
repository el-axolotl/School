package dijkstra2stack;

import java.util.Scanner;

import edu.princeton.cs.algs4.Stack;

/**
 * Demonstrates how to use Dijkstra's 2-stack algorithm.
 * 
 * @author christopher munoz
 *
 */
public class Dijkstra2Stack {

	private static Stack<Integer> value = new Stack<Integer>();
	private static Stack<Operator> operator = new Stack<>();
	private static Operator c;

	public static void main(String[] args) {
		System.out.println(evaluate("( ( 2 + 4 ) / 2 )"));
	}

	/**
	 * Evaluates the expression using Dijkstra's two-stack algorithm.
	 * 
	 * @param expression
	 * @return
	 */
	public static int evaluate(String expression) {

		/**
		 * Used to split up String expression and remove spaces.
		 */
		String[] temp = expression.split(" ");

		for (String el : temp) {

			/**
			 * Each String el is being treated as a char and not a string.
			 */
			switch (el.charAt(0)) {
			case ')':

				/**
				 * Created two local variables to hold values from stack. The {c} variable is a
				 * field so I can return it at the end of the method, and holds the values from
				 * operator stack.
				 */
				int b = value.pop();
				int a = value.pop();
				c = operator.pop();

				/**
				 * The if statements below take 2 values from the value stack and 1 value from
				 * the operator stack, calculates the expression, then pushes the result onto
				 * the value stack again.
				 */
				if (c.equals(Operator.ADD)) {
					value.push(c.apply(a, b));
				}

				if (c.equals(Operator.SUBTRACT)) {
					value.push(c.apply(a, b));
				}

				if (c.equals(Operator.MULT)) {
					value.push(c.apply(a, b));
				}

				if (c.equals(Operator.DIV)) {
					value.push(c.apply(a, b));
				}
				break;

			case '+':
				operator.push(Operator.ADD);
				break;
			case '-':
				operator.push(Operator.SUBTRACT);
				break;
			case '*':
				operator.push(Operator.MULT);
				break;
			case '/':
				operator.push(Operator.DIV);
				break;

			/**
			 * If the char variable is a digit, it pushes it onto the value stack.
			 */
			default:
				if (Character.isDigit(el.charAt(0)))
					value.push(Integer.valueOf(el));
			}
		}
		
		/**
		 * Returns the last value on the value stack, which would be the answer to the whole expression.
		 */
		return value.pop();
	}

}
