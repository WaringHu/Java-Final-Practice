package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JFrame;

public class ServerFrame implements ActionListener{
	JFrame serverF=new JFrame();//窗口
	Panel panel=new Panel();//面板
	Label titleLab=new Label();//标签
	TextArea receiveText=new TextArea();//接收框
	TextArea sendText=new TextArea();//发送框
	Button sendBtn=new Button("发送");//“发送”按钮
	Socket server;

	public ServerFrame(){
	//创建客户端窗口
	serverF.setTitle("服务器端");//窗口标题
	serverF.setSize(500, 450);//设置大小
	serverF.setVisible(true);//设置显示
	serverF.setLocationRelativeTo(null);//窗体居中
	serverF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//结束进程

	//创建面板
	panel.setBackground(Color.pink);
	panel.setLayout(null);//取消默认布局
	serverF.add(panel);

	//创建标签
	titleLab.setText("服务器端程序");
	titleLab.setFont(new Font("宋体",1,20));//设置字体
	titleLab.setBounds(serverF.size().width/2-65, 10, 130, 50);//设置大小和位置
	// titleLab.setBackground(Color.yellow);//设置背景颜色
	panel.add(titleLab);//添加到面板

	//接收、发送框
	receiveText.setBounds(60, 70, serverF.size().width-120, 200);
	sendText.setBounds(receiveText.getX(), receiveText.getY()+receiveText.size().height+10, receiveText.size().width-100, 70);
	receiveText.setEditable(false);//接收框不可编辑
	panel.add(receiveText);
	panel.add(sendText);

	//按钮
	sendBtn.setBounds(receiveText.getX()+receiveText.size().width-80, sendText.getY(), 80, sendText.size().height);
	sendBtn.setFont(new Font("", 0, 16));
	panel.add(sendBtn);
	//添加监听器
	sendBtn.addActionListener(this);
	}


	//点击事件
	@Override
	public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	// System.out.println("333");
	try {
	//向客户端发送数据  
	PrintStream ps = new PrintStream(server.getOutputStream());//server.getOutputStream():获取服务器端的输出流
	ps.println(sendText.getText());
    receiveText.append("服务端："+sendText.getText()+"\n");
	this.sendText.setText("");
	}catch (IOException ex) {
	}
	}
}