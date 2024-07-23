package org.test;

import org.inuist.dao.UsrDAO;
import org.inuist.dao.impl.UsrDAOImpl;
import org.inuist.pojo.Usr;
import org.junit.Before;
import org.junit.Test;

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
        System.out.println(usrDAO.insert("admin4","123456"));
    }
}
