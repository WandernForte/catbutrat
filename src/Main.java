import MyFrame.MyFrame;
import panel.BaseMainifest;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * @author KiryuSento or WandernForte
 */
public class Main {
    public static BaseMainifest baseMainifest;
    public final static MyFrame frame=MyFrame.getInstance();
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WINDOW_WIDTH = 512;
    public static final int WINDOW_HEIGHT = 768;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        baseMainifest = new BaseMainifest();
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setBounds(((int) screenSize.getWidth() - WINDOW_WIDTH) / 2, 0,
                WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setContentPane(baseMainifest.getMainifest());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
