package blog.main.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import blog.main.entity.BlogComment;
 

@Component
public interface BlogCommentDAO {

	public List<BlogComment> getBlogCommentList();
	public int getBlogCommentNumberPast7days();
	public List<BlogComment> getEnabledBlogCommentList();
	public List<BlogComment> getDisabledBlogCommentList();
	public List<BlogComment> getBlogCommentListByBlogID(int id_blog);
	public boolean addNewBlogComment(BlogComment blogComment);
	public BlogComment getBlogCommentById(int id_blog_comment);
	public void setDisableBlogComment(int id_blog_comment);
 	public void setEnableBlogComment(int id_blog_comment);
	public void deleteBlogComment(int id_blog_comment);
	public List<BlogComment> getBlogCommentSearch(Integer id_blog_comment, Boolean enabled);
}
