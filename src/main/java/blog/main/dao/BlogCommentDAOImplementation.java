package blog.main.dao;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.main.entity.BlogComment;
import blog.main.entity.BlogProduct;
import blog.main.entity.Visitor;

@Repository
public class BlogCommentDAOImplementation implements BlogCommentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private BlogProductDAO blogProductDAO;
	
	@Override
	public List<BlogComment> getBlogCommentList() {
		Session session = sessionFactory.getCurrentSession();
		List<BlogComment> blogCommentList=session.createQuery("FROM BlogComment bc ORDER BY bc.blog_comment_date DESC").list();
		return blogCommentList;
	}

	@Override
	public List<BlogComment> getDisabledBlogCommentList() {
		Session session = sessionFactory.getCurrentSession();
		List<BlogComment> blogCommentList=session.createQuery("from BlogComment bc where bc.enabled=0 ORDER BY bc.blog_comment_date DESC").list();
		return blogCommentList;
	}

	@Override
	public List<BlogComment> getEnabledBlogCommentList() {
		Session session = sessionFactory.getCurrentSession();
		List<BlogComment> blogCommentList=session.createQuery("from BlogComment bc where bc.enabled=1 ORDER BY bc.blog_comment_date DESC").list();
		return blogCommentList;
	}
	
	@Override
	public List<BlogComment> getBlogCommentListByBlogID(int id_blog_product) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM BlogComment bc WHERE bc.blog_product_id = :blog_product_id AND bc.enabled=1 ORDER BY bc.blog_comment_date DESC");
		query.setParameter("blog_product_id", id_blog_product);
		List<BlogComment> commentList= query.getResultList();
		     
		return commentList;
	}

	@Override
	public boolean addNewBlogComment(BlogComment blogComment) {
		Session session = sessionFactory.getCurrentSession();
		int id_blog_product  = blogComment.getBlog_product_id();
		BlogProduct bp = blogProductDAO.getBlogProductById(id_blog_product);
		int comment_count = bp.getComment_count();
		comment_count++;
		bp.setComment_count(comment_count);
		session.save(blogComment);
		blogProductDAO.updateBlogProduct(bp);
		 
		return true;
	}

	@Override
	public BlogComment getBlogCommentById(int id_blog_comment) {
		Session session = sessionFactory.getCurrentSession();
		BlogComment blogComment = session.get(BlogComment.class, id_blog_comment);
		return blogComment;
	}

	 
	@Override
	public void setDisableBlogComment(int id_blog_comment) {
		Session session = sessionFactory.getCurrentSession();
		BlogComment blogComment = session.get(BlogComment.class, id_blog_comment);
		blogComment.setEnabled(false);
		session.saveOrUpdate(blogComment);
	}

	@Override
	public void setEnableBlogComment(int id_blog_comment) {
		Session session = sessionFactory.getCurrentSession();
		BlogComment blogComment = session.get(BlogComment.class, id_blog_comment);
		
		blogComment.setEnabled(!blogComment.getEnabled());
		session.saveOrUpdate(blogComment);
		
	}

	@Override
	public void deleteBlogComment(int id_blog_comment) {
		Session session = sessionFactory.getCurrentSession();
		BlogComment blogComment = session.get(BlogComment.class, id_blog_comment);
		session.delete(blogComment);
	}

	@Override
	public List<BlogComment> getBlogCommentSearch(Integer id_blog_comment, Boolean enabled) {
		Session session=sessionFactory.getCurrentSession();
		String queryString="SELECT DISTINCT bc FROM BlogComment bc ";
		boolean whereClause = false;
		if(id_blog_comment!=null && id_blog_comment>0)
		{
			
			if(whereClause)
			{
				queryString=queryString+" AND bc.id_blog_comment = : id_blog_comment";
			}
			else
			{
				queryString=queryString+" WHERE bc.id_blog_comment = : id_blog_comment ";
				whereClause=true;
			}
		}
		if(enabled!=null)
		{
			if(whereClause)
			{
				  queryString=queryString+" AND bc.enabled = : enabled";
			}
			else
			{
				  queryString=queryString+" WHERE bc.enabled = : enabled";
				  whereClause=true;
			}
		}
		queryString=queryString+" ORDER BY bc.blog_comment_date DESC ";
		System.out.println("----------Stampanje Query--------------");
		System.out.println(queryString);
		Query query=session.createQuery(queryString);
		if(id_blog_comment!=null && id_blog_comment>0)
		{
			query.setParameter("id_blog_comment", id_blog_comment);
		}
		if(enabled!=null)
		{
			query.setParameter("enabled", enabled);
		}
		List<BlogComment> blogCommentList= query.getResultList();
		return blogCommentList;
	}

	@Override
	public int getBlogCommentNumberPast7days() {
		 
		Session session = sessionFactory.getCurrentSession();
		Query query =session.createSQLQuery("select count(*) from blog_comment where date(blog_comment_date) > :commentDate");
		LocalDate date = LocalDate.now().minusDays(7);
		query.setParameter("commentDate", date);
		int res = Integer.parseInt(query.uniqueResult().toString());
		return res;
	}

	

}
