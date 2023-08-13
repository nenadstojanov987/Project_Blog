package blog.main.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import blog.main.entity.Category;
 
@Component
public interface CategoryDAO {

	public List<Category> getCategoryList();
	public List<Category> getCategoryListByPriority();
	public List<Category> getCategoryListByPriorityTop4();
	public void addCategory(Category category);
	public Category getCategoryById(int id_category);
	public Category getCategoryByBlogId(int id_blog_product);
 	public void setCategoryPriority(int id_category, int priority);
	public void deleteCategory(int id_category);
	public void updateCategory(Category category);
}
