package problems;
import java.util.Stack;
public class PostfixEvaluation {

	public static void main(String[] args) {
		String exp="2536+**5/2-";
		double res=convert(exp);
		System.out.println(res);
	}

	private static double convert(String exp) {
		Stack<Double> stack=new Stack<>();
		for(int i=0;i<exp.length();i++) {
			char c=exp.charAt(i);
			if(c=='*' || c=='/' ||c=='+' || c=='-') {
				double o1=stack.pop();
				double o2=stack.pop();
				double temp=evaluate(o1, o2, c);
				stack.push(temp);
			}
			else {
				stack.push((double)(c-'0'));
			}
		}
		double result=stack.pop();
		return result;
		
	}

	private static double evaluate(double a, double b, char operator) {
		switch (operator) {
		case '+':
			return a+b;
		case '*':
			return a*b;
		case '/':
			if(a==0) {
				throw new ArithmeticException("Division by zero!");
			}
			return b/a;
		case '-':
			return b-a;
			
		}
		return 0.0;
	}

}
