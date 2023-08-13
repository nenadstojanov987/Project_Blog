package blog.main.dao;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.main.entity.Category;
import blog.main.entity.Slider;

@Repository
public class CategoryDAOImplementation implements CategoryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> getCategoryList() {
		Session session =  sessionFactory.getCurrentSession();
		List<Category> categoryList = session.createQuery("from Category c").list();
		
		return categoryList;
	}

	@Override
	public void addCategory(Category category) {
		Session session =  sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
	}

	@Override
	public Category getCategoryById(int id_category) {
		Session session =  sessionFactory.getCurrentSession();
		Category category = session.get(Category.class, id_category);
		return category;
	}

	@Override
	public void setCategoryPriority(int id_category, int priority) {
		
		Category category = this.getCategoryById(id_category);
		category.setCategory_priority(priority);
		this.addCategory(category);
		
	}

	@Override
	public void deleteCategory(int id_category) {
		Session session =  sessionFactory.getCurrentSession();
		Category category = session.get(Category.class, id_category);
		session.delete(category);
		
	}

	@Override
	public List<Category> getCategoryListByPriority() {
		Session session =  sessionFactory.getCurrentSession();
		List<Category> categoryList = session.createQuery("from Category c where c.category_priority > 0 order by c.category_priority asc").list();
		 
		return categoryList;
	}

	@Override
	public List<Category> getCategoryListByPriorityTop4() {
		 
			Session session = sessionFactory.getCurrentSession();
	        //String mySqlQuery = "select * from category where category_priority>0 order by category_priority asc limit 4";
			String mySqlQuery = "select * from getCategoryListByPriorityTop4;";
	        Query query = session.createSQLQuery(mySqlQuery);
	       
	        List<Category>categoryList = new ArrayList<Category>();

	       
			  List<Object[]> rows = query.getResultList();
			 
			  for(Object[] row : rows){
				Category category = new Category();
				category.setId_category(Integer.parseInt(row[0].toString()));
				category.setCategory_name((row[1].toString()));
				category.setCategory_description((row[2].toString()));
				category.setCategory_priority(Integer.parseInt(row[3].toString()));
				category.setCategory_blog_count(Integer.parseInt(row[4].toString()));
				categoryList.add(category);
			}		
			return categoryList;
	        
	}

	@Override
	public Category getCategoryByBlogId(int id_blog_product) {
		Session session = sessionFactory.getCurrentSession();
		//Query query=session.createSQLQuery("select category.id_category, category.category_name, category.category_description, category.category_priority, category.category_blog_count from category join blog_product on category.id_category=blog_product.category_id where blog_product.id_blog_product = (:id_blog_product)");
		Query query=session.createSQLQuery("call get_Category_By_BlogId (:blog_product_id);");
		query.setParameter("blog_product_id", id_blog_product);
		
		 List<Object[]> rows = query.getResultList();
		 
		 Category category = new Category();
		  for(Object[] row : rows){
			category.setId_category(Integer.parseInt(row[0].toString()));
			category.setCategory_name((row[1].toString()));
			category.setCategory_description((row[2].toString()));
			category.setCategory_priority(Integer.parseInt(row[3].toString()));
			category.setCategory_blog_count(Integer.parseInt(row[4].toString()));
		}		
		return category;
	}

	@Override
	public void updateCategory(Category category) {
		Session session =  sessionFactory.getCurrentSession();
		session.update(category);
		
	}

}
