package test;
import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Client {
	private JFrame frame;
	private static JTextField textField;
	private static JTextField textField_1;
	private static Socket so;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frame.setTitle("Client");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			so = new Socket("127.0.0.1",1000);
			
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("连接成功!");
		new Thread(()->{
			DataInputStream dis = null;
			try {
				dis = new DataInputStream(so.getInputStream());
				String str;
				while(true) {
					str = dis.readUTF();
					textField_1.setText(str);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				try {
					
					dis.close();
					so.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}).start();
	}
 
	/**
	 * Create the application.
	 */
	public Client() {
		initialize();
	}
 
	/*
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 250, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8F93\u5165\u6D88\u606F");
		label.setBounds(14, 32, 72, 18);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\u670D\u52A1\u5668\u54CD\u5E94");
		lblNewLabel.setBounds(14, 91, 84, 18);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(102, 29, 214, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(102, 88, 214, 105);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u53D1\u9001");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				DataOutputStream dos = null;
				try {
					dos = new DataOutputStream(so.getOutputStream());
					dos.writeUTF(str);
					dos.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					try {
						dos.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
		});
		button.setBounds(320, 28, 113, 27);
		frame.getContentPane().add(button);
	}
}