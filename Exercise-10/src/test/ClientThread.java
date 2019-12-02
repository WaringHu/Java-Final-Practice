package test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread{
	Socket client;
	ClientFrame frame;

	@Override
	public void run() {
	// TODO Auto-generated method stub
	try {
	//读取服务器端数据   
	DataInputStream dis=new DataInputStream(client.getInputStream());
	InputStreamReader isr = new InputStreamReader(dis);
	BufferedReader br = new BufferedReader(isr);
	while (true) {
	String read = br.readLine();
	frame.receiveText.append("服务端：" + read + "\n");
	}


	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
}