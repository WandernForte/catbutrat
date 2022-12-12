package panel;

import database.SQLInterFace;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class BasePanel extends JPanel{

    protected JLabel ratNickName;
    protected JLabel address;
    protected JComboBox<String> ratList;
    protected JButton getAddressBtn;
    protected Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    protected int y_lmt=WINDOW_HEIGHT/10;
    protected int i=0;
    public static final int WINDOW_WIDTH = 512;
    public static final int WINDOW_HEIGHT = 768;
    ImageIcon icon;
    Image img;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }
    public BasePanel() throws SQLException, ClassNotFoundException {
        this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        icon=new ImageIcon(getClass().getResource("/img/HomeImg.jpg"));
        img=icon.getImage();
        ratNickName=new JLabel("鼠鼠昵称");
        address=new JLabel("地点");
        String [] ratarray = SQLInterFace.getRatsList().toArray(new String[SQLInterFace.getRatsList().size()]);
        ratList=new JComboBox<String>(ratarray);

        getAddressBtn=new JButton("获取当前位置");

        ratNickName.setBounds(0,y_lmt*i, WINDOW_WIDTH/3, WINDOW_HEIGHT/10);
        ratList.setBounds(2*WINDOW_WIDTH/3,y_lmt*(i++), WINDOW_WIDTH/3, WINDOW_HEIGHT/10);
        address.setBounds(0,y_lmt*i, WINDOW_WIDTH/3, WINDOW_HEIGHT/10);
        getAddressBtn.setBounds(2*WINDOW_WIDTH/3,y_lmt*(i++), WINDOW_WIDTH/3, WINDOW_HEIGHT/10);
        this.setLayout(null);
        this.add(ratNickName);
        this.add(address);
        this.add(ratList);
        this.add(getAddressBtn);

    }



}
