package test4;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import test4.BookFrame;
import javax.swing.*;
public class ClosewindowAdapter extends WindowAdapter{
    static int state;
    static JFrame jframe;
    static JTextArea jtextarea;
    static File openfile;
    BookFrame bookframe;
    public ClosewindowAdapter(BookFrame bookframe)
    {
  	  this.bookframe = bookframe;
    }
    static void closewindow() {
  	  switch(state)
  	  {
  	  case 0:
  		  System.exit(0);
  		  break;
  	  case 1:
  		  int r = JOptionPane.showOptionDialog(null, "是否先保存当前文件？", "提示", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
  		  if(JOptionPane.YES_OPTION ==r)
  		  {
  			  JFileChooser jfilechooser = new JFileChooser("D:");
  			  int b = jfilechooser.showSaveDialog(jframe);
  			  if(JFileChooser.APPROVE_OPTION==b)
  			  {
  				  File savefile = jfilechooser.getSelectedFile();
  				  try {
  					  FileWriter filewriter = new FileWriter(savefile);
  					  filewriter.write(jtextarea.getText());
  					  filewriter.close();

  				  }catch(IOException e1)
  				  {
  					  e1.printStackTrace();
  				  }
  			  }
  			  else {
                     //无操作
  			  }
  			  System.exit(0);
  		  }
  		  else if(JOptionPane.YES_NO_OPTION == r)
  		  {
  			  System.exit(0);
  		  }
  		  else if(JOptionPane.CANCEL_OPTION==r)
  		  {
  			  //无操作
  		  }
  		  else 
  		  {
  			 // 无操作
  		  }
  		  break;
  	  case 2:
  		  System.exit(0);
  		  break;
  	  case 3:
  		  try {
  			  FileWriter filewriter = new FileWriter(openfile);
  			  String string = jtextarea.getText();
  			  filewriter.write(string,0,string.length());
  			  filewriter.close();
  			  state=2;
  		  }catch(IOException e1)
  		  {
  			  e1.printStackTrace();
  		  }
  		  break;
  		  default :
  			  break;
  	  }
    }
    public void windowclosing(WindowEvent e)
    {
  	  state = bookframe.state;
  	  jframe = bookframe.jframe;
  	  jtextarea = bookframe.jtextarea;
  	  openfile = bookframe.file;
  	  this.closewindow();
    }
}
