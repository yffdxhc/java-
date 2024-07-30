package org.inuist.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 18369
 * @date 2024/7/30 下午4:06
 */
public class ConnectionPool {
    private static String URL ="jdbc:mysql://localhost:3306/java?characterEncoding=utf8";
    private static String USER ="root";
    private static String PASS ="a12345";
    //提供一个集合 存放数据库连接
    List<Connection> cs = new ArrayList<Connection>();
    int size;
    public ConnectionPool(int size){
        this.size = size;
        init();
    }
    public synchronized Connection getConnection(){
        while(cs.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return cs.remove(0);
    }
    public synchronized void returnConnection(Connection c){
        cs.add(c);
        this.notifyAll();
    }
    public void init(){
        for (int i = 0; i < size; i++) {
            Connection conn = null;
            try {
                conn= DriverManager.getConnection(URL,USER,PASS);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            cs.add(conn);
        }
    }
    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
