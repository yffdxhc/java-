package org.inuist.dao.impl;

import org.inuist.DBUtil;
import org.inuist.dao.PostDAO;
import org.inuist.pojo.Post;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * @author 18369
 * @date 2024/7/30 下午2:14
 */
public class PostDAOImpl implements PostDAO {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public boolean addPost(Post post) {
        String sql="insert into post(ptitle,psummary,pcontent,pauthor,pdate) values(?,?,?,?,?)";
        try(
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){
            ps.setString(1,post.getPtitle());
            ps.setString(2, post.getPsummary());
            ps.setString(3, post.getPcontent());
            ps.setInt(4, post.getPauthor());
            ps.setDate(5, new Date(Calendar.getInstance().getTime().getTime()));
            boolean result = ps.executeUpdate()>0;
            return result;
        }catch (Exception e){e.printStackTrace();}
        return false;
    }

    @Override
    public boolean deletePost(Post post) {
        String sql="update post set pstatus=false where pid=?";
        try(
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){
            ps.setInt(1,post.getPid());
            boolean result = ps.executeUpdate()>0;
            return result;
        }catch (Exception e){e.printStackTrace();}
        return false;
    }

    @Override
    public boolean updatePost(Post post) {
        String sql="update post set ptitle=?,psummary=?,pcontent=?,pauthor=?,pdate=? where pid=?";
        try(
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){
            ps.setString(1,post.getPtitle());
            ps.setString(2, post.getPsummary());
            ps.setString(3, post.getPcontent());
            ps.setInt(4, post.getPauthor());
            ps.setDate(5, new Date(Calendar.getInstance().getTime().getTime()));
            ps.setInt(6, post.getPid());
            boolean result = ps.executeUpdate()>0;
            return result;
        }catch (Exception e){e.printStackTrace();}
        return false;
    }

    @Override
    public Long count() {
        String sql="select count(*) from post";
        try(
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getLong(1);
            }
        }catch (Exception e){e.printStackTrace();}
        return 0L;
    }

    @Override
    public Post getPostById(Long id) {
        String sql="select * from post where pid=?";
        try(
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Post post = new Post();
                post=getPostById(rs.getLong(1));
                return post;
            }
        }catch (Exception e){e.printStackTrace();}
        return null;
    }

    @Override
    public List<Post> getAllPosts() {
        return Collections.emptyList();
    }

    @Override
    public List<Post> getPostsWithLimit(long start, long limit) {
        return Collections.emptyList();
    }

    @Override
    public List<Post> getPostsByTitleLike(String title) {
        return Collections.emptyList();
    }

    @Override
    public List<Post> getPostsByTitleLikeWithLimit(String title, int start, int limit) {
        return Collections.emptyList();
    }

    @Override
    public List<Post> getPostsBySummaryLike(String summary) {
        return Collections.emptyList();
    }

    @Override
    public List<Post> getPostsBySummaryLikeWithLimit(String summary, int start, int limit) {
        return Collections.emptyList();
    }

    @Override
    public List<Post> getPostsByAuthorLike(String author) {
        return Collections.emptyList();
    }

    @Override
    public List<Post> getPostsByAuthorLikeWithLimit(String author, int start, int limit) {
        return Collections.emptyList();
    }
}
