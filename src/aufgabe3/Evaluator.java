package expressionevaluation;

import java.util.Scanner;

/**
 * Klasse zum Auswerten von arithmetischen Ausdrücken.
 * O. Bittel; 22.03.2018
 */
public class Evaluator {

	private static final String ANSI_BLUE = "\u001B[34m";
	
	private static final Object[] stack = new Object[100]; // Stack
	private static int size = 0;   // Anzahl Elemente im Stack
	
	private static Object token;
	private static Tokenizer tokenizer;

	/**
	 * Wertet expr als arithmetischen Ausdruck aus.
	 *
	 * @param expr Arthmetischer Ausdruck als String
	 * @return Wert des Ausdrucks oder null, falls der Ausdruck fehlerhaft ist.
	 */
	public static Double eval(String expr) {
		size = 0;
		tokenizer = new Tokenizer(expr);
		token = tokenizer.nextToken();
		
		while (token != null) {
			// Ihr Code:
			// ...
		}
		
		return null;
	}

	private static boolean shift() {
		// Prüfe, ob shift gemacht werden muss und führe shift durch.
		// Liefere true zurück, falls shift gemacht wurde, sonst false.
		
		// Ihr Code:
		// ...
		return true;
	}

	private static void doShift() {
		System.out.println("shift");
		
		// Ihr Code:
		// ...
	}
	
	private static boolean reduce() {
		// Prüfe ob reduce gemacht werden muss und führe reduce durch.
		// Liefere true zurück, falls reduce gemacht wurde, sonst false.
		
		// Ihr Code:
		// ...
		return true;
	}
	
	private static void doReduceKlAufValKlZu() {
		System.out.println("reduce ( val )");
		
		// Ihr Code:
		// ...
	}

	private static void doReduceValOpVal() {
		System.out.println("reduce val op val");
		
		// Ihr Code:
		// ...
	}
	
	private static boolean accept() {
		// Prüfe ob accept vorliegt und liefere true zurück, sonst false.
		
		// Ihr Code:
		// ...
		return true;
	}

	private static boolean isKlAuf(Object o) {
		return o instanceof String && ((String) o).equals("(");
	}

	private static boolean isKlZu(Object o) {
		return o instanceof String && ((String) o).equals(")");
	}

	private static boolean isPlus(Object o) {
		return o instanceof String && ((String) o).equals("+");
	}

	private static boolean isMinus(Object o) {
		return o instanceof String && ((String) o).equals("-");
	}

	private static boolean isMult(Object o) {
		return o instanceof String && ((String) o).equals("*");
	}

	private static boolean isDiv(Object o) {
		return o instanceof String && ((String) o).equals("/");
	}
	
	private static boolean isDollar(Object o) {
		return o instanceof String && ((String) o).equals("$");
	}

	private static boolean isOp(Object o) {
		if (!(o instanceof String))
			return false;
		String s = (String) o;
		return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
	}

	private static boolean isVal(Object o) {
		return o instanceof Double;
	}


	/**
	 * Liest von der Konsole eine Folge von Zeilen, wertet jede Zeile als
	 * Ausdruck aus und gibt seinen Wert aus. (repl = read-evaluate-print-loop).
	 */
	public static void repl() {
		Scanner in = new Scanner(System.in);
		System.out.print(ANSI_BLUE + ">> ");
		
		while (in.hasNextLine()) {
			String line = in.nextLine();
			// Ihr Code:
			// ...
		}
	}

	/**
	 * Testprogramm.
	 *
	 * @param args wird nicht benutzt.
	 */
	public static void main(String[] args) {
		// Tests:
		String s1 = "(2+3*4-4)/2";
		String s2 = "(2+3*4-4))/2";
		String s3 = "(2+3*4-4)//2";
		String s4 = "1/2*2";
		String s5 = "1+2";

		System.out.println(eval(s1));	// 5.0
		System.out.println(eval(s2));	// null; Syntaxfehler
		System.out.println(eval(s3));	// null; Syntaxfehler
		System.out.println(eval(s4));	// 1.0
		System.out.println(eval(s5));	// 3.0
		
		// read-evaluate-print-loop:
		repl();
	}
}
