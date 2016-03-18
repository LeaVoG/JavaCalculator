package calculator_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Stack;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ScienceCalculate implements ActionListener {

	private JTextField jtf1;
	
	public static boolean flag=false;
	
	public ScienceCalculate(JTextField jtf)
	{
		jtf1=jtf;
	}
	
	private static boolean isSpecial(String s)
	{
		if (s.equals("s")) return true;
		if (s.equals("c")) return true;
		if (s.equals("t")) return true;
		if (s.equals("l")) return true;
		return false;
	}
	
	private static double special(String s, double b)
	{
		switch (s.charAt(0))
		{
		case 's':return Math.sin(b);
		case 'c':return Math.cos(b);
		case 't':return Math.tan(b);
		case 'l':return Math.log(b);
		}
		return -1;
	}

	public static double scienceCalculate(String s)
	{	
		Stack<String> st1=new Stack<String>();		//建立数字栈
		Stack<String> st2=new Stack<String>();		//建立运算符栈
try{
		int i=0;
		while (i<s.length())	//数据入栈
		{
 			if (s.charAt(i)>='0' && s.charAt(i)<='9')		//数字入栈
 			{
 				int j=i;
 				while (i<s.length() && (s.charAt(i)=='.' || (s.charAt(i)>='0' && s.charAt(i)<='9'))) ++i;
 				st1.push(s.substring(j,i));
 			}
 			
 			if (i<s.length() && (s.charAt(i)=='('))			//运算符入栈，入栈前对栈内比其优先级高的运算符进行处理
 			{
 				st2.push(s.substring(i,i+1));
 			}
 			
 			else if (i<s.length() && isSpecial(s.substring(i,i+1)))
 			{
 				st2.push(s.substring(i,i+1));
 				switch (s.charAt(0))
 				{
 				case 's':i+=2; break;
 				case 'c':i+=2; break;
 				case 't':i+=2; break;
 				case 'l':i++;  break;
 				}
 			}
 			
 			else if (i<s.length() && (s.charAt(i)==')'))
 			{
 				while (!st2.empty() && (st2.peek().equals("^") || st2.peek().equals("-") || st2.peek().equals("+") || st2.peek().equals("/") || st2.peek().equals("*") || isSpecial(st2.peek())))
 				{
 					if (st2.peek().equals("*"))
 					{
 						st2.pop();
 						double b1=Double.parseDouble(st1.pop());
 						double b2=Double.parseDouble(st1.pop());
 						st1.push(Double.toString(b1*b2));
 					}
 					else if (st2.peek().equals("/"))
 					{
 						st2.pop();
 						double b1=Double.parseDouble(st1.pop());
 						double b2=Double.parseDouble(st1.pop());
 						st1.push(Double.toString(b2/b1));
 					}
 					else if (st2.peek().equals("+"))
 					{
 						st2.pop();
 						double b1=Double.parseDouble(st1.pop());
 						double b2=Double.parseDouble(st1.pop());
 						st1.push(Double.toString(b1+b2));
 					}
 					else if (st2.peek().equals("-"))
 					{
 						st2.pop();
 						double b1=Double.parseDouble(st1.pop());
 						double b2=Double.parseDouble(st1.pop());
 						st1.push(Double.toString(b2-b1));
 					}
 					else if (st2.peek().equals("^"))
 					{
 						st2.pop();
 						double b1=Double.parseDouble(st1.pop());
 						double b2=Double.parseDouble(st1.pop());
 						st1.push(Double.toString(Math.pow(b2, b1)));
 					}
 					else if (isSpecial(st2.peek()))
 					{			
 						double b1=Double.parseDouble(st1.pop());
 						st1.push(Double.toString(special(st2.pop(), b1)));
 					}
 				}
 				if (st2.peek().equals("("))
				{
					st2.pop();
				}
 			}
 			
 			else if (i<s.length() && (s.charAt(i)=='^'))
 			{
 				st2.push(s.substring(i,i+1));
 			}
 			
 			else if (i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-'))
 			{
 				while (!st2.empty() && (st2.peek().equals("*") || st2.peek().equals("/") || st2.peek().equals("^") || isSpecial(st2.peek())))
 				{
 					if (st2.peek().equals("*"))
 					{
 						st2.pop();
 						double b1=Double.parseDouble(st1.pop());
 						double b2=Double.parseDouble(st1.pop());
 						st1.push(Double.toString(b1*b2));
 					}
 					else if (st2.peek().equals("/"))
 					{
 						st2.pop();
 						double b1=Double.parseDouble(st1.pop());
 						double b2=Double.parseDouble(st1.pop());
 						st1.push(Double.toString(b2/b1));
 					}
 					else if (st2.peek().equals("^"))
 					{
 						st2.pop();
 						double b1=Double.parseDouble(st1.pop());
 						double b2=Double.parseDouble(st1.pop());
 						st1.push(Double.toString(Math.pow(b2, b1)));
 					}
 					else if (isSpecial(st2.peek()))
 					{			
 						double b1=Double.parseDouble(st1.pop());
 						st1.push(Double.toString(special(st2.pop(), b1)));
 					}
 				}
 				st2.push(s.substring(i,i+1));
 			}
 			
 			if (i<s.length() && (s.charAt(i)=='*' || s.charAt(i)=='/'))
 			{
 				while (!st2.empty() && (st2.peek().equals("^")))
				{
					if (st2.peek().equals("^"))
					{
						st2.pop();
 						double b1=Double.parseDouble(st1.pop());
	 					double b2=Double.parseDouble(st1.pop());
	 					st1.push(Double.toString(Math.pow(b2, b1)));
					}
					else if (isSpecial(st2.peek()))
 					{			
 						double b1=Double.parseDouble(st1.pop());
 						st1.push(Double.toString(special(st2.pop(), b1)));
 					}
				}
 				st2.push(s.substring(i,i+1));
 			}
 			
 			++i;
		}
		
		while (!st2.empty())		//计算栈内剩余元素
		{
			if (st2.peek().equals("*"))
			{
				st2.pop();
				double b1=Double.parseDouble(st1.pop());
				double b2=Double.parseDouble(st1.pop());
				st1.push(Double.toString(b1*b2));
			}
			else if (st2.peek().equals("/"))
			{
				st2.pop();
				double b1=Double.parseDouble(st1.pop());
				double b2=Double.parseDouble(st1.pop());
				st1.push(Double.toString(b2/b1));
			}
			else if (st2.peek().equals("+"))
			{
				st2.pop();
				double b1=Double.parseDouble(st1.pop());
				double b2=Double.parseDouble(st1.pop());
				st1.push(Double.toString(b1+b2));
			}
			else if (st2.peek().equals("-"))
			{
				st2.pop();
				double b1=Double.parseDouble(st1.pop());
				double b2=Double.parseDouble(st1.pop());
				st1.push(Double.toString(b2-b1));
			}
			else if (st2.peek().equals("^"))
			{
				st2.pop();
				double b1=Double.parseDouble(st1.pop());
				double b2=Double.parseDouble(st1.pop());
				st1.push(Double.toString(Math.pow(b2, b1)));
			}
			else if (isSpecial(st2.peek()))
			{			
				double b1=Double.parseDouble(st1.pop());
				st1.push(Double.toString(special(st2.pop(), b1)));
			}
			
		}
		return Double.parseDouble(st1.pop());		//返回数据栈的栈顶元素
}
catch (Exception e)
{
	JOptionPane.showMessageDialog(null, "输入有误", "输入有误", JOptionPane.ERROR_MESSAGE);
	return 0;
}


	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String s1=e.getActionCommand();
		
		String s2=jtf1.getText();
		
		if (s1.equals("C"))		//清空
		{
			s2="0";
			jtf1.setText(s2);
		}
		
		else if (s1.equals("←"))		//退格
		{
			if (s2.length()>1)
			{
				jtf1.setText(s2.substring(0, s2.length()-1));
			}
			else if (s2.length()==1)
			{
				jtf1.setText("0");
			}
		}
		
		else if (s1.equals("="))		//等号
		{
			jtf1.setText(Double.toString(scienceCalculate(s2)));
			flag=true;
		}
		
		else		//输入符号
		{
			if (s2.equals("0") || flag)
			{
				jtf1.setText(s1);
				flag=false;
			}
			else
			{
				s2=s2+s1;
				jtf1.setText(s2);
			}			
		}
	}

}
