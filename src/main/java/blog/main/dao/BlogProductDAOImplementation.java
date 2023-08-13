package blog.main.dao;

import java.math.BigInteger;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import blog.main.entity.BlogComment;
import blog.main.entity.BlogProduct;
import blog.main.entity.Category;
import blog.main.entity.User;
 

@Repository
public class BlogProductDAOImplementation implements BlogProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private BlogCommentDAO blogCommentDAO;
	
	@Override
	public List<BlogProduct> getBlogProductList() {
		Session session = sessionFactory.getCurrentSession();		
		List<BlogProduct> blogProductList = session.createQuery("from BlogProduct bp WHERE bp.enabled= 1 ORDER BY bp.date_created DESC").list();
		return blogProductList;
	}

	@Override
	public void addBlogProduct(BlogProduct blogProduct) {
		 
		Session session = sessionFactory.getCurrentSession();
		blogProduct.setEnabled(true);
		session.save(blogProduct);
  
	}

	@Override
	public void updateBlogProduct(BlogProduct blogProduct) {
		Session session = sessionFactory.getCurrentSession();	
		session.update(blogProduct);
		
		
	}

	@Override
	public BlogProduct getBlogProductById(int id_blog_product) {
		Session session = sessionFactory.getCurrentSession();	
		BlogProduct blogProduct = session.get(BlogProduct.class, id_blog_product);
		List<BlogComment> commentList = blogCommentDAO.getBlogCommentListByBlogID(id_blog_product);
		int commentCount = commentList.size();
		blogProduct.setComment_count(commentCount);
		session.saveOrUpdate(blogProduct);
		return blogProduct;
	}

	@Override
	public void deleteBlogProduct(int id_blog_product) {
		Session session = sessionFactory.getCurrentSession();	
		BlogProduct blogProduct = session.get(BlogProduct.class, id_blog_product);
		session.delete(blogProduct);
		
	}

	@Override
	public List<BlogProduct> getBlogProductLatest12onBlogPage(Integer pageNumber, Integer blogsPerPage) {
		Session session = sessionFactory.getCurrentSession();
		List<BlogProduct> blogList= session.createQuery("from BlogProduct bp WHERE bp.enabled= 1 ORDER BY bp.date_created DESC").list();
		
		 List<BlogProduct> blogList12 = new ArrayList<BlogProduct>();
		 Integer pageCount = 0;
		 Integer blogListSize= blogList.size();
		 //System.out.println("STAMPANJE BLOG LIST SIZE");
		 //System.out.println(blogListSize.toString());
		
		int bpp = blogsPerPage;
		 if(blogListSize<=bpp)
		 {
			 pageCount = 1;
		 }
		 else {
			 pageCount = (blogListSize%bpp!=0)? (((blogListSize-(blogListSize%bpp))/bpp)+1): (blogListSize/bpp);
		 }
		 
		 Integer[]pageCountArr = new Integer[pageCount];
		 for(int i = 1; i<=pageCount;i++) 
		 {
			 pageCountArr[i-1] = i;
		 }
		 
		 Integer[]blogCounter = new Integer[pageCount];
	 // popunjavanje liste rednih brojeva blog stranice 12 24 36 48 55 - npr. ako ima 55 blogova
		 
			 if(blogListSize<=bpp) {
				 for(int i = 1; i<=pageCount;i++) 
				 {
					 blogCounter[i-1] = blogListSize;
				 }
			 }
			 else if(blogListSize%bpp==0&blogListSize>bpp) {
				 for(int i = 1; i<=pageCount;i++) 
				 {
				 blogCounter[i-1] = bpp*i;
				 }
			 }
			 else if (blogListSize%bpp!=0&blogListSize>bpp){
				 for(int i = 1; i<=pageCount;i++) 
				 {
					 if(i==pageCount) {
						 blogCounter[i-1] = (bpp*(i-1))+blogListSize%bpp;
					 }
					 else {
						 blogCounter[i-1] = bpp*i;
					 }
				 }
			 }
		 
		 // ubacivanje blogova u listu od 12 ili manje blogova
		 
		 if(pageNumber==null) {
			 
			 for(int i = 0; i<blogCounter[0];i++) 
			 {
				 blogList12.add(blogList.get(i));
				 
			 }
		 }
		else if(pageNumber!=null&pageNumber==1) {
			 
			 int endIndex = blogCounter[pageNumber-1];
			 
				 for(int i = 0; i<endIndex;i++) 
				 {
					 blogList12.add(blogList.get(i));
					 
				 }
			 }
			 
		else   {
			 	int startIndex=  blogCounter[pageNumber-2];
			 	int endIndex = blogCounter[pageNumber-1];
				 for(int i = startIndex; i<endIndex;i++) 
				 {
					 blogList12.add(blogList.get(i));
					 
				 }
		}
		
		 
		return blogList12;
	}
	
	@Override
	public List<BlogProduct> getBlogProductLatest3() {
		Session session = sessionFactory.getCurrentSession();
		List<BlogProduct> blogProductList= session.createQuery("FROM BlogProduct bp WHERE bp.important= 1 AND bp.enabled= 1 ORDER BY bp.date_created DESC").setMaxResults(3).list();
		 
		return blogProductList;
	}

	
	@Override
	public List<BlogProduct> getBlogProductTop3() {
		Session session = sessionFactory.getCurrentSession();
		//List<BlogProduct> blogProductList= session.createQuery("FROM BlogProduct bp WHERE bp.enabled= 1 ORDER BY bp.visit_count DESC").setMaxResults(3).list();
	 
		Query query = session.createSQLQuery("call get_Blog_Product_Top_3(:date_begin);");
		String date_begin = (LocalDateTime.now().toLocalDate().minusDays(30)).toString();
		 
		query.setParameter("date_begin", date_begin);
		
		List<Object[]> rows = query.getResultList();
		List<BlogProduct> blogProductList = new ArrayList<BlogProduct>();
		for(Object[] row: rows) {
			
			BlogProduct bp = new BlogProduct();
			bp.setId_blog_product(Integer.parseInt(row[0].toString()));
			String username = row[1].toString();
			User user = session.get(User.class, username);
			bp.setUser(user);
			bp.setBlog_title(row[2].toString());
			bp.setDescription(row[3].toString());
			bp.setContent(row[4].toString());
			bp.setImportant(Boolean.parseBoolean(row[5].toString()));
			bp.setEnabled(Boolean.parseBoolean(row[6].toString()));
			bp.setImage(row[7].toString());
			bp.setVisit_count(Integer.parseInt(row[8].toString()));
			bp.setComment_count(Integer.parseInt(row[9].toString()));
			String dateTime = row[10].toString().substring(0,19);
			 
			String dateTimeFormatted = dateTime.replace(" ", "T");
			LocalDateTime ldtCreated = LocalDateTime.parse(dateTimeFormatted);
			 
			bp.setDate_created(ldtCreated);
			 
			Category category = session.get(Category.class, Integer.parseInt(row[12].toString()));
			bp.setCategory(category);
			bp.setDate_string(row[13].toString());
			 
			List<BlogComment> bcl = blogCommentDAO.getBlogCommentListByBlogID(Integer.parseInt(row[0].toString()));
			bp.setBlog_comments(bcl);
			
			blogProductList.add(bp);
		}
		 
		return blogProductList;
	}

	@Override
	public List<BlogProduct> getMostViewBlogProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogProduct> getBlogProductListByCategoryId(Integer category_id) {
		Session session = sessionFactory.getCurrentSession();		
		Query query = session.createQuery("from BlogProduct bp where bp.category.id_category = : category AND bp.enabled= 1 ORDER BY bp.date_created DESC");
		query.setParameter("category",category_id);
		List<BlogProduct> blogProductList = query.getResultList();
		return blogProductList;
	}

	@Override
	public List<BlogProduct> getBlogProductListByTagId(Integer id_tag) {
		Session session = sessionFactory.getCurrentSession();		
		//Query query = session.createSQLQuery("select * from blog_product where id_blog_product in (select blog_product_id from blog_product_tag where tag_id = (:id_tag)) and enabled= 1 order by date_created desc ");
		Query query = session.createSQLQuery("call get_BlogProductList_By_TagId(:id_tag);");
		query.setParameter("id_tag",id_tag);
		List<Object[]> rows = query.getResultList();
		List<BlogProduct> blogProductList = new ArrayList<BlogProduct>();
		for(Object[] row: rows) {
			
			BlogProduct bp = new BlogProduct();
			bp.setId_blog_product(Integer.parseInt(row[0].toString()));
			String username = row[1].toString();
			User user = session.get(User.class, username);
			bp.setUser(user);
			bp.setBlog_title(row[2].toString());
			bp.setDescription(row[3].toString());
			bp.setContent(row[4].toString());
			bp.setImportant(Boolean.parseBoolean(row[5].toString()));
			bp.setEnabled(Boolean.parseBoolean(row[6].toString()));
			bp.setImage(row[7].toString());
			bp.setVisit_count(Integer.parseInt(row[8].toString()));
			bp.setComment_count(Integer.parseInt(row[9].toString()));
			String dateTime = row[10].toString().substring(0,19);
			 
			String dateTimeFormatted = dateTime.replace(" ", "T");
			LocalDateTime ldtCreated = LocalDateTime.parse(dateTimeFormatted);
			 
			bp.setDate_created(ldtCreated);
			 
			Category category = session.get(Category.class, Integer.parseInt(row[12].toString()));
			bp.setCategory(category);
			bp.setDate_string(row[13].toString());
			 
			List<BlogComment> bcl = blogCommentDAO.getBlogCommentListByBlogID(Integer.parseInt(row[0].toString()));
			bp.setBlog_comments(bcl);
			
			blogProductList.add(bp);
			
		}
		  
		return blogProductList;
	}

	@Override
	public List<BlogProduct> getBlogProductListByAuthor(User user) {
		Session session = sessionFactory.getCurrentSession();		
		Query query=session.createQuery("from BlogProduct bp where bp.user = : user AND bp.enabled= 1 ORDER BY bp.date_created DESC");
		query.setParameter("user",user);
		List<BlogProduct> blogProductList = query.getResultList();
		return blogProductList;
		
	}
	
	@Override
	public List<BlogProduct> getBlogProductSearch(Integer id_category, String title, Integer[] tags, String author_name, String author_surname, Boolean enabled) {
		Session session=sessionFactory.getCurrentSession();
		String queryString="SELECT DISTINCT bp FROM BlogProduct bp LEFT JOIN bp.tags t ";
		
		boolean whereClause = false;
		 
		
		if(id_category!=null && id_category>0)
		{
			
			if(whereClause)
			{
				queryString=queryString+" AND bp.category.id_category = : id_category ";
			}
			else
			{
				queryString=queryString+" WHERE bp.category.id_category = : id_category ";
				whereClause=true;
			}
		}
		if(title!=null && title.length()>0)
		{
			if(whereClause)
			{
				queryString=queryString+" AND bp.blog_title like : title";
			}
			else
			{
				queryString=queryString+" WHERE bp.blog_title like : title";
				whereClause=true;
			}
		}
		if(author_name!=null && author_name.length()>0)
		{
			if(whereClause)
			{
				queryString=queryString+" AND bp.user.name like : author_name";
			}
			else
			{
				queryString=queryString+" WHERE bp.user.name like : author_name";
				whereClause=true;
			}
		}
		if(author_surname!=null && author_surname.length()>0)
		{
			if(whereClause)
			{
				queryString=queryString+" AND bp.user.surname like : author_surname";
			}
			else
			{
				queryString=queryString+" WHERE bp.user.surname like : author_surname";
				whereClause=true;
			}
		}
		
		if(enabled!=null)
		{
			if(whereClause)
			{
				  queryString=queryString+" AND bp.enabled = : enabled";
			}
			else
			{
				  queryString=queryString+" WHERE bp.enabled = : enabled";
				  whereClause=true;
			}
		}
		if(tags!=null && tags.length>0)
		{
			if(whereClause)
			{
				  queryString=queryString+" AND t.id_tag in (:tags)";
			}
			else
			{
				  queryString=queryString+" WHERE t.id_tag in (:tags)";
				  whereClause=true;
			}
		}
		/*
		System.out.println("---------------STAMPANJE HIBERNATE QUERY:--------------");
		if(tags!=null) {
		for(int t:tags) {
			System.out.print("["+t+"]");
		}
		}
		System.out.println(queryString);
		*/
		Query query=session.createQuery(queryString);
		if(id_category!=null && id_category>0)
		{
			query.setParameter("id_category", id_category);
		}
		if(title!=null && title.length()>0)
		{
			query.setParameter("title", "%"+title+"%");
		}
		if(author_name!=null && author_name.length()>0)
		{
			query.setParameter("author_name", author_name);
		}
		if(author_surname!=null && author_surname.length()>0)
		{
			query.setParameter("author_surname", author_surname);
		}
		if(enabled!=null)
		{
			query.setParameter("enabled", enabled);
		}
		
		if(tags!=null && tags.length>0)
		{
			query.setParameterList("tags", tags);
		}
		List<BlogProduct>blogProductList = query.getResultList();
		return blogProductList;
	}

	@Override
	public List<BlogProduct> getBlogProductLatest12() {
		Session session = sessionFactory.getCurrentSession();
		List<BlogProduct> blogProductList= session.createQuery("FROM BlogProduct bp WHERE bp.enabled= 1 ORDER BY bp.date_created DESC").setMaxResults(12).list();
		 
		return blogProductList;
	 
	}

	@Override
	public BigInteger getCategoryCount(int id_category) {
		Session session = sessionFactory.getCurrentSession();
		 
		//Query query = session.createSQLQuery("select count(*) from blog_product where category_id = (:id_category) and enabled= 1 ");
		Query query = session.createSQLQuery("call get_Category_Count(:id_category);");
		query.setParameter("id_category",id_category);
		BigInteger count = (BigInteger) query.uniqueResult();
		 
		return count;
	}

	@Override
	public List<BlogProduct> getBlogProductSearchPage(String text) {
		Session session = sessionFactory.getCurrentSession();
		 
		Query query= session.createQuery("FROM BlogProduct bp WHERE bp.blog_title like :text or bp.description like :text or bp.content like :text");
		query.setParameter("text", "%"+text+"%");
		
		List<BlogProduct> blogProductSearchList = query.getResultList();
		 
		return blogProductSearchList;
	}

	@Override
	public List<BlogProduct> getBlogProductSearchByUser(String title, Integer id_category, Integer[] tags,Boolean enabled, String username) {
		 
		Session session=sessionFactory.getCurrentSession();
		String queryString="SELECT DISTINCT bp FROM BlogProduct bp LEFT JOIN bp.tags t ";
		
		boolean whereClause = false;
		 
		 
		if(id_category!=null && id_category>0)
		{
			
			if(whereClause)
			{
				queryString=queryString+" AND bp.category.id_category = : id_category ";
			}
			else
			{
				queryString=queryString+" WHERE bp.category.id_category = : id_category ";
				whereClause=true;
			}
		}
		if(title!=null && title.length()>0)
		{
			if(whereClause)
			{
				queryString=queryString+" AND bp.blog_title like : title";
			}
			else
			{
				queryString=queryString+" WHERE bp.blog_title like : title";
				whereClause=true;
			}
		}
		
		if(enabled!=null)
		{
			if(whereClause)
			{
				  queryString=queryString+" AND bp.enabled = : enabled";
			}
			else
			{
				  queryString=queryString+" WHERE bp.enabled = : enabled";
				  whereClause=true;
			}
		}
		if(tags!=null && tags.length>0)
		{
			if(whereClause)
			{
				  queryString=queryString+" AND t.id_tag in (:tags)";
			}
			else
			{
				  queryString=queryString+" WHERE t.id_tag in (:tags)";
				  whereClause=true;
			}
		}
		
		if(username!=null && username.length()>0)
		{
			if(whereClause)
			{
				queryString=queryString+" AND bp.user.username like : username";
			}
			else
			{
				queryString=queryString+" WHERE bp.user.username like : username";
				whereClause=true;
			}
		}
		 /*
		System.out.println("---------------STAMPANJE HIBERNATE QUERY:--------------");
		if(tags!=null) {
		for(int t:tags) {
			System.out.print("["+t+"]");
		}
		}
		System.out.println(queryString);
		  */
		
		Query query=session.createQuery(queryString);
		if(id_category!=null && id_category>0)
		{
			query.setParameter("id_category", id_category);
		}
		if(title!=null && title.length()>0)
		{
			query.setParameter("title", "%"+title+"%");
		}
		if(enabled!=null)
		{
			query.setParameter("enabled", enabled);
		}
		
		if(tags!=null && tags.length>0)
		{
			query.setParameterList("tags", tags);
		}
		if(username!=null && username.length()>0)
		{
			query.setParameter("username", username);
		}
		
		List<BlogProduct>blogProductList = query.getResultList();
		return blogProductList;
		
	}

	@Override
	public List<BlogProduct> getBlogProductLatest5Dashboard() {
		Session session = sessionFactory.getCurrentSession();
		List<BlogProduct> blogProductList= session.createQuery("FROM BlogProduct bp WHERE bp.enabled= 1 ORDER BY bp.date_created DESC").setMaxResults(5).list();
		 
		return blogProductList;
	}

	@Override
	public void callDateString() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("call set_date_as_format;");
		query.executeUpdate();
	}

	@Override
	public int getBlogCreatedPast7Days() {
		Session session = sessionFactory.getCurrentSession();
		Query query =session.createSQLQuery("select count(*) from blog_product where date(date_created) > :commentDate");
		LocalDate date = LocalDate.now().minusDays(7);
		query.setParameter("commentDate", date);
		int res = Integer.parseInt(query.uniqueResult().toString());
		return res;
	}


	

}
