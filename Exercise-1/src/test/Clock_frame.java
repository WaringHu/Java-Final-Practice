package test;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Clock_frame extends JFrame{
      MyPanel clockPanel;
      Ellipse2D.Double e;
          int x,y;
      Line2D.Double hourLine;
          int hourlinex,hourliney;
      Line2D.Double minuteLine;
          int minutelinex,minuteliney;
      Line2D.Double secondLine;
          int secondlinex,secondliney;
      GregorianCalendar calendar;
          int hour,minute,second;
      public static final int X=125,Y=125;//钟的左上角
      public static final int RADIAN = 100;//半径
      JLabel jlabel = new JLabel("Hour"+hour+"Minute"+minute+"Second"+second);
      public Clock_frame() {
    	  setBounds(400,200,300,400);
    	  clockPanel = new MyPanel();
    	  jlabel.setBounds(50,235,200,30);
    	  jlabel.setForeground(Color.red);
    	  add(jlabel);
    	  add(clockPanel);
    	  Timer t = new Timer();
    	  Task task = new Task();
    	  t.schedule(task, 0,100);
      }
     class MyPanel extends JPanel
     {
    	 public void paintComponent(Graphics g)
    	 {
    		 super.paintComponent(g);
    		 Graphics2D g2 = (Graphics2D)g;
    		 int i=0;
    		 //画刻度
    		 for(i=0;i<60;i++)
    		 {
    			 int zx1 = (int)(X+100*Math.sin(i*(Math.PI/30)));//Mth.PI/30表示6度
    			 int zy1 = (int)(Y+100*Math.cos(i*(Math.PI/30)));
    			 int h;
    			 if(i%5==0)
    				 h=90;
    			 else
    				 h=95;
    			 int zx2 = (int)(X+h*Math.sin(i*(Math.PI/30)));
    			 int zy2 = (int)(Y+h*Math.cos(i*(Math.PI/30)));
    			 g2.setColor(Color.red);//设置刻度颜色为红色
    			 g2.drawLine(zx1, zy1, zx2, zy2);//(zx1,zy1)为横坐标，(zx2,zy2)为纵坐标
    		 }
    		 g2.setColor(Color.black);
    		 g2.drawString("12",120,22);
    		 g2.drawString("6", 122, 238);
    		 g2.drawString("9", 15,130);
    		 g2.drawString("3", 228, 130);
    		 g2.drawOval(25, 25, 200, 200);
    		 g2.setColor(Color.black);
    		 g2.drawLine(X, Y, hourlinex, hourliney);
    		 g2.setColor(Color.BLUE);
    		 g2.drawLine(X,Y,minutelinex,minuteliney);
    		 g2.setColor(Color.red);
    		 g2.drawLine(X, Y, secondlinex, secondliney);
    		 
    	 }
     }
     class Task extends TimerTask{
    	 public void run() {
    		 //显示时间
    		 calendar = new GregorianCalendar();
    		 hour = calendar.get(Calendar.HOUR);
    		 minute = calendar.get(Calendar.MINUTE);
    		 second = calendar.get(Calendar.SECOND);
    		 //画时针
    		 hourlinex = (int)(X+60*Math.sin(hour*(Math.PI/6)));
    		 hourliney = (int)(Y-60*Math.cos(hour*(Math.PI/6)));
    		 //画分针
    		 minutelinex = (int)(X+75*Math.sin(minute*(Math.PI/30)));
    		 minuteliney = (int)(Y-75*Math.cos(minute*(Math.PI/30)));
    		 //画秒针
    		 secondlinex = (int)(X+85*Math.sin(second*(Math.PI/30)));
    		 secondliney = (int)(Y-85*Math.cos(second*(Math.PI/30)));
    		 jlabel.setText("Hour:"+hour+" "+"Minute:"+minute+" "+"Second:"+second);
    		 repaint();//重新绘制
    	 }
     }
    	  
      }
 
