package calcSimple;

import java.util.Scanner;

public class CalcProgramm {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		char op = 0;
		System.out.println("Gib abwechselnd eine Zahl und einen Operator ein ('=' zum Abschliessen): ");
		int zahl = getZahl();
		Calculator calc = new Calculator(zahl);

		do {
			op = getOperator();
			if (op != '=') {
				zahl = getZahl();
				try {
					calc.processOperation(op, zahl);
					System.out.printf(">>>>> Akt. Berechnung: %s, Zwischenergebnis: %d\n", calc.getCurrentCalculation(), calc.getResult());
					
				} catch (IllegalArgumentException e) {
					System.err.println("Fehler bei der Berechnung: " + e.getMessage());
					System.out.println("Setze mit einem Operator fort");
				}
			}
		} while (op != '=');
		System.out.printf("Das Ergebnis ist %d%n", calc.getResult());
	}

	static char getOperator() {
		char op = input.nextLine().charAt(0);
//		while (op != '+' && op != '-' && op != '*' && op != '/' && op != '=') {
//			System.out.println("Ungültiger Operator! Neue Eingabe: ");
//			op = input.nextLine().charAt(0);
//		}
		return op;
	}


	static int getZahl() {
		int zahl = input.nextInt();
		input.nextLine();
		return zahl;
	}


}
