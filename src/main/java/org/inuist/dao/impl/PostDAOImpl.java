package org.inuist.dao.impl;

import org.inuist.DBUtil;
import org.inuist.dao.PostDAO;
import org.inuist.pojo.Post;
import org.inuist.util.ConnectionPool;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * @author 18369
 * @date 2024/7/30 下午2:14
 */
public class PostDAOImpl implements PostDAO {
    private ConnectionPool cp=new ConnectionPool(10);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public boolean addPost(Post post) {
        String sql="insert into post(ptitle,psummary,pcontent,uid,pdate) values(?,?,?,?,?)";
        try(
                Connection conn = cp.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){
            ps.setString(1,post.getPtitle());
            ps.setString(2, post.getPsummary());
            ps.setString(3, post.getPcontent());
            ps.setInt(4, post.getUid());
            ps.setDate(5, new Date(Calendar.getInstance().getTime().getTime()));
            boolean result = ps.executeUpdate()>0;
            cp.returnConnection(conn);
            return result;
        }catch (Exception e){e.printStackTrace();}
        return false;
    }

    @Override
    public boolean deletePost(Post post) {
        String sql="update post set pstatus=false where pid=?";
        try(
                Connection conn = cp.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){
            ps.setInt(1,post.getPid());
            boolean result = ps.executeUpdate()>0;
            cp.returnConnection(conn);
            return result;
        }catch (Exception e){e.printStackTrace();}
        return false;
    }

    @Override
    public boolean updatePost(Post post) {
        String sql="update post set ptitle=?,psummary=?,pcontent=?,uid=?,pdate=? where pid=?";
        try(
                Connection conn = cp.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){
            ps.setString(1,post.getPtitle());
            ps.setString(2, post.getPsummary());
            ps.setString(3, post.getPcontent());
            ps.setInt(4, post.getUid());
            ps.setDate(5, new Date(Calendar.getInstance().getTime().getTime()));
            ps.setInt(6, post.getPid());
            boolean result = ps.executeUpdate()>0;
            cp.returnConnection(conn);
            return result;
        }catch (Exception e){e.printStackTrace();}
        return false;
    }

    @Override
    public Long count() {
        String sql="select count(*) from post where pstatus=true";
        try(
                Connection conn = cp.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){
            ResultSet rs = ps.executeQuery();
            cp.returnConnection(conn);
            if (rs.next()){
                return rs.getLong(1);
            }
        }catch (Exception e){e.printStackTrace();}
        return 0L;
    }

    @Override
    public Post getPostById(Long id) {
        String sql="select * from post where pid=? and pstatus=true";
        try(
                Connection conn = cp.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            cp.returnConnection(conn);
            if (rs.next()){
                Post post = new Post();
                post.setPid(rs.getInt("pid"));
                post.setPtitle(rs.getString("ptitle"));
                post.setPsummary(rs.getString("psummary"));
                post.setPcontent(rs.getString("pcontent"));
                post.setUid(rs.getInt("uid"));
                post.setPdate(rs.getDate("pdate"));
                post.setPstatus(rs.getBoolean("pstatus"));
                return post;
            }
        }catch (Exception e){e.printStackTrace();}
        return null;
    }

    @Override
    public List<Post> getAllPosts() {
        return getPostsWithLimit(0,Integer.MAX_VALUE);
    }

    @Override
    public List<Post> getPostsWithLimit(long start, long limit) {
        String sql="select * from post where pstatus=true limit ?,?";
        List<Post> posts=new ArrayList<Post>();
        try(
                Connection conn = cp.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setLong(1, start);
            ps.setLong(2, limit);
            ResultSet rs = ps.executeQuery();
            cp.returnConnection(conn);
            while (rs.next()){
                Post post = new Post();
                post.setPid(rs.getInt("pid"));
                post.setPtitle(rs.getString("ptitle"));
                post.setPsummary(rs.getString("psummary"));
                post.setPcontent(rs.getString("pcontent"));
                post.setUid(rs.getInt("uid"));
                post.setPdate(rs.getDate("pdate"));
                post.setPstatus(rs.getBoolean("pstatus"));
                posts.add(post);
            }
        }catch (Exception e){e.printStackTrace();}
        return posts;
    }

