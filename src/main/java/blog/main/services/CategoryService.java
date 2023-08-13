package blog.main.services;

import java.util.List;
 
import org.springframework.stereotype.Service;

import blog.main.entity.Category;
@Service
public interface CategoryService {
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
