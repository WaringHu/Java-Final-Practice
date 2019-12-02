package test;

import test.ThreadFrame;

public class ThreadCompute implements Runnable {
     ThreadFrame ThreadFrame ;
     static public  long  result=0;
     static public int i;
     long s=1;
     String str = "";
     public ThreadCompute(ThreadFrame ThreadFrame)
     {
    	 this.ThreadFrame = ThreadFrame;
     }
     public void run()
     {
    	 for(i=1;i<=10;i++)
    	 {
    		 if(str.equals(""))
    		 {
    			 str = i+"!";
    		 }
    		 else
    		 {
    			 str += "+" + i +"!";/*等号前的加号将表达式衔接起来*/
    		 }
    		 s *= i;
    		 result += s;
    		ThreadFrame.jtextfield1.setText(str);//将输入的1至10的阶乘表达式显示在jtextfield1中
 			ThreadFrame.jprogressbar.setValue(i);//进度条随i增大而增长
 			try {
 				Thread.sleep((long)(500+500*Math.random()));/*控制时间在0.5-1秒之间*/
 			}catch (InterruptedException e) {
 				e.printStackTrace();
				System.out.println("第1个线程休眠时出错！");
 			}
    	 }
     }
}
