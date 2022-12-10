package panel;

import database.SQLInterFace;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class BaseMainifest extends JPanel {
    private JButton loginBtn;
    private JButton registerBtn;
    private JTextField idField;
    private JPasswordField pwdField;
    private JLabel idLabel;
    private JLabel pwdLabel;
    private JPanel TopLayout;
    private JPanel mainifest;

    public BaseMainifest() {
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(SQLInterFace.logIn(idField.getText(), String.valueOf(pwdField.getPassword()))){
                        System.out.println("登录成功");
                    }else{
                    System.out.println("登录失败, 密码为:"+String.valueOf(pwdField.getPassword()));}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel getMainifest(){
        return mainifest;
    }
}
