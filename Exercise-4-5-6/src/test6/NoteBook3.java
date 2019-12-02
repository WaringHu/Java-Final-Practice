package test6;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import test4.KeyAdapter;
import test4.ClosewindowAdapter;
import test4.Item1Adapter;
import test4.Item2Adapter;
import test4.Item3Adapter;

import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class NoteBook3 implements ActionListener{
	public JFrame jframe;
    Container container;
    MenuBar menubar;//主菜单
    Menu menu1,menu2;//次菜单：文件、编辑
    MenuItem item1,item2,item3,item4,item5,item6,item7;//新建、打开、保存、关闭、复制、粘贴、剪切
    JScrollPane jscrollpane;//滚动条
    public JTextArea jtextarea;//文本输入区域
    File  fileName= new File("E://file.txt"); //默认文件路径
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                   NoteBook3 window = new NoteBook3();
                    window.jframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public NoteBook3() {
   	 jframe = new JFrame("无标题-记事本");//设置标题
   	 jframe.setBounds(400, 400, 400, 400);//设置记事本大小
   	 jframe.setResizable(true);//用户也可改变记事本大小
   	 container=jframe.getContentPane();
   	 menubar = new MenuBar();
   	 menu1 = new Menu("文件");
   	 menu2 = new Menu("编辑");
   	 item1 = new MenuItem("新建");
   	 item1.addActionListener(this);//新建 监听器
   	 item2 = new MenuItem("打开");
   	 item2.addActionListener(this);//打开 监听器
   	 item3 = new MenuItem("保存");
   	 item3.addActionListener(this);//保存 监听器
   	 item4 = new MenuItem("关闭");
   	 item5 = new MenuItem("复制");
   	 item6 = new MenuItem("粘贴");
   	 item7 = new MenuItem("剪切");
   	 jtextarea = new JTextArea();	
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
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item4) {
            System.exit(0);
        } else if (e.getSource() == item1) {
            jtextarea.setText("");
        } else if (e.getSource() == item2) {
            saveFile();
        } else if (e.getSource() == item3) {
            jtextarea.setText("");
            openFile();
        }

    }
    public void saveFile(){
        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(fileName));
                                                            //打开写入流
            String text = jtextarea.getText();                //获取文本框内容
            char[] ch = new char[1024];                        //字符串->>字符数组
            ch = text.toCharArray();
            int tmp;
            for(int i = 0;i < ch.length;i++){
                tmp = (int)ch[i];                            //字符->ASCII值
                if(tmp>='A'&&tmp<='Z'){                        //过滤
                    tmp += 32;
                }    
                ch[i] = (char)tmp;                            //ASCII值->字符
            }
            text = String.valueOf(ch);                        //字符数组->>字符串
            bWriter.write(text);                            //写入
            bWriter.close();
        } catch (IOException e) {
            System.err.println("保存文件发生错误！");
            e.printStackTrace();                            //打印轨迹
        }
    }
    public void openFile(){
        try {
			BufferedReader bReader = new BufferedReader(new FileReader(fileName));
            String text;
            while((text = bReader.readLine())!=null){
                jtextarea.append(text+"\n");
            }
            bReader.close();
        } catch (IOException e) {
            System.err.println("打开文件发生错误！");
            e.printStackTrace();
        }
    }
 
    
}
