package calcSimpleExc;

public class Calculator {
	// Ergebnis
	private int number, result;

	// letzter Operator
	char operator;
	// akt. Berechnung
	private String currentCalculation = "";
	
	public Calculator(int initValue) {
		this.result = initValue;
		currentCalculation = "" + result;
	}

	public int getNumber() {
		return number;
	}

	public char getOperator() {
		return operator;
	}

	public int getResult() {
		return result;
	}

	public String getCurrentCalculation() {
		return currentCalculation;
	}

	public void processOperation(char newOperator, int number) throws CalculationException {

		this.operator = newOperator;
		this.number = number;

		result = calculate(newOperator, result, number);

		// die neuen Eingaben anhängen
		currentCalculation += "" + this.operator + this.number;
	}

	private static int calculate(char op, int n1, int n2) throws CalculationException {
		int newResult = switch (op) {
		case '+' -> n1 + n2;
		case '-' -> n1 - n2;
		case '/' -> {
			if(n2 == 0) {
				throw new CalculationException("Ungültige Operation: Division durch 0");
			}
			yield n1 / n2;
		}
		case '*' -> n1 * n2;
		case '%' -> n1 % n2;
		default -> throw new CalculationException("Unbekannter Operator " + op);
		};

		return newResult;

	}

}
