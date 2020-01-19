/*********************************************************************************************************************
     **
     **  Evaluation of Postfix and prefix expression
     **  Input Postfix and Prefix expression must be in a desired format. 
     **  Operands and operator, both must be single character.
     **  Only '+'  ,  '-'  , '*', '/'  operators are expected. 
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/


import java.util.*;

class EvaluationPostfixPrefix 
{
	public static void main(String[] args)
	{
		String exp="2345*-+";
		System.out.println("POSTFIX EVALUATION : "+ postfix(exp));

		exp="+2-3*45";
		System.out.println("PREFIX EVALUATION : "+ prefix(exp));

	}
	private static int postfix(String exp)
	{
		Stack<Integer> stack=new Stack();

		for(int i=0;i<exp.length();i++)
		{
			if(isOperand(exp.charAt(i)))
				stack.push(exp.charAt(i)-48);
			else 
			{
				int op1 = stack.pop();
				int op2 = stack.pop();
				int res = perform(op2,op1,exp.charAt(i));
				stack.push(res);
			}
		}
		return stack.pop();
	}

	private static int prefix(String exp)
	{
		Stack<Integer> stack=new Stack();

		for(int i=exp.length()-1;i>=0;i--)
		{
			if(isOperand(exp.charAt(i)))
				stack.push(exp.charAt(i)-48);
			else 
			{
				int op1 = stack.pop();
				int op2 = stack.pop();
				int res = perform(op1,op2,exp.charAt(i));
				stack.push(res);
			}
		}
		return stack.pop();
	}
	private static boolean isOperand(char c)
	{
		if(c>47 && c< 58)
			return true;
		return false;
	}
	private static int perform(int op1, int op2, char c)
	{
		switch (c)
		{
			case '+': return op1+op2;
			case '-': return op1-op2;
			case '*': return op1*op2;
			case '/': return op1/op2;				
		}
		return 0;
	}

}