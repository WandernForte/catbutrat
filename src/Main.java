import MyFrame.MyFrame;
import panel.BaseMainifest;
import panel.BasePanel;
import panel.MenuPanel;
import panel.RegisterPanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static BaseMainifest baseMainifest;
    public static BasePanel basePanel;
    public static MenuPanel menuPanel;
    public static RegisterPanel registerPanel;
    public final static MyFrame frame=MyFrame.getInstance();
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WINDOW_WIDTH = 512;
    public static final int WINDOW_HEIGHT = 768;
    public static void main(String args[])
    {
        baseMainifest = new BaseMainifest();
        basePanel=new BasePanel();
        menuPanel=new MenuPanel();
        registerPanel=new RegisterPanel();
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setBounds(((int) screenSize.getWidth() - WINDOW_WIDTH) / 2, 0,
                WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setContentPane(baseMainifest.getMainifest());
//        frame.setContentPane(registerPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static JFrame getFrame(){
        return frame;
    }

}
