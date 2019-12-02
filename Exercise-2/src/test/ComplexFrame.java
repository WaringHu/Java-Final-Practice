package test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ComplexFrame extends JFrame implements ActionListener{
	JFrame jframe;
	JPanel jpanel1,jpanel2,jpanel3,jpanel4;
    JButton jbutton;
    Container container;
    JLabel jlabel1,jlabel2,jlabel3,jlabel4,jl1,jl2,jlabel5,jla5,jlab5,j1,j2,j3;
    JTextField jtextfield1,jtextfield2,jtextfield3,jtextfield4,jtextfield5;
    JTextArea jtextarea1,jtextarea2;
    public ComplexFrame() {
   	 jframe = new JFrame("复数计算");//标题
   	 jframe.setBounds(1200,200,600,400);//界面大小和位置
   	 container = jframe.getContentPane();
   	 jframe.addWindowListener(new WindowAdapter() {//关闭窗口
	    public void windowClosing(WindowEvent e)
		{
		 System.exit(0);
		}
		});
   	 jbutton = new JButton("=");
   	 jbutton.setFont(new Font("",1,30));//设置字体大小
   	 jlabel1 = new JLabel("复数1:");
   	 jlabel1.setFont(new Font("",1,30));//设置字体大小
   	 jlabel1.setHorizontalAlignment(JLabel.CENTER);//居中显示
   	 jlabel2 = new JLabel("运算符:");
   	 jlabel2.setFont(new Font("",1,30));//设置字体大小
   	 jlabel2.setHorizontalAlignment(JLabel.CENTER);//居中显示
   	 jlabel3 = new JLabel("复数2:");
   	 jlabel3.setFont(new Font("",1,30));//设置字体大小
   	 jlabel3.setHorizontalAlignment(JLabel.CENTER);//居中显示
   	 jlabel4 = new JLabel("+");
   	 jlabel4.setFont(new Font("",1,30));//设置字体大小
   	 jlabel4.setHorizontalAlignment(JLabel.CENTER);//居中显示
   	 jl1 = new JLabel("+");
   	 jl1.setFont(new Font("",1,30));//设置字体大小
   	 jl1.setHorizontalAlignment(JLabel.CENTER);//居中显示
   	 jl2 = new JLabel("+");
   	 jl2.setFont(new Font("",1,30));//设置字体大小
   	 jl2.setHorizontalAlignment(JLabel.CENTER); //居中显示
   	 jlabel5 = new JLabel("i");
   	 jlabel5.setFont(new Font("",1,30));//设置字体大小
   	 jlabel5.setHorizontalAlignment(JLabel.CENTER);//居中显示
   	 jla5 = new JLabel("i");
   	 jla5.setFont(new Font("",1,30));//设置字体大小
   	 jla5.setHorizontalAlignment(JLabel.CENTER); //居中显示
   	 jlab5 = new JLabel("i");
   	 jlab5.setFont(new Font("",1,30));//设置字体大小
     jlab5.setHorizontalAlignment(JLabel.CENTER);//居中显示
   	 j1 = new JLabel();//为了调整界面设的空标签
   	 j2 = new JLabel();//为了调整界面设的空标签
   	 j3 = new JLabel();//为了调整界面设的空标签
   	 jtextfield1 = new JTextField(100);
   	 jtextfield1.setFont(new Font("",1,30));//设置字体大小
   	 jtextfield1.setHorizontalAlignment(JTextField.CENTER);//输入的字符居中显示
   	 jtextfield2 = new JTextField();
   	 jtextfield2.setFont(new Font("",1,30));//设置字体大小
   	 jtextfield2.setHorizontalAlignment(JTextField.CENTER);//输入的字符居中显示
   	 jtextfield3 = new JTextField();
   	 jtextfield3.setFont(new Font("",1,30));//设置字体大小
   	 jtextfield3.setHorizontalAlignment(JTextField.CENTER);//输入的字符居中显示
   	 jtextfield4 = new JTextField();
   	 jtextfield4.setFont(new Font("",1,30));//设置字体大小
   	 jtextfield4.setHorizontalAlignment(JTextField.CENTER);//输入的字符居中显示
   	 jtextfield5 = new JTextField();
   	 jtextfield5.setFont(new Font("",1,30));//设置字体大小
   	 jtextfield5.setHorizontalAlignment(JTextField.CENTER);//输入的字符居中显示
   	 jtextarea1 = new JTextArea();
   	 jtextarea1.setFont(new Font("",1,30));//设置字体大小 
   	 jtextarea2 = new JTextArea();
   	 jtextarea2.setFont(new Font("",1,30));//设置字体大小
   	 jpanel1 = new JPanel();
   	 jpanel2 = new JPanel();
   	 jpanel3 = new JPanel();
   	 jpanel4 = new JPanel();
   	 jpanel1.setLayout(new GridLayout(1,5));
   	 jpanel1.add(jlabel1);jpanel1.add(jtextfield1);jpanel1.add(jl1);jpanel1.add(jtextfield2);jpanel1.add(jla5);
   	 jpanel2.setLayout(new GridLayout(1,5));
   	 jpanel2.add(jlabel2);jpanel2.add(j1);jpanel2.add(jtextfield3);jpanel2.add(j2);jpanel2.add(j3);
   	 jpanel3.setLayout(new GridLayout(1,5));
   	 jpanel3.add(jlabel3);jpanel3.add(jtextfield4);jpanel3.add(jl2);jpanel3.add(jtextfield5);jpanel3.add(jlab5);
   	 jpanel4.setLayout(new GridLayout(1,5));
   	 jpanel4.add(jbutton);jpanel4.add(jtextarea1);jpanel4.add(jlabel4);jpanel4.add(jtextarea2);jpanel4.add(jlabel5);
   	 container.setLayout(new GridLayout(4,1));
	 container.add(jpanel1);
	 container.add(jpanel2);
	 container.add(jpanel3);
	 container.add(jpanel4);
   	 jframe.setVisible(true);
   	 jbutton.addActionListener(this);//给“=”按钮建立监听器
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jbutton)
		{
			int x,y,a,b;
			x = new Integer(jtextfield1.getText());
			a = new Integer(jtextfield2.getText());
			String s = jtextfield3.getText();
			y = new Integer(jtextfield4.getText());
			b = new Integer(jtextfield5.getText());
			if(s.equals("+"))//做加法运算
			{
				jtextarea1.setText(String.valueOf(x+y));
			    jtextarea2.setText(String.valueOf(a+b));
			}
			else if(s.equals("-"))//做减法运算
			{
				jtextarea1.setText(String.valueOf(x-y));
			    jtextarea2.setText(String.valueOf(a-b));
			}
			else if(s.equals("*"))//做乘法运算
			{
				jtextarea1.setText(String.valueOf(x*y-a*b));
				jtextarea2.setText(String.valueOf(x*b+y*a));
			}
			else
			{
				//不做任何操作
			}
			
		}
		else
		{
			//不做任何操作
		}
	}
}
