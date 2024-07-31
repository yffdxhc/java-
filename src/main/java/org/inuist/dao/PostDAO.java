package org.inuist.dao;

import org.inuist.pojo.Post;

import java.util.List;

/**
 * @author 18369
 * @date 2024/7/30 下午1:37
 */
public interface PostDAO {
    boolean addPost(Post post);
    boolean deletePost(Post post);
    boolean updatePost(Post post);
    Long count();
    Post getPostById(Long id);
    List<Post> getAllPosts();
    List<Post> getPostsWithLimit(long start, long limit);
    List<Post> getPostsByTitleLike(String title);
    List<Post> getPostsByTitleLikeWithLimit(String title, int start, int limit);
    List<Post> getPostsBySummaryLike(String summary);
    List<Post> getPostsBySummaryLikeWithLimit(String summary, int start, int limit);
    List<Post> getPostsByAuthorLike(String author);
    List<Post> getPostsByAuthorLikeWithLimit(String author, int start, int limit);
    List<Post> getPostsByUidWithLimit(int uid,int start, int limit);
}
