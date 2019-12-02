package test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	static ServerFrame frame;
	Server() {
	frame = new ServerFrame();
	}
	public static void main(String[] args) {
	new Server();
	try {
	ServerSocket ss = new ServerSocket(2019);//根据端口号，接收客户端连接
	Socket server = ss.accept();//侦听并接受到此端口号的连接
	frame.server = server;
	frame.receiveText.append("与客户端连接成功！\n");
	//读取客户端数据   
	DataInputStream dis = new DataInputStream(server.getInputStream());
	InputStreamReader isr = new InputStreamReader(dis);
	BufferedReader br = new BufferedReader(isr);
	while(true)
	{
	String read = br.readLine();
	frame.receiveText.append("客户端：" + read + "\n");
	}
	}catch (IOException ex) {
	}
	}
	
}