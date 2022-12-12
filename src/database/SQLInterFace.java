package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SQLInterFace {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/catbutrat?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String ADMIN = "root";
    static final String PASS = "1145141919810";
    private static Connection connection = null;

    static {
        try {
            connection = DriverManager.getConnection(DB_URL,ADMIN,PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean logIn(String userId, String pwd) throws SQLException, ClassNotFoundException {
        boolean flag=false;
        System.out.println("连接数据库...");
        Class.forName(JDBC_DRIVER);
        Statement content = connection.createStatement();
        String sql = "SELECT count(*) FROM users WHERE (user_id='"+userId+"' AND user_pwd='"+pwd+"');";
        System.out.println(sql);
        ResultSet rs = content.executeQuery(sql);
        if (rs.next()) {
            flag=(rs.getInt(1) != 0);
        }
        rs.close();
        content.close();
        return flag;
}
public static boolean Register(String account, String userId, String pwd) throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER);
        Statement content = connection.createStatement();
        String sql = "INSERT INTO users (user_name,user_id,user_pwd,user_type) VALUES('"+
                account+"','"+
                userId+"','"+
                pwd+"','0')";
        int flag=content.executeUpdate(sql);
        content.close();
        return (flag>0);

}
public static String getUserName(String userId) throws ClassNotFoundException, SQLException {
    System.out.println("连接数据库...");
    Class.forName(JDBC_DRIVER);
    Statement content = connection.createStatement();
    String sql = "SELECT user_name FROM users WHERE user_id="+userId+";";
    System.out.println(sql);
    ResultSet rs = content.executeQuery(sql);
    String userName = null;
    if (rs.next()) {
        userName=rs.getString(1);
    }
    rs.close();
    content.close();
    return userName;
}
public static List<String> getRatsList() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Statement content = connection.createStatement();
        String sql = "SELECT nick_name from rats;";
        ResultSet rs = content.executeQuery(sql);
        List<String> nickNameList = new ArrayList<>();
        while (rs.next()){
            nickNameList.add(rs.getString(1));
        }
        System.out.println(nickNameList);
        return nickNameList;
}
}
