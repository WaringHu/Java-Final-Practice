package test4;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import test4.BookFrame;;
public class Item2Adapter implements ActionListener{
	BookFrame bookframe;
    public Item2Adapter(BookFrame bookframe)
    {
  	  this.bookframe = bookframe;
    }
    public void actionPerformed(ActionEvent e) {
    	switch(bookframe.state)
    	{
    	case 0:
    		break;
    	case 1:
    	    int r = JOptionPane.showOptionDialog(null, "是否先保存当前文件？", "提示", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
    	    if(JOptionPane.YES_OPTION==r)
    	    {
    	    	JFileChooser jfilechooser = new JFileChooser("E:");
    	    	int b = jfilechooser.showSaveDialog(bookframe.jframe);
    	    	if(JFileChooser.APPROVE_OPTION==b)
    	    	{
    	    		File savefile = jfilechooser.getSelectedFile();
    	    		try {
    	    			FileWriter filewriter = new FileWriter(savefile);
    	    			filewriter.write(bookframe.jtextarea.getText());
    	    			filewriter.close();
    	    			bookframe.state=2;
    	    		}catch(IOException e1)
    	    		{
    	    			e1.printStackTrace();
    	    		}
    	    	}
    	    	else
    	    	{
    	          //不做任何操作
    	    	}
    	    }
    	    else if(JOptionPane.NO_OPTION==r)
    	    {
    	    	bookframe.state=2;
    	    }
    	    else if(JOptionPane.CANCEL_OPTION==r)
    	    {
    	    	//不做任何操作
    	    }
    	    else
    	    {
    	    	//不做任何操作
    	    }
    	    break;
    	case 2:
    		break;
    	case 3:
    		try {
				FileWriter filewriter = new FileWriter(bookframe.file);
				filewriter.write(bookframe.jtextarea.getText());
				filewriter.close();
				bookframe.state=2;
			}catch(IOException e1)
			{
				e1.printStackTrace();
			}
			break;
			default:
				break;
    	}
    	JFileChooser jfilechooser = new JFileChooser();
		int open =jfilechooser.showOpenDialog(bookframe.jframe);
		if(jfilechooser.APPROVE_OPTION ==open)
		{
			File file = jfilechooser.getSelectedFile();
			try {
				FileReader filereader = new FileReader(file);
				int b;
				String string = "";
				while((b=filereader.read())!=-1)
				{
					string+=(char)b;
				}
				bookframe.jtextarea.setText(string);
				filereader.close();
				bookframe.file = file;
				bookframe.state=2;
			}catch(IOException e1)
			{
				e1.printStackTrace();
			}
		}
		else
		{
		}
    }
}
