package panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import MyFrame.MyFrame;
import database.SQLInterFace;


//打卡界面
public class FeedSignPanel extends BasePanel{
    private JLabel foodLabel=new JLabel("投喂食物");
    private JComboBox<String> foodList=new JComboBox<>();
    private JButton clockinBtn=new JButton("我要打卡");
    private JLabel timeLabel=new JLabel("填写时间");
    private JTextField timeField;
    private JLabel feedLabel=new JLabel("喂食数量");
    private JTextField feedField=new JTextField("1");
    private JButton backBtn=new JButton("返回上一级");
    public FeedSignPanel() throws SQLException, ClassNotFoundException {
        super();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new Date();
        String day = df.format(date);
        timeField=new JTextField(day);
        // 添加监听
        clockinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SQLInterFace.feedRecordUpdate(ratList.getItemAt(ratList.getSelectedIndex()), addressList.getItemAt(addressList.getSelectedIndex()),foodList.getItemAt(foodList.getSelectedIndex()), timeField.getText(),feedField.getText());
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame.getInstance().setContentPane(new MenuPanel());
                MyFrame.getInstance().pack();
                MyFrame.getInstance().setVisible(true);
            }
        });
        // 设置位置
        String [] foodArray = SQLInterFace.getFoodList().toArray(new String[SQLInterFace.getFoodList().size()]);
        foodList=new JComboBox<String>(foodArray);
        foodLabel.setBounds(0,y_lmt*i, WINDOW_WIDTH/3, WINDOW_HEIGHT/10);
        foodList.setBounds(2*WINDOW_WIDTH/3,y_lmt*(i++), WINDOW_WIDTH/3, WINDOW_HEIGHT/10);
        timeLabel.setBounds(0,y_lmt*i, WINDOW_WIDTH/3, WINDOW_HEIGHT/10);
        timeField.setBounds(2*WINDOW_WIDTH/3,y_lmt*(i++), WINDOW_WIDTH/3, WINDOW_HEIGHT/10);
        feedLabel.setBounds(0,y_lmt*i, WINDOW_WIDTH/3, WINDOW_HEIGHT/10);
        feedField.setBounds(2*WINDOW_WIDTH/3,y_lmt*(i++), WINDOW_WIDTH/3, WINDOW_HEIGHT/10);
        clockinBtn.setBounds(0,y_lmt*i,WINDOW_WIDTH/2,WINDOW_HEIGHT/10);
        backBtn.setBounds(WINDOW_WIDTH/2,y_lmt*i,WINDOW_WIDTH/2,WINDOW_HEIGHT/10);
        this.add(foodLabel);this.add(foodList);
        this.add(timeField);this.add(timeLabel);
        this.add(feedLabel);this.add(feedField);
        this.add(clockinBtn);this.add(backBtn);

    }
}
