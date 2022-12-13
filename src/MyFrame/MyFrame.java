package MyFrame;

import javax.swing.*;

public class MyFrame extends JFrame {
    private static MyFrame myFrame=null;
    private String userName=null;
    private String userId=null;
    public static MyFrame getInstance(){
        if(myFrame==null){
            myFrame=new MyFrame();
        }
        return myFrame;
    }
    private MyFrame(){
        super("你以为是猫猫其实是我鼠鼠哒！");
    }
    public void setUserName(String userName){
        if(this.userName==null){
            //仅允许重设一次
            this.userName=userName;
        }
    }
    public String getUserName(){
        return userName;
    }
    public void setUserId(String userId){
        if(this.userId==null){
            //仅允许重设一次
            this.userId=userId;
        }
    }
    public String getUserId(){
        return userId;
    }
}
