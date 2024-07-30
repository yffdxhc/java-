package org.test;

import org.inuist.dao.PostDAO;
import org.inuist.dao.impl.PostDAOImpl;
import org.inuist.dao.impl.UsrDAOImpl;
import org.inuist.pojo.Post;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 18369
 * @date 2024/7/30 下午2:36
 */
public class TestPostDAO {
    private PostDAO postDAO;
    @Before
    public void init(){
        postDAO=new PostDAOImpl();
    }
    @Test
    public void testAddPost(){
        //System.out.println(new Date(Calendar.getInstance().getTime().getTime()));
        System.out.println(postDAO.addPost(new Post
                (0,"测试","增数据","表数据增加",1,new Date(),true)));
    }
    @Test
    public void testdeletePost(){
        System.out.println(postDAO.deletePost(new Post
                (1,"测试","增数据","表数据增加",1,new Date(),true)));
    }
    @Test
    public void testupdatePost(){
        System.out.println(postDAO.updatePost(new Post(
                2,"测试二","改数据","表数据修改",1,new Date(),true
        )));
    }
    @Test
    public void testCount(){
        System.out.println(postDAO.count());
    }
    @Test
    public void testGetPostById(){
        System.out.println(postDAO.getPostById(2L));
    }
}
