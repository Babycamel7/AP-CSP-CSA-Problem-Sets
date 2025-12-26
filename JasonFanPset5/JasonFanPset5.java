import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class JasonFanPset5<Item> {
	public static void main(String[] args) {
		
	}
	//11 
	public static <Item> void removeDuplicates(ArrayList<Item> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (list.get(i).equals(list.get(j))) {
					list.remove(i);
					i--;
					break;
				}
			}
		}
	}

	//12
	public static boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}
			else if (c == ')' || c == '}' || c == ']') {
				if (stack.isEmpty()) return false;

				char top = stack.pop();
				
				if ((c == ')' && top != '(') || 
					(c == '}' && top != '{') || 
					(c == ']' && top != '[')) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	//13
	public static double evaluate(String s) {
		Stack<Double> operands = new Stack<>();
		Stack<String> operators = new Stack<>();
		s = s.replaceAll("\\s+", "");
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') continue;
			if (Character.isDigit(c) || c == '.') {
				StringBuilder sb = new StringBuilder();
				while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {
                    sb.append(s.charAt(i));
                    i++;
                }
			i--;
			operands.push(Double.parseDouble(sb.toString()));
			}
			else if (c == '+' || c == '-' || c == '/' || c == '*') {
				operators.push(String.valueOf(c));
			}

			else if (c == 's') {
				operators.push("sqrt");
				i += 3;
			}

			else if (c == ')') {
				String op = operators.pop();
				if (op == "sqrt") {
					double v = operands.pop();
					operands.push(Math.sqrt(v));
				}
				else {
					double b = operands.pop();
					double d = operands.pop();

					if (op.equals("+")) operands.push(b + d);
					if (op.equals("-")) operands.push(b - d);
					if (op.equals("*")) operands.push(b * d);
					if (op.equals("/")) operands.push(b / d);
				}
			}
		}
		return operands.pop();
	}

	//14
	public static boolean isNumber(String s) {
		try {
			Double.parseDouble(s);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}
	public static double evaluateRPN(String s) {
		Stack<Double> operands = new Stack<>();
		String[] vals = s.split(" ");
		for (int i = 0; i < vals.length; i++) {
			String c = vals[i];
			if (isNumber(c)) {
				operands.push(Double.parseDouble(c));
			}
			else if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
				String op = String.valueOf(c);

				double b = operands.pop();
				double d = operands.pop();

				if (op.equals("+")) operands.push(d + b);
				if (op.equals("-")) operands.push(d - b);
				if (op.equals("*")) operands.push(d * b);
				if (op.equals("/")) operands.push(d / b);
			}

			else if (c.equals("sqrt")) {
			double v = operands.pop();
				operands.push(Math.sqrt(v));
			}
		}
	return operands.pop();
	}	
	//15 is inside the linked list file

}