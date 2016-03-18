package calculator_package;

import java.awt.*;

import javax.swing.*;

public class CalculatorUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		CalculatorUI cui=new CalculatorUI();
		cui.UI();
	}
	
	public void UI() //��׼��
	{
		JFrame jf1=new JFrame(); 			//ʵ����һ��JFrame�ഴ������
		jf1.setTitle("��׼�ͼ�����"); 		
		jf1.setSize(300,400);
		jf1.setLocation(200,200);			
		jf1.setResizable(false); 			
		jf1.setDefaultCloseOperation(3); 	
		jf1.setLayout(new BorderLayout()); 	
		
		
		
		JPanel jp1=new JPanel();	//ʵ�������
		JPanel jp2=new JPanel();
		//JPanel jp3=new JPanel();	
		
		jp1.setLayout(new FlowLayout());		//����ı���
		JTextField jtf1=new JTextField("0");
		jtf1.setPreferredSize(new Dimension(280,70));
		jtf1.setFont(new Font("����",Font.BOLD,30));
		jtf1.setEditable(false);
		jp1.add(jtf1);
		jf1.add(jp1,"Center");
		
		KeyCalculate kc=new KeyCalculate(jtf1);
		jtf1.addKeyListener(kc);
		
		WindowsControl wc=new WindowsControl(jf1);
		JMenuBar jmb=new JMenuBar();
		JMenu jm=new JMenu("����");
		JMenuItem jmi=new JMenuItem("�л��� ��ѧ��");
		jmi.addActionListener(wc);
		jm.add(jmi);
		jmb.add(jm);
		jf1.add(jmb,"North");
		
		jp2.setLayout(new GridLayout(5,4));		//��Ӱ���
		String s="+-*/789C456E123_0.N=";		//������ֵ�洢���ַ����У�ѭ������
		Calculate c1=new Calculate(jtf1);
		jp2.setPreferredSize(new Dimension(280,260));
		for (int i=0;i<s.length();++i)
		{
			String st=s.substring(i, i+1);
			if (st.equals("E"))		//���ַ����е�Dת��ΪDEL
			{
				st="CE";
			}
			if (st.equals("_"))		//���ַ����е�_ת��Ϊ<-
			{
				st="��";
			}
			if (st.equals("N"))		//���ַ����е�Nת��Ϊ(-)
			{
				st="(-)";
			}
			JButton jb=new JButton(st);
			jb.setFont(new Font("����",Font.BOLD,15));
			jb.addActionListener(c1);
			jp2.add(jb);
		}
		jf1.add(jp2,"South");
		/*
		jp3.setLayout(new FlowLayout());		//����л���
		JButton jb2=new JButton("��ѧ��");
		jb2.setPreferredSize(new Dimension(280,40));
		
		jb2.addActionListener(wc);
		jp3.add(jb2);
		jf1.add(jp3,"South");
		*/
		jf1.setVisible(true);
	}

	public void UI2() //��ѧ��
	{
		JFrame jf1=new JFrame(); 			//ʵ����һ��JFrame�ഴ������
		jf1.setTitle("��ѧ�ͼ�����"); 		
		jf1.setSize(500,400); 				
		jf1.setLocation(200,200);			
		jf1.setResizable(false); 			
		jf1.setDefaultCloseOperation(3); 	
		jf1.setLayout(new BorderLayout()); 	
		
		JPanel jp1=new JPanel();	//ʵ�������
		JPanel jp2=new JPanel();
		//JPanel jp3=new JPanel();	
		
		jp1.setLayout(new FlowLayout());		//����ı���
		JTextField jtf1=new JTextField("0");
		jtf1.setPreferredSize(new Dimension(480,60));
		jtf1.setFont(new Font("����",Font.BOLD,30));
		jtf1.setEditable(false);
		jp1.add(jtf1);
		jf1.add(jp1,"Center");
		
		KeyScienceCalculate kc=new KeyScienceCalculate(jtf1);
		jtf1.addKeyListener(kc);
		
		WindowsControl wc=new WindowsControl(jf1);
		JMenuBar jmb=new JMenuBar();
		JMenu jm=new JMenu("����");
		JMenuItem jmi=new JMenuItem("�л��� ��׼��");
		jmi.addActionListener(wc);
		jm.add(jmi);
		jmb.add(jm);
		jf1.add(jmb,"North");
	
		jp2.setLayout(new GridLayout(5,5));		//��Ӱ���
		String s="s+-*/c789(t456)l123.^0C_=";
		jp2.setPreferredSize(new Dimension(480,270));
		ScienceCalculate c1=new ScienceCalculate(jtf1);
		for (int i=0;i<s.length();++i)
		{
			String st=s.substring(i, i+1);
			if (st.equals("s"))		
			{
				st="sin";
			}
			if (st.equals("c"))		
			{
				st="cos";
			}
			if (st.equals("t"))		
			{
				st="tan";
			}
			if (st.equals("l"))		
			{
				st="ln";
			}
			if (st.equals("_"))		
			{
				st="��";
			}
			JButton jb=new JButton(st);
			jb.setFont(new Font("����",Font.BOLD,15));
			jb.addActionListener(c1);
			jp2.add(jb);
		}
		jf1.add(jp2,"South");
		/*
		jp3.setLayout(new FlowLayout());		//����л���
		JButton jb2=new JButton("��׼��");
		jb2.setPreferredSize(new Dimension(480,40));
		WindowsControl wc=new WindowsControl(jf1);
		jb2.addActionListener(wc);
		jp3.add(jb2);
		jf1.add(jp3,"South");
		*/
		jf1.setVisible(true);
	}
}
