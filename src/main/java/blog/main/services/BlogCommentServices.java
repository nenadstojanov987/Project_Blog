package blog.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import blog.main.entity.BlogComment;

@Service
public interface BlogCommentServices {

	public List<BlogComment> getBlogCommentList();
	public List<BlogComment> getEnabledBlogCommentList();
	public int getBlogCommentNumberPast7days();
	public List<BlogComment> getDisabledBlogCommentList();
	public List<BlogComment> getBlogCommentListByBlogID(int id_blog);
	public boolean addNewBlogComment(BlogComment blogComment);
	public BlogComment getBlogCommentById(int id_blog_comment);
	public void setDisableBlogComment(int id_blog_comment);
 	public void setEnableBlogComment(int id_blog_comment);
	public void deleteBlogComment(int id_blog_comment);
	public List<BlogComment> getBlogCommentSearch(Integer id_blog_comment, Boolean enabled);
	
}
