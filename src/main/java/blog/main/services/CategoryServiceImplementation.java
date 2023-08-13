package blog.main.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.main.dao.CategoryDAO;
import blog.main.entity.Category;

@Component
public class CategoryServiceImplementation implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@Transactional
	@Override
	public List<Category> getCategoryList() {
		List<Category>categoryList = categoryDAO.getCategoryList();
		return categoryList;
	}
	
	@Transactional
	@Override
	public void addCategory(Category category) {
		categoryDAO.addCategory(category);
		
	}

	@Transactional
	@Override
	public Category getCategoryById(int id_category) {
		Category category = categoryDAO.getCategoryById(id_category);
		return category;
	}

	@Transactional
	@Override
	public void setCategoryPriority(int id_category, int priority) {
		categoryDAO.setCategoryPriority(id_category, priority);
		
	}

	@Transactional
	@Override
	public void deleteCategory(int id_category) {
		categoryDAO.deleteCategory(id_category);
		
	}

	@Transactional
	@Override
	public List<Category> getCategoryListByPriority() {
		List<Category>categoryList = categoryDAO.getCategoryListByPriority();
		return categoryList;
	}

	@Transactional
	@Override
	public List<Category> getCategoryListByPriorityTop4() {
		List<Category>categoryList = categoryDAO.getCategoryListByPriorityTop4();
		return categoryList;
	}

	@Transactional
	@Override
	public Category getCategoryByBlogId(int id_blog_product) {
		Category category = categoryDAO.getCategoryByBlogId(id_blog_product);
		return category;
	}
	
	@Transactional
	@Override
	public void updateCategory(Category category) {
		categoryDAO.updateCategory(category);
	}

}
