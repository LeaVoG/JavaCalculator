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
		// TODO �Զ����ɵķ������
		if (e.getActionCommand().equals("�л��� ��ѧ��"))		//�ӱ�׼�͵���ѧ��
		{
			CalculatorUI cui=new CalculatorUI();
			cui.UI2();
			jf.setVisible(false);
		}
		else if (e.getActionCommand().equals("�л��� ��׼��"))		//�ӿ�ѧ�͵���׼��
		{
			CalculatorUI cui=new CalculatorUI();
			cui.UI();
			jf.setVisible(false);
		}
	}

}
