package calculator_package;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class KeyScienceCalculate implements KeyListener {
	
	JTextField jtf;
	
	public KeyScienceCalculate(JTextField jtf1)
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
		String s2=jtf.getText();
		
		if (c1=='\b')
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
		
		else if (c1=='=' || c1=='\n')
		{
			jtf.setText(Double.toString(ScienceCalculate.scienceCalculate(s2)));
			ScienceCalculate.flag=true;
		}
		
		else if (c1=='.' || (c1>='0' && c1<='9') || c1=='^' || c1=='+'
				|| c1=='-' || c1=='*' || c1=='/' || c1=='(' || c1==')')
		{
			if (s2.equals("0") || ScienceCalculate.flag)
			{
				jtf.setText(Character.toString(c1));
				ScienceCalculate.flag=false;
			}
			else
			{
				s2=s2+Character.toString(c1);
				jtf.setText(s2);
			}		
		}
		
		else if (c1=='s')
		{
			String s1="sin";
			if (s2.equals("0") || ScienceCalculate.flag)
			{
				jtf.setText(s1);
				ScienceCalculate.flag=false;
			}
			else
			{
				s2=s2+s1;
				jtf.setText(s2);
			}	
		}
		
		else if (c1=='c')
		{
			String s1="cos";
			if (s2.equals("0") || ScienceCalculate.flag)
			{
				jtf.setText(s1);
				ScienceCalculate.flag=false;
			}
			else
			{
				s2=s2+s1;
				jtf.setText(s2);
			}	
		}
		
		else if (c1=='t')
		{
			String s1="tan";
			if (s2.equals("0") || ScienceCalculate.flag)
			{
				jtf.setText(s1);
				ScienceCalculate.flag=false;
			}
			else
			{
				s2=s2+s1;
				jtf.setText(s2);
			}	
		}
		
		else if (c1=='l')
		{
			String s1="ln";
			if (s2.equals("0") || ScienceCalculate.flag)
			{
				jtf.setText(s1);
				ScienceCalculate.flag=false;
			}
			else
			{
				s2=s2+s1;
				jtf.setText(s2);
			}	
		}
	}

}
