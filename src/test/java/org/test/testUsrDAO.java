package org.test;

import org.inuist.dao.UsrDAO;
import org.inuist.dao.impl.UsrDAOImpl;
import org.inuist.pojo.Usr;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author 18369
 * @date 2024/7/23 下午10:21
 */
public class testUsrDAO {
    private UsrDAO usrDAO;
    @Before
    public void init(){
        usrDAO=new UsrDAOImpl();
    }
    @Test
    public void testInsert(){
        System.out.println(usrDAO.insert(new Usr(0,"admin5","123456",true)));
    }
    @Test
    public void testDelete(){
        System.out.println(usrDAO.delete(1));
    }
    @Test
    public void testUpdate(){
        System.out.println(usrDAO.update(new Usr(3,"admin33","654321",true)));
    }
    @Test
    public void testCount(){
        System.out.println(usrDAO.count());
    }
    @Test
    public void testFindById(){
        System.out.println(usrDAO.findById(1));
    }
    @Test
    public void testFindAll(){
        System.out.println(usrDAO.findAll());
    }
    @Test
    public void testFindWithLimit(){
        System.out.println(usrDAO.findWithLimit(1,1));
    }
    @Test
    public void testFindByNameLike(){
        System.out.println(usrDAO.findByNameLike("admin"));
    }
    @Test
    public void testFindByNameLikeWithLimit(){
        List<Usr> usrList=usrDAO.findByNameLikeWithLimit("admin",0,1);
        for(Usr usr:usrList){
            System.out.println(usr);
        }
    }
    @Test
    public void testLogin(){
        System.out.println(usrDAO.login("admin2","123456"));
    }
}
