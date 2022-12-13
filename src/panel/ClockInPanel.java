package panel;

import MyFrame.MyFrame;
import database.SQLInterFace;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ClockInPanel extends BasePanel{
    private JButton clockinBtn=new JButton("我要打卡");
    private JButton backBtn=new JButton("返回上一级");
    public ClockInPanel() throws SQLException, ClassNotFoundException {
        super();
        clockinBtn.setBounds(0,y_lmt*i,WINDOW_WIDTH/2,WINDOW_HEIGHT/10);
        backBtn.setBounds(WINDOW_WIDTH/2,y_lmt*i,WINDOW_WIDTH/2,WINDOW_HEIGHT/10);

        clockinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SQLInterFace.clockIn(ratList.getItemAt(ratList.getSelectedIndex()), addressList.getItemAt(addressList.getSelectedIndex()));
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
        this.add(clockinBtn);
        this.add(backBtn);
    }
}
