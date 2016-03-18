package calculator_package;

import java.awt.*;

import javax.swing.*;

public class CalculatorUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		CalculatorUI cui=new CalculatorUI();
		cui.UI();
	}
	
	public void UI() //标准型
	{
		JFrame jf1=new JFrame(); 			//实例化一个JFrame类创建窗口
		jf1.setTitle("标准型计算器"); 		
		jf1.setSize(300,400);
		jf1.setLocation(200,200);			
		jf1.setResizable(false); 			
		jf1.setDefaultCloseOperation(3); 	
		jf1.setLayout(new BorderLayout()); 	
		
		
		
		JPanel jp1=new JPanel();	//实例化面板
		JPanel jp2=new JPanel();
		//JPanel jp3=new JPanel();	
		
		jp1.setLayout(new FlowLayout());		//添加文本框
		JTextField jtf1=new JTextField("0");
		jtf1.setPreferredSize(new Dimension(280,70));
		jtf1.setFont(new Font("黑体",Font.BOLD,30));
		jtf1.setEditable(false);
		jp1.add(jtf1);
		jf1.add(jp1,"Center");
		
		KeyCalculate kc=new KeyCalculate(jtf1);
		jtf1.addKeyListener(kc);
		
		WindowsControl wc=new WindowsControl(jf1);
		JMenuBar jmb=new JMenuBar();
		JMenu jm=new JMenu("类型");
		JMenuItem jmi=new JMenuItem("切换到 科学型");
		jmi.addActionListener(wc);
		jm.add(jmi);
		jmb.add(jm);
		jf1.add(jmb,"North");
		
		jp2.setLayout(new GridLayout(5,4));		//添加按键
		String s="+-*/789C456E123_0.N=";		//将按键值存储在字符串中，循环创建
		Calculate c1=new Calculate(jtf1);
		jp2.setPreferredSize(new Dimension(280,260));
		for (int i=0;i<s.length();++i)
		{
			String st=s.substring(i, i+1);
			if (st.equals("E"))		//将字符串中的D转换为DEL
			{
				st="CE";
			}
			if (st.equals("_"))		//将字符串中的_转换为<-
			{
				st="←";
			}
			if (st.equals("N"))		//将字符串中的N转换为(-)
			{
				st="(-)";
			}
			JButton jb=new JButton(st);
			jb.setFont(new Font("宋体",Font.BOLD,15));
			jb.addActionListener(c1);
			jp2.add(jb);
		}
		jf1.add(jp2,"South");
		/*
		jp3.setLayout(new FlowLayout());		//添加切换键
		JButton jb2=new JButton("科学型");
		jb2.setPreferredSize(new Dimension(280,40));
		
		jb2.addActionListener(wc);
		jp3.add(jb2);
		jf1.add(jp3,"South");
		*/
		jf1.setVisible(true);
	}

	public void UI2() //科学型
	{
		JFrame jf1=new JFrame(); 			//实例化一个JFrame类创建窗口
		jf1.setTitle("科学型计算器"); 		
		jf1.setSize(500,400); 				
		jf1.setLocation(200,200);			
		jf1.setResizable(false); 			
		jf1.setDefaultCloseOperation(3); 	
		jf1.setLayout(new BorderLayout()); 	
		
		JPanel jp1=new JPanel();	//实例化面板
		JPanel jp2=new JPanel();
		//JPanel jp3=new JPanel();	
		
		jp1.setLayout(new FlowLayout());		//添加文本框
		JTextField jtf1=new JTextField("0");
		jtf1.setPreferredSize(new Dimension(480,60));
		jtf1.setFont(new Font("黑体",Font.BOLD,30));
		jtf1.setEditable(false);
		jp1.add(jtf1);
		jf1.add(jp1,"Center");
		
		KeyScienceCalculate kc=new KeyScienceCalculate(jtf1);
		jtf1.addKeyListener(kc);
		
		WindowsControl wc=new WindowsControl(jf1);
		JMenuBar jmb=new JMenuBar();
		JMenu jm=new JMenu("类型");
		JMenuItem jmi=new JMenuItem("切换到 标准型");
		jmi.addActionListener(wc);
		jm.add(jmi);
		jmb.add(jm);
		jf1.add(jmb,"North");
	
		jp2.setLayout(new GridLayout(5,5));		//添加按键
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
				st="←";
			}
			JButton jb=new JButton(st);
			jb.setFont(new Font("宋体",Font.BOLD,15));
			jb.addActionListener(c1);
			jp2.add(jb);
		}
		jf1.add(jp2,"South");
		/*
		jp3.setLayout(new FlowLayout());		//添加切换键
		JButton jb2=new JButton("标准型");
		jb2.setPreferredSize(new Dimension(480,40));
		WindowsControl wc=new WindowsControl(jf1);
		jb2.addActionListener(wc);
		jp3.add(jb2);
		jf1.add(jp3,"South");
		*/
		jf1.setVisible(true);
	}
}
