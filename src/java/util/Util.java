package util;

import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/my-test?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "shuffle";
    
    // метод возвращает sql connection
    public Connection getConnection() {
        Connection connection = null;
        
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection is ok:" + !connection.isClosed());
            
        } catch (SQLException e) {
            System.out.println("Не удалось загрузить класс драйвера");
            
        }
        
        return connection;
    }
} 
