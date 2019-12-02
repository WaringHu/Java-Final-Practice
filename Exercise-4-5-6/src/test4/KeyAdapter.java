package test4;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import test4.BookFrame;
public class KeyAdapter implements KeyListener {
	BookFrame bookframe;
    public KeyAdapter(BookFrame bookframe)
    {
 	   this.bookframe = bookframe;
    }
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(bookframe.state==0)
		{
			bookframe.state=1;
		}
		else if(bookframe.state==2)
		{
			bookframe.state=3;
		}
		else
		{
		}
}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}