    @Override
    public List<Post> getPostsByTitleLike(String title) {
        return getPostsByTitleLikeWithLimit(title,0,Integer.MAX_VALUE);
    }

    @Override
    public List<Post> getPostsByTitleLikeWithLimit(String title, int start, int limit) {
        String sql="select * from post where ptitle like concat('%',?,'%') and pstatus=true limit ?,? ";
        List<Post> posts=new ArrayList<>();
        try(
                Connection conn = cp.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){
            ps.setString(1, title);
            ps.setInt(2, start);
            ps.setInt(3, limit);
            ResultSet rs = ps.executeQuery();
            cp.returnConnection(conn);
            while (rs.next()){
                Post post = new Post();
                post.setPid(rs.getInt("pid"));
                post.setPtitle(rs.getString("ptitle"));
                post.setPsummary(rs.getString("psummary"));
                post.setPcontent(rs.getString("pcontent"));
                post.setUid(rs.getInt("uid"));
                post.setPdate(rs.getDate("pdate"));
                post.setPstatus(rs.getBoolean("pstatus"));
                posts.add(post);
            }
        }catch (Exception e){e.printStackTrace();}
        return posts;
    }

    @Override
    public List<Post> getPostsBySummaryLike(String summary) {
        return getPostsBySummaryLikeWithLimit(summary,0,Integer.MAX_VALUE);
    }

    @Override
    public List<Post> getPostsBySummaryLikeWithLimit(String summary, int start, int limit) {
        String sql="select * from post where psummary like concat('%',?,'%') and pstatus=true limit ?,? ";
        List<Post> posts=new ArrayList<>();
        try(
                Connection conn = cp.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setString(1, summary);
            ps.setInt(2, start);
            ps.setInt(3, limit);
            ResultSet rs = ps.executeQuery();
            cp.returnConnection(conn);
            while (rs.next()){
                Post post = new Post();
                post.setPid(rs.getInt("pid"));
                post.setPtitle(rs.getString("ptitle"));
                post.setPsummary(rs.getString("psummary"));
                post.setPcontent(rs.getString("pcontent"));
                post.setUid(rs.getInt("uid"));
                post.setPdate(rs.getDate("pdate"));
                post.setPstatus(rs.getBoolean("pstatus"));
                posts.add(post);
            }
        }catch (Exception e){e.printStackTrace();}
        return posts;
    }

    @Override
    public List<Post> getPostsByAuthorLike(String author) {
        return getPostsByAuthorLikeWithLimit(author,0,Integer.MAX_VALUE);
    }

    @Override
    public List<Post> getPostsByAuthorLikeWithLimit(String author, int start, int limit) {
        String sql="select * from post where uid in " +
                "(select uid from usr where uname like concat('%',?,'%') " +
                "and ustatus=true) and pstatus=true limit ?,?";
        List<Post> posts=new ArrayList<>();
        try(
                Connection conn = cp.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){
            ps.setString(1, author);
            ps.setInt(2, start);
            ps.setInt(3, limit);
            ResultSet rs = ps.executeQuery();
            cp.returnConnection(conn);
            while (rs.next()){
                Post post = new Post();
                post.setPid(rs.getInt("pid"));
                post.setPtitle(rs.getString("ptitle"));
                post.setPsummary(rs.getString("psummary"));
                post.setPcontent(rs.getString("pcontent"));
                post.setUid(rs.getInt("uid"));
                post.setPdate(rs.getDate("pdate"));
                post.setPstatus(rs.getBoolean("pstatus"));
                posts.add(post);
            }
        }catch (Exception e){e.printStackTrace();}
        return posts;
    }
}
