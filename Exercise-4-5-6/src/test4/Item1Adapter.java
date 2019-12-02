package test4;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import test4.BookFrame;
public class Item1Adapter implements ActionListener{
      BookFrame bookframe;
      public Item1Adapter(BookFrame bookframe)
      {
    	  this.bookframe = bookframe;
      }
      void item1() {
  		bookframe.jtextarea.setText("");
  		bookframe.state=0;
  	}
      public void actionPerformed(ActionEvent e) {
  		// TODO Auto-generated method stub
  		switch(bookframe.state)
  		{
  		case 0://初始状态
  			break;//什么也不做
  		case 1://向记事本里写入了文字
  			/*选择提示*/int r = JOptionPane.showOptionDialog(null, "是否先保存当前文件?", "提示", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null,null);
  		if(JOptionPane.YES_OPTION == r)//选择保存当前文件
  		{
  			JFileChooser jfilechooser = new JFileChooser("D:");
  			int b = jfilechooser.showSaveDialog(bookframe.jframe);
  			if(JFileChooser.APPROVE_OPTION == b)
  			{
  				File savefile = jfilechooser.getSelectedFile();
  				try {
  					FileWriter filewriter = new FileWriter(savefile);
  					filewriter.write(bookframe.jtextarea.getText());
  					filewriter.close();
  					item1();
  				}catch(IOException e1)
  				{
  					e1.printStackTrace();
  				}
  			}
  			else
  			{
  			}
  			
  		}
  		else if(JOptionPane.YES_NO_OPTION == r)
  		{
  			item1();
  		}
  		else if(JOptionPane.CANCEL_OPTION == r)
  		{
  		}
  		else
  		{
  		}
  		break;
  		case 2://打开一个文件未做改动
  			item1();
  			break;
  		case 3://打开一个文件并做修改
  			try {
  				FileWriter filewriter = new FileWriter(bookframe.file);
  				filewriter.write(bookframe.jtextarea.getText());
  			    filewriter.close();
  			    item1();
  			}catch(IOException e1)
  			{
  				e1.printStackTrace();
  			}
  			break;
  			default:
  				break;
  		}
  		
  	}
}
