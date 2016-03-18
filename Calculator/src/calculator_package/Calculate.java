package calculator_package;

import java.awt.event.*;

import javax.swing.*;

public class Calculate implements ActionListener{
	private JTextField jtf1; //从类外传递文本框的引用
	
	public static double num1=0,num2=0,ans=0; //存储数字
	
	public static char ch='+'; //存储运算符
	
	public static boolean flag1=false; //判断是否处于运算过后的状态
	
	
	public Calculate(JTextField jtf)
	{
		jtf1=jtf;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String s1=e.getActionCommand(); //获得的命令
		
		String s2=jtf1.getText(); //文本框的值
		
		if (s1.equals("←")) //退格键
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
		
		else if (s1.equals("0") || s1.equals("1") || s1.equals("2") || s1.equals("3") 
				|| s1.equals("4") || s1.equals("5") || s1.equals("6") 
				|| s1.equals("7") || s1.equals("8") || s1.equals("9"))
			//数字键
		{
			if (s2.equals("0") || flag1)
			{
				s2=s1;
				flag1=false;
			}
			else
			{
				s2=s2+s1;
			}
			jtf1.setText(s2);
		}
		
		else if (s1.equals("CE")) //清除键
		{
			s2="0";
			jtf1.setText(s2);
		}
		
		else if (s1.equals("C")) //重置计算
		{
			s2="0";
			jtf1.setText(s2);
			num1=0; num2=0; 
			ch='+';
		}
		
		else if (s1=="(-)") //相反数
		{
			if (flag1)
			{
				s2="0";
				flag1=true;
			}
			else
			{
				if (s2.charAt(0)=='-')
					s2=s2.substring(1,s2.length());
				else if (!s2.equals("0"))
					s2="-"+s2;
			}
			jtf1.setText(s2);
		}
		
		else if (s1.equals(".")) //小数点
		{
			if (flag1) 
			{
				s2="0.";
				flag1=false;
			}
			else
			{
				boolean flag2=false;
				for (int i=0;i<s2.length();++i)
				{
					if (s2.charAt(i)=='.')
					{
						flag2=true;
					}
				}
				if (!flag2) s2=s2+".";
			}
			jtf1.setText(s2);
		}
		
		else if (s1.equals("+") || s1.equals("-") || s1.equals("*") || s1.equals("/"))
			//运算符
		{
			num2=Double.parseDouble(s2);
			switch (ch)
			{
			case '+': ans=BigDecimalCalculate.add(num1,num2); break;
			case '-': ans=BigDecimalCalculate.sub(num1,num2); break;
			case '*': ans=BigDecimalCalculate.mul(num1,num2); break;
			case '/': 
				if (num2==0) {ch='_'; ans=0; JOptionPane.showMessageDialog(null, "除数为零", "除数为零", JOptionPane.ERROR_MESSAGE);} 
				else ans=BigDecimalCalculate.div(num1,num2); 
				break;
			}
			if (ch=='_')
				jtf1.setText("0");
			else
				jtf1.setText(Double.toString(ans));
			num1=ans;
			ch=(ch=='_')?'+':s1.charAt(0);
			num2=0;
			flag1=true;
		}
		
		else if (s1.equals("="))	//等号
		{
			num2=Double.parseDouble(s2);
			switch (ch)
			{
			case '+': ans=BigDecimalCalculate.add(num1,num2); break;
			case '-': ans=BigDecimalCalculate.sub(num1,num2); break;
			case '*': ans=BigDecimalCalculate.mul(num1,num2); break;
			case '/': 
				if (num2==0) {ch='_'; ans=0; JOptionPane.showMessageDialog(null, "除数为零", "除数为零", JOptionPane.ERROR_MESSAGE);} 
				else ans=BigDecimalCalculate.div(num1,num2); 
				break;
			}
			if (ch=='_')
				jtf1.setText("0");
			else
				jtf1.setText(Double.toString(ans));
			num1=0;
			ch='+';
			num2=0;
			flag1=true;
		}
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
}
