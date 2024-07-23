package org.inuist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 18369
 * @date 2024/7/23 下午7:50
 */
public class DBUtil {
    private static final String URL ="jdbc:mysql://localhost:3306/java?characterEncoding=utf8";
    private static final String USERNAME ="root";
    private static final String PASSWORD ="a12345";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
}
