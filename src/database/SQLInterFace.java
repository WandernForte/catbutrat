package database;

import MyFrame.MyFrame;

import javax.lang.model.element.NestingKind;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SQLInterFace {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/catbutrat?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&autoReconnect=true";
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
//        System.out.println(sql);
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
        return nickNameList;
}
    public static List<String> getAddressList() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Statement content = connection.createStatement();
        String sql = "SELECT name from address;";
        ResultSet rs = content.executeQuery(sql);
        List<String> nickNameList = new ArrayList<>();
        while (rs.next()){
            nickNameList.add(rs.getString(1));
        }
        return nickNameList;
    }

    public static List<String> getFoodList() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Statement content = connection.createStatement();
        String sql = "SELECT food_name from food;";
        ResultSet rs = content.executeQuery(sql);
        List<String> foodNameList = new ArrayList<>();
        while (rs.next()){
            foodNameList.add(rs.getString(1));
        }
        return foodNameList;
    }
    public static int getRatIdByName(String Name) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Statement content = connection.createStatement();
        String sql = "SELECT rat_id from rats WHERE nick_name='"+Name+"'";
        ResultSet rs = content.executeQuery(sql);
        if (rs.next()){
            return rs.getInt(1);
        }
        return -1;
    }
    public static int getAddrIdByName(String Name) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Statement content = connection.createStatement();
        String sql = "SELECT addr_id from address WHERE name='"+Name+"'";
        ResultSet rs = content.executeQuery(sql);
        if (rs.next()){
            return rs.getInt(1);
        }
        return -1;
    }
    public static int getFoodIdByName(String Name) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Statement content = connection.createStatement();
        String sql = "SELECT food_id from food WHERE food_name='"+Name+"'";
        ResultSet rs = content.executeQuery(sql);
        if (rs.next()){
            return rs.getInt(1);
        }
        return -1;
    }
    public static int getCountFromRecord() throws ClassNotFoundException, SQLException {
        int cnt=0;
        System.out.println("连接数据库...");
        Class.forName(JDBC_DRIVER);
        Statement content = connection.createStatement();
        String sql = "SELECT count(*) FROM feed_record;";
        ResultSet rs = content.executeQuery(sql);
        if (rs.next()) {
            cnt=rs.getInt(1);
        }
        rs.close();
        content.close();
        return cnt;
    }
    public static int getCountFromOcc() throws ClassNotFoundException, SQLException {
        int cnt=0;
        System.out.println("连接数据库...");
        Class.forName(JDBC_DRIVER);
        Statement content = connection.createStatement();
        String sql = "SELECT count(*) FROM rats_occurances;";
        ResultSet rs = content.executeQuery(sql);
        if (rs.next()) {
            cnt=rs.getInt(1);
        }
        rs.close();
        content.close();
        return cnt;
    }
    public static void feedRecordUpdate(String nickName, String address, String foodName, String date, String feed_amount) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Statement content = connection.createStatement();
        String sql = "INSERT INTO feed_record (record_id, user_id, record_date, rat_id, food_id, addr_id, amount) VALUES("+
                (getCountFromRecord()+1)+ ","+MyFrame.getInstance().getUserId()+",'"+date+"',"+
                getRatIdByName(nickName)+","+getFoodIdByName(foodName)+","+getAddrIdByName(address)+",'"+feed_amount+"')";
        System.out.println(sql);
        content.executeUpdate(sql);
//        rs.close();
        content.close();
    }
    public static void clockIn(String nickName, String address) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Statement content = connection.createStatement();
        System.out.println("连接数据库...");
        String sql1 = "SELECT count(*) FROM rats_occurances WHERE (rat_id='"+getRatIdByName(nickName)+"' AND addr_id='"+getAddrIdByName(address)+"');";
        //用于查询记录是否在表中
        ResultSet rs1 = content.executeQuery(sql1);
        if (rs1.next()) {
            if(rs1.getInt(1) == 0){
                String sql_insert = "INSERT INTO rats_occurances (rat_id, addr_id, occ_id) VALUES("+
                        getRatIdByName(nickName)+","+getAddrIdByName(address)+","+getCountFromOcc()+")";
                content.executeUpdate(sql_insert);
            }
            else{
                String sql_update = "UPDATE rats_occurances SET last_update=now() WHERE rat_id='"+
                        getRatIdByName(nickName)+"' and addr_id='"+getAddrIdByName(address)+"';";
                content.executeUpdate(sql_update);
            }
        }
        rs1.close();
        content.close();
    }
}
