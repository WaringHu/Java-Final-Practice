package test;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	private static Socket so;
	private static DataInputStream dis;
	private static DataOutputStream dos;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {	
			ServerSocket ss = new ServerSocket(1000);
			so = ss.accept();
			System.out.println("连接成功！");
			dis = new DataInputStream(so.getInputStream());
		} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		new Thread(()->{
			try {
				dos = new DataOutputStream(so.getOutputStream());
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			while(true) {
				try {
					String str = dis.readUTF();
					str = str.toUpperCase();
					dos.writeUTF(str);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					try {
						dis.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}).start();
	}
}