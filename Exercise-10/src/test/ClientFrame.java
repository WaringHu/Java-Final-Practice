package test;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
public class ClientFrame implements ActionListener{
	JFrame clientF=new JFrame();//窗口
	Panel panel=new Panel();//面板
	Label titleLab=new Label();//标签
	Label ipLab=new Label();
	Label portLab=new Label();
	TextField ipText=new TextField();//
	TextField portText=new TextField();//存储端口号
	TextArea receiveText=new TextArea();//接收框
	TextArea sendText=new TextArea();//发送框
	Button connectBtn=new Button("连接");//“连接”按钮
	Button sendBtn=new Button("发送");//“发送”按钮
	Socket client;
	boolean press=true;//判断是否连接

	ClientFrame(){
	//创建客户端窗口
	clientF.setTitle("客户端");//窗口标题
	clientF.setSize(500, 500);//设置大小
	clientF.setVisible(true);//设置显示
	clientF.setLocationRelativeTo(null);//窗体居中
	clientF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//结束进程

	//创建面板
	panel.setBackground(Color.pink);
	panel.setLayout(null);//取消默认布局
	clientF.add(panel);

	//创建标签
	titleLab.setText("客户端程序");
	ipLab.setText("IP:");
	portLab.setText("Port:");
	titleLab.setFont(new Font("宋体",1,20));//设置字体
	ipLab.setFont(new Font("",1,15));
	portLab.setFont(new Font("",1,15));
	titleLab.setBounds(clientF.size().width/2-55, 10, 110, 50);//设置大小和位置
	ipLab.setBounds(60, 70, 25, 20);
	portLab.setBounds(ipLab.getX()+220, ipLab.getY(), 40, ipLab.size().height);
	// titleLab.setBackground(Color.yellow);//设置背景颜色
	// ipLab.setBackground(Color.yellow);
	// portLab.setBackground(Color.yellow);
	panel.add(titleLab);//添加到面板
	panel.add(ipLab);
	panel.add(portLab);

	//端口号文本框
	ipText.setBounds(ipLab.getX()+ipLab.size().width, ipLab.getY(), 100, ipLab.size().height);
	portText.setBounds(portLab.getX()+portLab.size().width, portLab.getY(), 100, portLab.size().height);
	// try {//获取本地ip地址
	// ipText.setText(InetAddress.getLocalHost().getHostAddress());
	// } catch (UnknownHostException e) {//抛出异常
	// // TODO Auto-generated catch block
	// }
	ipText.setText("127.0.0.1");
	portText.setText("2019");//设置端口号
	ipText.setEnabled(false);//文本框不可用
	portText.setEnabled(false);
	panel.add(ipText);
	panel.add(portText);

	//接收、发送框
	receiveText.setBounds(ipLab.getX(), ipLab.getY()+ipLab.size().height+10, portText.getX()-ipLab.getX()+100, 200);
	sendText.setBounds(receiveText.getX(), receiveText.getY()+receiveText.size().height+10, receiveText.size().width, 70);
	receiveText.setEditable(false);//接收框不可编辑
	panel.add(receiveText);
	panel.add(sendText);

	//按钮
	connectBtn.setBounds(titleLab.getX()-60, sendText.getY()+sendText.size().height+20, 60, 40);
	sendBtn.setBounds(titleLab.getX()+titleLab.size().width, connectBtn.getY(), connectBtn.size().width, connectBtn.size().height);
	connectBtn.setFont(new Font("", 0, 16));
	sendBtn.setFont(new Font("", 0, 16));
	panel.add(connectBtn);
	panel.add(sendBtn);
	//添加监听器
	connectBtn.addActionListener(this);
	sendBtn.addActionListener(this);

	}

	//点击事件
	@Override
	public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub

	if(e.getSource()==connectBtn){
	// System.out.println("111");
	String ip=ipText.getText();
	int port=Integer.parseInt(portText.getText());
	try {//连接服务器
	client=new Socket(ip, port);//创建一个流套接字并将其连接到指定主机上的指定端口号 
	if(press){
	receiveText.append("与服务器连接成功！\n");
	press=false;
	}else{
	receiveText.append("已连接！\n");
	}
	ClientThread ct = new ClientThread();
	ct.client = client;
	ct.frame = this;
	ct.start();
	} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	}
	}else{
	// System.out.println("222");
	try {
	//向服务器端发送数据  
	PrintStream ps = new PrintStream(client.getOutputStream());
	ps.println(sendText.getText());
	receiveText.append("客户端："+sendText.getText()+"\n");
	this.sendText.setText("");
	}catch (IOException ex) {
	}
	}
	}}