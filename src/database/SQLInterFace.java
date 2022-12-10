package database;

import java.sql.*;


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
        String sql = "SELECT count(*) FROM users WHERE user_id="+userId+" and user_pwd="+pwd;
        ResultSet rs = content.executeQuery(sql);
        if (rs.next()) {
            flag=(rs.getInt(1) != 0);
        }
        rs.close();
        content.close();
        return flag;
}
}
