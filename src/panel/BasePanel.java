package panel;

import javax.swing.*;
import java.awt.*;

public class BasePanel extends JPanel{

    protected JLabel ratNickName;
    protected JLabel address;
    protected JComboBox<String> ratList;
    protected JButton getAddressBtn;
    protected Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
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
    public BasePanel(){
        this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        icon=new ImageIcon(getClass().getResource("/img/HomeImg.jpg"));
        img=icon.getImage();
        ratNickName=new JLabel("鼠鼠昵称");
        address=new JLabel("地点");
        ratList=new JComboBox<String>();
        getAddressBtn=new JButton("获取当前位置");
        int y_lmt=50;
        int x_lmt=50;
        ratNickName.setBounds(0,0, 115, 50);
        address.setBounds(0,WINDOW_HEIGHT/5, 115, 50);
        getAddressBtn.setBounds(WINDOW_WIDTH/3, WINDOW_HEIGHT/5,115, 50);
        ratList.setBounds(WINDOW_WIDTH/3,0,115,50);
        this.setLayout(null);
        this.add(ratNickName);
        this.add(address);
        this.add(ratList);
        this.add(getAddressBtn);
    }
    protected void getRatList(){
        //从数据库中获取所有鼠鼠的昵称
    }


}
