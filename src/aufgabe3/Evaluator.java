package aufgabe3;

import java.util.EmptyStackException;
import java.util.Scanner;

import static aufgabe3.Tokenizer.*;

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
		push(DOLLAR);
		tokenizer = new Tokenizer(expr);
		token = tokenizer.nextToken();
		while (token != null) {
			// Ihr Code:
			// ...
			if(!shift()) {
				if (!reduce()) {
					if (!accept()) {
						break;
					} else {
						return Double.parseDouble(top().toString());
					}
				}
			}
		}
		return null;
	}

	private static boolean shift() {
		// Prüfe, ob shift gemacht werden muss und führe shift durch.
		// Liefere true zurück, falls shift gemacht wurde, sonst false.
		// Ihr Code:
		// ...

		if (isDollar(top()) && (isKlAuf(token) || isVal(token)) ){				//REGEL 1
			doShift();
			return true;
		} if (	(isOp(top())) && (isKlZu(token) || isVal(token))) {			//REGEL 2
			doShift();
			return true;
		} if ( isKlAuf(top()) && (isKlAuf(top())|| isVal(top())) ) {		//REGEL 3
			doShift();
			return true;
		} if (isVal(top()) && (isOp(token))) {                            //REGEL 6
			Object tmp = pop();
			if (isDollar(top())) {
				push(tmp);
				doShift();
				return true;
			}
			push(tmp);
		} if((isVal(top())) && (isKlZu(token) || isOp(token))){			//REGEL 7
			Object tmp1 = pop();
			if (isKlAuf(top())) {
					push(tmp1);
					doShift();
					return true;
			} else {
				push(tmp1);
			}
		} if (isVal(top()) && (isOp(token))) {												//REGEL 9
			Object tmp1 = pop();
			if(isPlus(top()) || isMinus(top())) {
				Object tmp2 = pop();
				if (isVal(top())) {
					push(tmp2);
					push(tmp1);
					doShift();
					return true;
				} else {
					push(tmp2);
				}
			} else {
				push(tmp1);
			}
		}
		return false;

	}

	private static void doShift() {
		// Ihr Code:
		// ...
			push(token);
			token = tokenizer.nextToken();
	}
	
	private static boolean reduce() {
		// Prüfe ob reduce gemacht werden muss und führe reduce durch.
		// Liefere true zurück, falls reduce gemacht wurde, sonst false.

		//REGEL 4
		if (isKlZu(top()) && (isKlZu(token)|| isOp(token)|| token == DOLLAR)){
			Object tmp1 = pop();
			if(isVal(top())) {
				Object tmp2 = pop();
				if (isKlAuf(top())) {
					push(tmp2);
					push(tmp1);
					doReduceKlAufValKlZu();
					return true;
				} push(tmp2);
			} push(tmp1);
		} if (isVal(top()) && (isKlZu(token)|| isDollar(token))) {			//REGEL 8
			Object tmp1 = pop();
			if (isOp(top())) {
				Object tmp2 = pop();
				if(isVal(top())){
					push(tmp2);
					push(tmp1);
					doReduceValOpVal();
					return true;
				} push(tmp2);
			} push(tmp1);

		} if (isVal(top()) && (isOp(token))) {																//REGEL 9
			Object tmp1 = pop();
			if((isMult(top())|| isDiv(top()))){
				Object tmp2 = pop();
				if(isVal(top())) {
					push(tmp2);
					push(tmp1);
					doReduceValOpVal();
					return true;
				}
				push(tmp2);
			}
			push(tmp1);
		}
		return false;
		// Ihr Code:
		// ...
	}
	
	private static void doReduceKlAufValKlZu() {
		pop();
		Object tmp = pop();
		pop();
		push(tmp);
		// Ihr Code:
		// ...
	}

	private static void doReduceValOpVal() {
		Object v1 = pop();
		Object o = pop();
		Object v2 = pop();
		Double tmp;
		if (isPlus(o)) {
			tmp = Double.parseDouble(v2.toString()) + Double.parseDouble(v1.toString());
			push(tmp);
		} if (isMinus(o)) {
			tmp = Double.parseDouble(v2.toString()) - Double.parseDouble(v1.toString());
			push(tmp);
		} if (isMult(o)) {
			tmp = Double.parseDouble(v2.toString()) * Double.parseDouble(v1.toString());
			push(tmp);
		} if (isDiv(o)) {
			tmp = Double.parseDouble(v2.toString())/ Double.parseDouble(v1.toString());
			push(tmp);
		}
		// Ihr Code:
		// ...
	}
	
	private static boolean accept() {
		// Prüfe ob accept vorliegt und liefere true zurück, sonst false.
		
		// Ihr Code:
		// ...
		if (isVal(top()) && isDollar(token)) {
			Object tmp1 = pop();
			if (isDollar(top())) {
				push(tmp1);
				return true;
			}
			push(tmp1);
		}
		return false;
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
			if (line.equals("end")) {
				System.out.println("bye");
				break;
			}
			if (eval(line) == null) {
				System.out.println("Error");
				continue;
			} else {
				System.out.println(eval(line));
			}

		}
	}

	public static void push(Object x) {
		stack[size++] = x;
	}

	public static Object top() {
			return stack[size - 1];
	}

	public static Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		} else {
			return stack[--size];
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
