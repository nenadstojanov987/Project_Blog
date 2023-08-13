package blog.main.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.main.dao.BlogCommentDAO;
import blog.main.entity.BlogComment;

@Component
public class BlogCommentServiceImplementation implements BlogCommentServices{

	@Autowired
	private BlogCommentDAO blogCommentDAO;
	
	 
	
	@Transactional
	@Override
	public List<BlogComment> getBlogCommentList() {
		List<BlogComment> blogCommentList = blogCommentDAO.getBlogCommentList();
		return blogCommentList;
	}

	@Transactional
	@Override
	public List<BlogComment> getEnabledBlogCommentList() {
		List<BlogComment> blogCommentList = blogCommentDAO.getEnabledBlogCommentList();
		return blogCommentList;
	}

	@Transactional
	@Override
	public List<BlogComment> getDisabledBlogCommentList() {
		List<BlogComment> blogCommentList = blogCommentDAO.getDisabledBlogCommentList();
		return blogCommentList;
	}

	@Transactional
	@Override
	public List<BlogComment> getBlogCommentListByBlogID(int id_blog) {
		List<BlogComment> blogCommentList = blogCommentDAO.getBlogCommentListByBlogID(id_blog);
		return blogCommentList;
	}

	@Transactional
	@Override
	public boolean addNewBlogComment(BlogComment blogComment) {
		boolean add = blogCommentDAO.addNewBlogComment(blogComment);
		return add;
		 
	}

	@Transactional
	@Override
	public BlogComment getBlogCommentById(int id_blog_comment) {
		 BlogComment blogComment = blogCommentDAO.getBlogCommentById(id_blog_comment);
		 return blogComment;
	}

	@Transactional
	@Override
	public void setDisableBlogComment(int id_blog_comment) {
		blogCommentDAO.setDisableBlogComment(id_blog_comment);
		
	}

	@Transactional
	@Override
	public void setEnableBlogComment(int id_blog_comment) {
		blogCommentDAO.setEnableBlogComment(id_blog_comment);
		
	}

	@Transactional
	@Override
	public void deleteBlogComment(int id_blog_comment) {
		blogCommentDAO.deleteBlogComment(id_blog_comment);
		
	}

	@Transactional
	@Override
	public List<BlogComment> getBlogCommentSearch(Integer id_blog_comment, Boolean enabled) {
		List<BlogComment> blogCommentList = blogCommentDAO.getBlogCommentSearch(id_blog_comment, enabled);
		return blogCommentList;
	}

	@Transactional
	@Override
	public int getBlogCommentNumberPast7days() {
		int res = blogCommentDAO.getBlogCommentNumberPast7days();
		return res;
	}

}
