package test;

import test.ThreadCompute;
import test.ThreadFrame;

public class ThreadReturn extends Thread {
      ThreadFrame ThreadFrame;
      public ThreadReturn(ThreadFrame ThreadFrame)
      {
    	  this.ThreadFrame = ThreadFrame; 
      }
      public void run() {
  		while(ThreadCompute.i != 10){
  			ThreadFrame.jtextfield2.setText("" + ThreadCompute.result);/*将结果显示在jtextfield2上*/
  			try {
  				Thread.sleep(1000);//控制停顿一秒
  			} catch (InterruptedException e) {
  				e.printStackTrace();
  				System.out.println("第2个线程休眠时出错！");
  			}
  		}
  		try {
  			Thread.sleep(1000);
  		}catch(InterruptedException e) {
			e.printStackTrace();
			System.out.println("第2个线程在最后一次休眠时出错！");
		}
  		ThreadFrame.jtextfield2.setText("" + ThreadCompute.result);
  		ThreadCompute.result = 0;//初始化结果
  		ThreadCompute.i = 1;//初始化i值 为1
		ThreadFrame.jbutton.setText("重新计算");//将按钮文字重设
  		
}}
