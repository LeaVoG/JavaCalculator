package calculator_package;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class KeyCalculate implements KeyListener {
	
	JTextField jtf;
	
	public KeyCalculate(JTextField jtf1)
	{
		this.jtf=jtf1;
	}

	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根

	}

	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根
		
		char c1=e.getKeyChar(); //获得的命令
		
		String s2=jtf.getText(); //文本框的值

		
		if (c1>='0' && c1<='9')
		{
			String s1=Character.toString(c1);
			if (s2.equals("0") || Calculate.flag1)
			{
				s2=s1;
				Calculate.flag1=false;
			}
			else
			{
				s2=s2+s1;
			}
			jtf.setText(s2);
		}
		
		else if (c1=='.')
		{
			if (Calculate.flag1) 
			{
				s2="0.";
				Calculate.flag1=false;
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
			jtf.setText(s2);
		}
		
		else if (c1=='+' || c1=='-' || c1=='*' || c1=='/')
		{
			Calculate.num2=Double.parseDouble(s2);
			switch (Calculate.ch)
			{
			case '+': Calculate.ans=BigDecimalCalculate.add(Calculate.num1,Calculate.num2); break;
			case '-': Calculate.ans=BigDecimalCalculate.sub(Calculate.num1,Calculate.num2); break;
			case '*': Calculate.ans=BigDecimalCalculate.mul(Calculate.num1,Calculate.num2); break;
			case '/': 
				if (Calculate.num2==0) {Calculate.ch='_'; Calculate.ans=0; JOptionPane.showMessageDialog(null, "除数为零", "除数为零", JOptionPane.ERROR_MESSAGE);} 
				else Calculate.ans=BigDecimalCalculate.div(Calculate.num1,Calculate.num2); 
				break;
			}
			if (Calculate.ch=='_')
				jtf.setText("0");
			else
				jtf.setText(Double.toString(Calculate.ans));
			Calculate.num1=Calculate.ans;
			Calculate.ch=(Calculate.ch=='_')?'+':c1;
			Calculate.num2=0;
			Calculate.flag1=true;
		}
		
		else if (c1=='=' || c1=='\n')
		{
			Calculate.num2=Double.parseDouble(s2);
			switch (Calculate.ch)
			{
			case '+': Calculate.ans=BigDecimalCalculate.add(Calculate.num1,Calculate.num2); break;
			case '-': Calculate.ans=BigDecimalCalculate.sub(Calculate.num1,Calculate.num2); break;
			case '*': Calculate.ans=BigDecimalCalculate.mul(Calculate.num1,Calculate.num2); break;
			case '/': 
				if (Calculate.num2==0) {Calculate.ch='_'; Calculate.ans=0; JOptionPane.showMessageDialog(null, "除数为零", "除数为零", JOptionPane.ERROR_MESSAGE);} 
				else Calculate.ans=BigDecimalCalculate.div(Calculate.num1,Calculate.num2); 
				break;
			}
			if (Calculate.ch=='_')
				jtf.setText("0");
			else
				jtf.setText(Double.toString(Calculate.ans));
			Calculate.num1=0;
			Calculate.ch='+';
			Calculate.num2=0;
			Calculate.flag1=true;
		}
		
		else if (c1=='\b')
		{
			if (s2.length()>1)
			{
				jtf.setText(s2.substring(0, s2.length()-1));
			}
			else if (s2.length()==1)
			{
				jtf.setText("0");
			}
		}
	}

}
