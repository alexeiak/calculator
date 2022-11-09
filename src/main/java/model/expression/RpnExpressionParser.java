package model.expression;

import java.util.Stack;

import static model.expression.OperationDetector.CLOSE_BRACKET_PRIORITY;
import static model.expression.OperationDetector.DIGITS_PRIORITY;
import static model.expression.OperationDetector.OPEN_BRACKET_PRIORITY;
import static model.expression.OperationDetector.getPriorityOfSign;

public class RpnExpressionParser {
	static final char NUMBERS_SEPARATOR = ' ';

	public static String expressionToRpn(String expression) {
		StringBuilder rpnExpression = new StringBuilder();
		Stack<Character> operators = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char sign = expression.charAt(i);
			int signPriority = getPriorityOfSign(sign);

			if (signPriority == DIGITS_PRIORITY) {
				rpnExpression.append(sign);
			}
			if (signPriority == OPEN_BRACKET_PRIORITY) {
				operators.push(sign);
			}
			if (signPriority == CLOSE_BRACKET_PRIORITY) {
				rpnExpression.append(NUMBERS_SEPARATOR);
				rpnExpression.append(getOperator(operators));
				operators.pop();
			}
			if (signPriority > OPEN_BRACKET_PRIORITY) {
				rpnExpression.append(NUMBERS_SEPARATOR);
				rpnExpression.append(getOperand(signPriority, operators));
				operators.push(sign);
			}
		}

		while (!operators.empty()) {
			rpnExpression.append(NUMBERS_SEPARATOR);
			rpnExpression.append(operators.pop());
		}
		return rpnExpression.toString();
	}


	private static StringBuilder getOperand(int signPriority, Stack<Character> signs) {
		StringBuilder operand = new StringBuilder();
		while (!signs.empty() && getPriorityOfSign(signs.peek()) >= signPriority) {
			operand.append(signs.pop());
			operand.append(NUMBERS_SEPARATOR);
		}
		return operand;
	}

	private static StringBuilder getOperator(Stack<Character> operators) {
		StringBuilder operator = new StringBuilder();
		while (getPriorityOfSign(operators.peek()) != OPEN_BRACKET_PRIORITY) {
			operator.append(operators.pop());
		}
		return operator;
	}
}
