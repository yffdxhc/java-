package org.inuist.dao.impl;

import org.inuist.DBUtil;
import org.inuist.dao.UsrDAO;
import org.inuist.pojo.Usr;
import org.inuist.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 18369
 * @date 2024/7/23 下午7:47
 */
public class UsrDAOImpl implements UsrDAO {
    private static ConnectionPool cp=new ConnectionPool(10);
    @Override
    public boolean insert(Usr usr) {
        // 定义SQL插入语句，其中status字段被硬编码为true
        String sql = "insert into usr(uname,upassword,ustatus) " + "values (?,?,true)";
        try(
                // 获取数据库连接，并在try-with-resources语句中自动关闭
                Connection c= cp.getConnection();
                // 创建PreparedStatement对象，用于执行带参数的SQL语句，并在try-with-resources语句中自动关闭
                PreparedStatement ps=c.prepareStatement(sql);
        ){
            // 为PreparedStatement的第一个参数（uname）设置值
            ps.setString(1,usr.getUname());
            // 为PreparedStatement的第二个参数（upassword）设置值
            ps.setString(2,usr.getUpassword());
            // 执行插入操作，并返回受影响的行数
            int affectedRows = ps.executeUpdate();
            cp.returnConnection(c);
            // 如果受影响的行数大于0，则认为插入成功，返回true
            return affectedRows>0;
        }catch (SQLException e){e.printStackTrace();}
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "update usr set ustatus=0 where uid=?";
        try(
                Connection c= cp.getConnection();
                PreparedStatement ps=c.prepareStatement(sql);
                ){
            ps.setLong(1,id);
            int affectedRows = ps.executeUpdate();
            cp.returnConnection(c);
            return affectedRows>0;
        }catch (Exception e){e.printStackTrace();}
        return false;
    }

    @Override
    public boolean update(Usr usr) {
        String sql = "update usr set uname=?,upassword=? where uid=?";
        try(
                Connection c= cp.getConnection();
                PreparedStatement ps=c.prepareStatement(sql);
                ){
            ps.setString(1,usr.getUname());
            ps.setString(2,usr.getUpassword());
            ps.setInt(3,usr.getUid());
            int affectedRows = ps.executeUpdate();
            cp.returnConnection(c);
            return affectedRows>0;
        }catch (Exception e){e.printStackTrace();}
        return false;
    }

    @Override
    public boolean login(String uname, String upwd) {
        String sql = "select * from usr where uname=? and upassword=? and ustatus=1";
        try(
                Connection c= cp.getConnection();
                PreparedStatement ps=c.prepareStatement(sql);
                ){
            ps.setString(1,uname);
            ps.setString(2,upwd);
            ResultSet rs=ps.executeQuery();
            cp.returnConnection(c);
            if(rs.next()){
                return true;
            }
        }catch (Exception e){e.printStackTrace();}
        return false;
    }

    @Override
    public Usr findByNameAndPwd(String name, String pwd) {
        String sql = "select * from usr where uname=? and upassword=? and ustatus=1";
        Usr usr=new Usr();
        try(
                Connection c= cp.getConnection();
                PreparedStatement ps=c.prepareStatement(sql);
                ){
            ps.setString(1,name);
            ps.setString(2,pwd);
            ResultSet rs=ps.executeQuery();
            cp.returnConnection(c);
            if(rs.next()){
                usr.setUid(rs.getInt("uid"));
                usr.setUname(rs.getString("uname"));
                usr.setUpassword(rs.getString("upassword"));
                usr.setUstatus(rs.getBoolean("ustatus"));
            }
        }catch (Exception e){e.printStackTrace();}
        return usr;
    }

    @Override
    public boolean register(Usr usr) {
        String sql = "select uname from usr ";
        try(
                Connection c= cp.getConnection();
                PreparedStatement ps=c.prepareStatement(sql);
                ){
            ResultSet rs=ps.executeQuery();
            cp.returnConnection(c);
            while(rs.next()){
                if(usr.getUname().equals(rs.getString("uname"))){
                    return false;
                }
            }
        }catch (Exception e){e.printStackTrace();}
        return true;
    }

    @Override
    public Integer count() {
        String sql = "select count(*) from usr";
        try(
                Connection c= cp.getConnection();
                PreparedStatement ps=c.prepareStatement(sql);
                ){
            ResultSet rs=ps.executeQuery();
            cp.returnConnection(c);
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch (Exception e){e.printStackTrace();}
        return 0;
    }

    @Override
    public Usr findById(Integer id) {
        String sql = "select * from usr where uid=?";
        Usr usr = null;
        try(
                Connection c= cp.getConnection();
                PreparedStatement ps=c.prepareStatement(sql);
                ){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            cp.returnConnection(c);
            while(rs.next()){
                usr=new Usr();
                usr.setUid(rs.getInt("uid"));
                usr.setUname(rs.getString("uname"));
                usr.setUpassword(rs.getString("upassword"));
                usr.setUstatus(rs.getBoolean("ustatus"));

            }
        }catch (Exception e){e.printStackTrace();}
        return usr;
    }

    @Override
    public List<Usr> findAll() {
        return findWithLimit(0,Integer.MAX_VALUE);
    }

    @Override
    public List<Usr> findByNameLike(String name) {
        return findByNameLikeWithLimit(name,0,Integer.MAX_VALUE);
    }

    @Override
    public List<Usr> findByNameLikeWithLimit(String name, int start, int limit) {
        String sql = "select * from usr where uname like concat('%',?,'%') limit ?,?";
        List<Usr> list = new ArrayList<>();
        try(
                Connection c= cp.getConnection();
                PreparedStatement ps=c.prepareStatement(sql);
                ){
            ps.setString(1,"%"+name+"%");
            ps.setInt(2,start);
            ps.setInt(3,limit);
            ResultSet rs=ps.executeQuery();
            cp.returnConnection(c);
            while(rs.next()){
                Usr usr=new Usr();
                usr.setUid(rs.getInt("uid"));
                usr.setUname(rs.getString("uname"));
                usr.setUpassword(rs.getString("upassword"));
                usr.setUstatus(rs.getBoolean("ustatus"));
                list.add(usr);
            }
        }catch (Exception e){e.printStackTrace();}
        return list;
    }

    @Override
    public List<Usr> findWithLimit(int start, int limit) {
        String sql = "select * from usr limit ?,?";
        List<Usr> list = new ArrayList<>();
        try(
                Connection c= cp.getConnection();
                PreparedStatement ps=c.prepareStatement(sql);
                ){
            ps.setInt(1,start);
            ps.setInt(2,limit);
            ResultSet rs=ps.executeQuery();
            cp.returnConnection(c);
            while(rs.next()){
                Usr usr=new Usr();
                usr.setUid(rs.getInt("uid"));
                usr.setUname(rs.getString("uname"));
                usr.setUpassword(rs.getString("upassword"));
                usr.setUstatus(rs.getBoolean("ustatus"));
                list.add(usr);
            }
        }catch (Exception e){e.printStackTrace();}
        return list;
    }
}
