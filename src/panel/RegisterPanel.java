package panel;

import MyFrame.MyFrame;
import com.sun.tools.javac.Main;
import database.SQLInterFace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterPanel extends JPanel{
    private ImageIcon icon;
    private Image img;
    private JButton confirmBtn;
    private JLabel accountLabel;
    private JTextField accountField;
    private JLabel idLabel;
    private JTextField idField;
    private JLabel pwdLabel;
    private JPasswordField pwdField;
    private JLabel pwdConfirmLabel;
    private JPasswordField pwdConfirmField;
    private final int WINDOW_WIDTH = 512;
    private final int WINDOW_HEIGHT = 384;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }
    public RegisterPanel(){
        this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        icon=new ImageIcon(getClass().getResource("/img/opening.png"));
        img=icon.getImage();
        accountLabel=new JLabel("用户名");
        accountField=new JTextField("哈深第一圣骑士李田所");
        idLabel=new JLabel("账户id");
        idField=new JTextField("这是一段无意义的文字");
        pwdLabel=new JLabel("密码");
        pwdField=new JPasswordField();
        pwdConfirmLabel=new JLabel("请确认密码");
        pwdConfirmField=new JPasswordField();
        confirmBtn=new JButton("确认注册");
        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(String.valueOf(pwdField.getPassword()).equals(String.valueOf(pwdConfirmField.getPassword()))){
                try {
                    if(SQLInterFace.Register(accountField.getText(),idField.getText(), String.valueOf(pwdField.getPassword()))){
                        System.out.println("注册成功");
                        MyFrame.getInstance().setContentPane(new BaseMainifest().getMainifest());
                        MyFrame.getInstance().pack();
                        MyFrame.getInstance().setVisible(true);
                    }else{
                        System.out.println("注册失败");}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }else{
                    System.out.println("两次输入的密码不一致!");
                }}
        });
        int y_lmt=WINDOW_HEIGHT/5;
        int i=0;
        accountLabel.setBounds(0,y_lmt*i, WINDOW_WIDTH/2, WINDOW_HEIGHT/10);
        accountField.setBounds(WINDOW_WIDTH/2,y_lmt*(i++), WINDOW_WIDTH/2, WINDOW_HEIGHT/10);
        idLabel.setBounds(0,y_lmt*i, WINDOW_WIDTH/2, WINDOW_HEIGHT/10);
        idField.setBounds(WINDOW_WIDTH/2,y_lmt*(i++), WINDOW_WIDTH/2, WINDOW_HEIGHT/10);
        pwdLabel.setBounds(0,y_lmt*i, WINDOW_WIDTH/2, WINDOW_HEIGHT/10);
        pwdField.setBounds(WINDOW_WIDTH/2,y_lmt*(i++), WINDOW_WIDTH/2, WINDOW_HEIGHT/10);
        pwdConfirmLabel.setBounds(0,y_lmt*i, WINDOW_WIDTH/2, WINDOW_HEIGHT/10);
        pwdConfirmField.setBounds(WINDOW_WIDTH/2,y_lmt*(i++), WINDOW_WIDTH/2, WINDOW_HEIGHT/10);
        confirmBtn.setBounds(WINDOW_WIDTH/3,y_lmt*i,WINDOW_WIDTH/3,WINDOW_HEIGHT/10);
        this.setLayout(null);
        this.add(accountLabel);
        this.add(accountField);
        this.add(idLabel);
        this.add(idField);
        this.add(pwdLabel);
        this.add(pwdField);
        this.add(pwdConfirmLabel);
        this.add(pwdConfirmField);
        this.add(confirmBtn);
    }
}
