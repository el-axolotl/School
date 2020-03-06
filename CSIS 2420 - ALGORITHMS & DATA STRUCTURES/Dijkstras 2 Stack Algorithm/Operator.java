package dijkstra2stack;

/**
 * Enum with constructor so it can be used in Dijkstra2Stack.evaluate() to
 * compare math operators with char variables.
 * 
 * @author chris.munoz
 *
 */
public enum Operator {
	ADD('+'), SUBTRACT('-'), MULT('*'), DIV('/');

	public char value;

	Operator(char value) {
		this.value = value;
	}

	/**
	 * This method will calculate the expression of int a and int b depending on the
	 * char value.
	 * 
	 * @param a
	 * @param b
	 * @return value of expression depending on char value.
	 */
	public int apply(int a, int b) {
		switch (value) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;
		default:
			throw new IllegalArgumentException("Must be + - * /");
		}
	}
}
