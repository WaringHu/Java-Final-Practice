package test4;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import test4.BookFrame;;
public class Item3Adapter implements ActionListener{
     BookFrame bookframe;
     public Item3Adapter(BookFrame bookframe)
     {
    	 this.bookframe = bookframe;
     }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(bookframe.state)
		{
		case 0:
			new JOptionPane().showMessageDialog(null, "你还未输入任何东西！");
			break;
		case 1:
			JFileChooser jfilechooser = new JFileChooser("E:");
			int b = jfilechooser.showSaveDialog(bookframe.jframe);
			if(JFileChooser.APPROVE_OPTION==b)
			{
				File savefile = jfilechooser.getSelectedFile();
				try {
					FileWriter filewriter = new FileWriter(savefile);
					filewriter.write(bookframe.jtextarea.getText());
					filewriter.close();
					bookframe.state = 2;
				}catch(IOException e1)
				{
					e1.printStackTrace();
				}
		   }
		   else
		   {
			//不做任何操作
		   }
			break;
		case 2:
			new JOptionPane().showMessageDialog(null, "你未对打开的文件作任何修改！");
			break;
		case 3:
			try {
				FileWriter filewriter = new FileWriter(bookframe.file);
				String string = bookframe.jtextarea.getText();
				filewriter.write(string,0,string.length());
				filewriter.close();
				bookframe.state = 2;
			}catch(IOException e1)
			{
				e1.printStackTrace();
			}
			break;
			default:
			break;
			
	}
     
	}}
