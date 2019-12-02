package test;

import test.ThreadFrame;
import java.util.Random;
public class ThreadCompute implements Runnable{
	ThreadFrame threadframe ;
    static public  long  result=0;
    static public int i;
    static public int r;
    String str = "";
    public ThreadCompute(ThreadFrame threadframe)
    {
    	this.threadframe = threadframe;
    }
    public void run()
    {
    	for(i=1;i<=10;i++)
    	{
    		Random ran = new Random();
			r = 100 + ran.nextInt(4900);
			if(str.equals(""))
            {
	            str = r + "";
            }
			else
			{
				str += "+" + r;
			}
			result += r;
			threadframe.jtextfield1.setText(str);//将随机生成的10个整数相加表达式显示在jtextfield1中
 			threadframe.jprogressbar.setValue(i);//进度条随i增大而增长
 			try {
 				Thread.sleep((long)(500+500*Math.random()));/*控制时间在0.5-1秒之间*/
 			}catch (InterruptedException e) {
 				e.printStackTrace();
				System.out.println("第1个线程休眠时出错！");
 			}
    	 }
    	}
    }
