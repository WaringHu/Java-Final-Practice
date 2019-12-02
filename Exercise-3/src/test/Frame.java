package test;
import java.awt.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
public class Frame {
	public int num1=0,num2=0,result =0;
    public String inString = "";
    public String operString = "";
    JFrame jframe;
    Container contantpane;
    JTextField jTextField;
    //两个Panel
    public JPanel jpanel1 = new JPanel();
    public JPanel jpanel2 = new JPanel();
    //数字键
    public JButton jbutton0 = new JButton("0");
    public JButton jbutton1 = new JButton("1");
    public JButton jbutton2 = new JButton("2");
    public JButton jbutton3 = new JButton("3");
    public JButton jbutton4 = new JButton("4");
    public JButton jbutton5 = new JButton("5");
    public JButton jbutton6 = new JButton("6");
    public JButton jbutton7 = new JButton("7");
    public JButton jbutton8 = new JButton("8");
    public JButton jbutton9 = new JButton("9");
    //运算符键
    public JButton jbt1 = new JButton("+");
    public JButton jbt2 = new JButton("-");
    public JButton jbt3 = new JButton("*");
    public JButton jbt4 = new JButton("/");
    public JButton jbt0 = new JButton("=");
    //复位键
    public JButton jbt = new JButton("清零");
    public Frame()
    {
  	  jframe= new JFrame("计算器");
  	  jframe.setBounds(400,400,300,250);
  	  jframe.setResizable(false);//用户不能改变计算器大小
  	  contantpane = jframe.getContentPane();
  	  //关闭窗口
  	  jframe.addWindowListener(new
  			  WindowAdapter() {
  		  public void windowClosing(WindowEvent e) {
  			  System.exit(0);
  		  }
  	  });
  	  //显示框
  	  jTextField = new JTextField("0",15);
  	  jTextField.setHorizontalAlignment(JTextField.RIGHT);
  	  jpanel2.add(jTextField);
  	  jpanel2.setPreferredSize(new Dimension(400,45));
  	  //数字监听器
  	  NumberAdapter numberAdapter = new NumberAdapter();
  	  jbutton0.addActionListener(numberAdapter);
  	  jbutton1.addActionListener(numberAdapter);
  	  jbutton2.addActionListener(numberAdapter);
  	  jbutton3.addActionListener(numberAdapter);
  	  jbutton4.addActionListener(numberAdapter);
  	  jbutton5.addActionListener(numberAdapter);
  	  jbutton6.addActionListener(numberAdapter);
  	  jbutton7.addActionListener(numberAdapter);
  	  jbutton8.addActionListener(numberAdapter);
  	  jbutton9.addActionListener(numberAdapter);
  	  //运算符颜色和字体大小
  	  jbt1.setForeground(Color.RED);
  	  jbt1.setFont(new Font("",1,20));
  	  jbt2.setForeground(Color.RED);
  	  jbt2.setFont(new Font("",1,20));
  	  jbt3.setForeground(Color.RED);
  	  jbt3.setFont(new Font("",1,20));
  	  jbt4.setForeground(Color.RED);
  	  jbt4.setFont(new Font("",1,20));
  	  jbt0.setForeground(Color.BLUE);
  	  jbt0.setFont(new Font("",1,20));;
  	  jbt.setForeground(Color.BLUE);
  	  //运算符监听器
  	  OperAdapter operAdapter = new OperAdapter();
  	  jbt1.addActionListener(operAdapter);
  	  jbt2.addActionListener(operAdapter);
  	  jbt3.addActionListener(operAdapter);
  	  jbt4.addActionListener(operAdapter);
  	  jbt.addActionListener(operAdapter);
  	  jbt0.addActionListener(operAdapter);
  	  //复位键监听器
  	  jbt.addActionListener(new ResetAdapter());
  	  //按键布局，按四行四列布局
  	  jpanel1.setLayout(new GridLayout(4,4));
  	  jpanel1.add(jbutton7);
  	  jpanel1.add(jbutton8);
  	  jpanel1.add(jbutton9);
  	  jpanel1.add(jbt4);
  	  jpanel1.add(jbutton4);
  	  jpanel1.add(jbutton5);
  	  jpanel1.add(jbutton6);
  	  jpanel1.add(jbt3);
  	  jpanel1.add(jbutton1);
  	  jpanel1.add(jbutton2);
  	  jpanel1.add(jbutton3);
  	  jpanel1.add(jbt2);
  	  jpanel1.add(jbutton0);
  	  jpanel1.add(jbt);
  	  jpanel1.add(jbt0);
  	  jpanel1.add(jbt1);
  	  contantpane.add(jpanel1,BorderLayout.SOUTH);
  	  contantpane.add(jpanel2,BorderLayout.NORTH);
  	  //jframe.pack();//系统自动调整布局
  	  jframe.setVisible(true);
    }
    //监听数字键
    class NumberAdapter implements ActionListener{
  	  public void actionPerformed(ActionEvent e) {
  	 JButton jbutton = (JButton)e.getSource();
  	  if(inString.equals("0")&&jbutton.getLabel().equals("0"))
  	  {
  	  }
  	  else
  		  {
  		  inString+=jbutton.getLabel();
  		 jTextField.setText(inString);
  		  }
  	  }}
    //监听复位键，清楚显示框的内容
    class ResetAdapter implements ActionListener{
  	  public void actionPerformed(ActionEvent e) {
  	  jTextField.setText("0");
  	  num1=0;
  	  num2=0;
  	  result =0 ;
  	  inString = "";
  	  operString = "";
  	  }
  	  }
    //监听运算符键
  	  class OperAdapter implements ActionListener{
  	  public void actionPerformed(ActionEvent e) {
  	  JButton b = (JButton)e.getSource();
  	  if(b.getLabel().equals("+"))
  	  {
  	  operString = "+";
  	  num1 = Integer.parseInt(jTextField.getText());
  	  jTextField.setText("0");
  	  inString="";
  	  }
  	 else if(b.getLabel().equals("-"))
  	   {
  	     operString = "-";
  	     num1 = Integer.parseInt(jTextField.getText());
  	     jTextField.setText("0");
  	      inString="";
  	  }
  	  else if(b.getLabel().equals("/"))
  	  {
  	  operString = "/";
  	  num1 = Integer.parseInt(jTextField.getText());
  	  jTextField.setText("0");
  	  inString="";
  	  }
  	  else if(b.getLabel().equals("*"))
  	  {
  	   operString = "*";
  	  num1 = Integer.parseInt(jTextField.getText());
  	  jTextField.setText("0");
  	  inString="";
  	  }
  	  else
  	  {
  		  num2 = Integer.parseInt(jTextField.getText());
				if(operString == "+"){
					result = num1 + num2;
				} else if(operString == "-"){
					result = num1 - num2;
				} else if(operString == "*"){
					result = num1 * num2;
				} else if(operString == "/"){
					if(0 == num2){
						new JOptionPane().showMessageDialog(null, "除数不能为0！");
					}else{
						result = num1 / num2;
					}
				}
				inString = Integer.toString(result);
				jTextField.setText(inString);
  	  }
    }
 }
}
