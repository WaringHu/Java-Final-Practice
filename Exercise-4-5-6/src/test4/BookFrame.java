package test4;
import java.awt.*;
import javax.swing.*;
import test4.Item1Adapter;
import test4.Item2Adapter;
import test4.Item3Adapter;
import test4.KeyAdapter;
import test4.ClosewindowAdapter;
import java.io.File;
public class BookFrame {
	public JFrame jframe;
    Container container;
    MenuBar menubar;//主菜单
    Menu menu1,menu2;//次菜单：文件、编辑
    MenuItem item1,item2,item3,item4,item5,item6,item7;//新建、打开、保存、关闭、复制、粘贴、剪切
    JScrollPane jscrollpane;//滚动条
    public JTextArea jtextarea;//文本输入区域
    public File file;//保存打开的文件
    public int state=0;//判断文本区域里的四种状态
    /*
     * 0：什么也没有
     * 1：往里面输入了东西
     * 2：打开了一个记事本未作改动
     * 3：打开一个记事本并作改动
     */
    public BookFrame() {
   	 jframe = new JFrame("无标题-记事本");//设置标题
   	 jframe.setBounds(400, 400, 400, 400);//设置记事本大小
   	 jframe.setResizable(true);//用户也可改变记事本大小
   	 jframe.addWindowListener(new ClosewindowAdapter(this));//定义关闭窗口的监听器
   	 container=jframe.getContentPane();
   	 menubar = new MenuBar();
   	 menu1 = new Menu("文件");
   	 menu2 = new Menu("编辑");
   	 item1 = new MenuItem("新建");
   	 item1.addActionListener(new Item1Adapter(this));//新建 监听器
   	 item2 = new MenuItem("打开");
   	 item2.addActionListener(new Item2Adapter(this));//打开 监听器
   	 item3 = new MenuItem("保存");
   	 item3.addActionListener(new Item3Adapter(this));//保存 监听器
   	 item4 = new MenuItem("关闭");
   	 item5 = new MenuItem("复制");
   	 item6 = new MenuItem("粘贴");
   	 item7 = new MenuItem("剪切");
   	 jtextarea = new JTextArea();
   	 jtextarea.addKeyListener(new KeyAdapter(this));	
   	 jscrollpane = new JScrollPane(jtextarea);
     //文件里的小菜单
   	 menu1.add(item1);
   	 menu1.add(item2);
   	 menu1.add(item3);
   	 menu1.add(item4);
   	 //编辑里的小菜单
   	 menu2.add(item5);
   	 menu2.add(item6);
   	 menu2.add(item7);
   	 menubar.add(menu1);
   	 menubar.add(menu2);
   	 container.add(jscrollpane);
   	 jframe.setMenuBar(menubar);
   	 jframe.setVisible(true);
    }
}
