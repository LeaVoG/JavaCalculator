package calculator_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class WindowsControl implements ActionListener {
	
	JFrame jf=new JFrame();
	
	public WindowsControl(JFrame jf1)
	{
		jf=jf1;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getActionCommand().equals("切换到 科学型"))		//从标准型到科学型
		{
			CalculatorUI cui=new CalculatorUI();
			cui.UI2();
			jf.setVisible(false);
		}
		else if (e.getActionCommand().equals("切换到 标准型"))		//从科学型到标准型
		{
			CalculatorUI cui=new CalculatorUI();
			cui.UI();
			jf.setVisible(false);
		}
	}

}
