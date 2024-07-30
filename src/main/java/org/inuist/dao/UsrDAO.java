package org.inuist.dao;

import org.inuist.pojo.Usr;

import java.util.List;

/**
 * @author 18369
 * @date 2024/7/23 下午7:35
 */
public interface UsrDAO {
    boolean insert(Usr usr);
    boolean delete(Integer id);
    boolean update(Usr usr);
    boolean login(String uname, String upwd);
    boolean register(Usr usr);
    Integer count();
    Usr findById(Integer id);
    List<Usr> findAll();
    List<Usr> findByNameLike(String name);
    List<Usr> findByNameLikeWithLimit(String name, int start, int limit);
    List<Usr> findWithLimit(int start, int limit);
}
