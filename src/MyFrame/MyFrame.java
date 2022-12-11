package MyFrame;

import javax.swing.*;

public class MyFrame extends JFrame {
    private static MyFrame myFrame=null;
    public static MyFrame getInstance(){
        if(myFrame==null){
            myFrame=new MyFrame();
        }
        return myFrame;
    }
    private MyFrame(){
        super("你以为是猫猫其实是我鼠鼠哒！");
    }
}
