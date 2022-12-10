package database;

import java.sql.*;


public class SQLInterFace {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String ADMIN = "root";
    static final String PASS = "1145141919810";
    private Connection connection;
    public SQLInterFace() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        System.out.println("连接数据库...");
        connection = DriverManager.getConnection(DB_URL,ADMIN,PASS);
    }
    public boolean logIn(String userId, String pwd){
        
    }
}
