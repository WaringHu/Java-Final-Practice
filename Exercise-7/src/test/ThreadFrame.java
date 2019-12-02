package test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ThreadFrame implements ActionListener{
	JFrame jframe;
	Container container;
	JPanel jpanel1;
    JPanel jpanel2;
	JPanel jpanel3;
	JPanel jpanel4;
    JPanel jpanel5;
	JLabel jlabel1;
	JLabel jlabel2;
	JLabel jlabel3;
	JLabel jlabel4;
	JTextField jtextfield1;
	JTextField jtextfield2;
	JProgressBar jprogressbar;//进度条
	JButton jbutton;
	public ThreadFrame() {
		jframe = new JFrame("多线程实验1-阶乘计算");
		jframe.setBounds(400, 100, 400, 250);
		container = jframe.getContentPane();
		jframe.setResizable(false);
		//关闭窗口
        jframe.addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent e)
		{
		 System.exit(0);
		}
		});
	   //
		jlabel1 = new JLabel("多线程实验1-阶乘计算");
		jlabel1.setForeground(Color.RED);
		jlabel1.setFont(new Font("Dialog",1,25));//设置标签字体大小
		//
		jlabel2 = new JLabel("计算线程");
		jlabel3 = new JLabel("返回线程");
		jlabel4 = new JLabel("计算进度");
		jtextfield1 = new JTextField(20);//文本框的长度
		jtextfield2 = new JTextField(20);
	    jprogressbar = new JProgressBar(0,10);//进度条的范围
		jprogressbar.setPreferredSize(new Dimension(200,22));//进度条的大小
		jpanel1 = new JPanel();
		jpanel2 = new JPanel();
		jpanel3 = new JPanel();
		jpanel4 = new JPanel();
		jpanel5 = new JPanel();
		//
		jbutton = new JButton("开始计算");
		jbutton.addActionListener(this);
		//
		jpanel1.add(jlabel1);
		jpanel2.add(jlabel2);jpanel2.add(jtextfield1);
		jpanel3.add(jlabel3);jpanel3.add(jtextfield2);
		jpanel4.add(jlabel4);jpanel4.add(jprogressbar);
		jpanel5.add(jbutton);
		//将五个面板按五行一列布局
		container.setLayout(new GridLayout(5,1));
		container.add(jpanel1);
		container.add(jpanel2);
		container.add(jpanel3);
		container.add(jpanel4);
		container.add(jpanel5);
		jframe.setVisible(true);
		}
		public void actionPerformed(ActionEvent arg0) {
		ThreadCompute jthread = new ThreadCompute(this);//实现Runnable接口建立线程
		Thread thread1 = new Thread(jthread);
		ThreadReturn thread2 = new ThreadReturn(this);//继承Thread建立线程
		thread1.start();//调用start()方法
		thread2.start();
	}

}
