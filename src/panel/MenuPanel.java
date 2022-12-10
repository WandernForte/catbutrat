package panel;

import javax.swing.*;
import java.awt.*;


public class MenuPanel extends JPanel {
    private ImageIcon icon;
    private Image img;
    private JButton clockIn;
    private JButton query4RatsOccur;
    private JButton query4RatsLikes;
    private JButton ratFeedSign;
    private JButton query4ValidFood;
    private JButton contactAdmin;
    private JButton add2FoodBlackList;
    private final int WINDOW_WIDTH = 512;
    private final int WINDOW_HEIGHT = 384;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }
    public MenuPanel(){
        this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        icon=new ImageIcon(getClass().getResource("/img/HomeImg.jpg"));
        img=icon.getImage();
        clockIn=new JButton("打卡");
        query4RatsOccur=new JButton("查询鼠鼠出现位置");
        query4RatsLikes=new JButton("查询鼠鼠喜好");
        ratFeedSign=new JButton("鼠鼠投喂登记");
        query4ValidFood=new JButton("查询可用食物");
        contactAdmin=new JButton("联系管理员");
        add2FoodBlackList=new JButton("添加食物黑名单(管理员)");
        int y_lmt=WINDOW_HEIGHT/5;
        int i=0;
        clockIn.setBounds(0,y_lmt*i, WINDOW_WIDTH/3, WINDOW_HEIGHT/5);
        query4RatsOccur.setBounds(2*WINDOW_WIDTH/3,y_lmt*(i++), WINDOW_WIDTH/3, WINDOW_HEIGHT/5);
        query4RatsLikes.setBounds(0,y_lmt*i, WINDOW_WIDTH/3, WINDOW_HEIGHT/5);
        ratFeedSign.setBounds(2*WINDOW_WIDTH/3,y_lmt*(i++), WINDOW_WIDTH/3, WINDOW_HEIGHT/5);
        query4ValidFood.setBounds(0,y_lmt*i, WINDOW_WIDTH/3, WINDOW_HEIGHT/5);
        contactAdmin.setBounds(2*WINDOW_WIDTH/3,y_lmt*(i++), WINDOW_WIDTH/3, WINDOW_HEIGHT/5);
        add2FoodBlackList.setBounds(WINDOW_WIDTH/3,y_lmt*i,WINDOW_WIDTH/3,WINDOW_HEIGHT/5);

        this.setLayout(null);
        this.add(clockIn);
        this.add(query4RatsOccur);
        this.add(query4RatsLikes);
        this.add(ratFeedSign);
        this.add(query4ValidFood);
        this.add(contactAdmin);
        this.add(add2FoodBlackList);
    }
}
