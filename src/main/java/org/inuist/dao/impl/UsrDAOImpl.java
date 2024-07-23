package org.inuist.dao.impl;

import org.inuist.DBUtil;
import org.inuist.dao.UsrDAO;
import org.inuist.pojo.Usr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

/**
 * @author 18369
 * @date 2024/7/23 下午7:47
 */
public class UsrDAOImpl implements UsrDAO {
    @Override
    public boolean insert(String uname,String pwd) {
        Usr usr = new Usr();
        usr.setUname(uname);
        usr.setUpassword(pwd);
        // 定义SQL插入语句，其中status字段被硬编码为true
        String sql = "insert into usr(uname,upassword,ustatus) " + "values (?,?,true)";
        try(
                // 获取数据库连接，并在try-with-resources语句中自动关闭
                Connection c= DBUtil.getConnection();
                // 创建PreparedStatement对象，用于执行带参数的SQL语句，并在try-with-resources语句中自动关闭
                PreparedStatement ps=c.prepareStatement(sql);
        ){
            // 为PreparedStatement的第一个参数（uname）设置值
            ps.setString(1,usr.getUname());
            // 为PreparedStatement的第二个参数（upassword）设置值
            ps.setString(2,usr.getUpassword());
            // 执行插入操作，并返回受影响的行数
            int affectedRows = ps.executeUpdate();
            // 如果受影响的行数大于0，则认为插入成功，返回true
            return affectedRows>0;
        }catch (SQLException e){e.printStackTrace();}
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Usr usr = new Usr();

        return false;
    }

    @Override
    public boolean update(Usr usr) {
        return false;
    }

    @Override
    public Integer count() {
        return 0;
    }

    @Override
    public Usr findById(Long id) {
        return null;
    }

    @Override
    public List<Usr> findAll() {
        return Collections.emptyList();
    }

    @Override
    public List<Usr> findByNameLike(String name) {
        return Collections.emptyList();
    }

    @Override
    public List<Usr> findByNameLikeWithLimit(String name, int start, int limit) {
        return Collections.emptyList();
    }

    @Override
    public List<Usr> findWithLimit(int start, int limit) {
        return Collections.emptyList();
    }
}
