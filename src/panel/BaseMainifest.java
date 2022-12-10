package panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

            }
        });
    }

    public JPanel getMainifest(){
        return mainifest;
    }
}
