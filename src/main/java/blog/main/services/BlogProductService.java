package blog.main.services;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.List;

 
import org.springframework.stereotype.Service;

import blog.main.entity.BlogProduct;
import blog.main.entity.User;

@Service
public interface BlogProductService {

	List<BlogProduct> getBlogProductList();
	public void addBlogProduct(BlogProduct blogProduct);
	public void updateBlogProduct(BlogProduct blogProduct);
	public BlogProduct getBlogProductById(int id_blog_product);
	public void deleteBlogProduct(int id_blog_product);
	public List<BlogProduct>getBlogProductLatest12onBlogPage(Integer pageNumber, Integer blogsPerPage);
	public List<BlogProduct>getBlogProductLatest12();
	public List<BlogProduct>getBlogProductLatest3();
	public List<BlogProduct>getBlogProductLatest5Dashboard();
	public List<BlogProduct>getBlogProductTop3();
	public List<BlogProduct>getMostViewBlogProduct();
	public List<BlogProduct>getBlogProductListByCategoryId(Integer category_id);
	public List<BlogProduct>getBlogProductListByTagId(Integer tag_id);
	public List<BlogProduct>getBlogProductListByAuthor(User user);
	public List<BlogProduct> getBlogProductSearch(Integer category_id, String title,Integer[] tags, String author_name, String author_surname,Boolean enabled);
	public List<BlogProduct>getBlogProductSearchPage(String text);
	public BigInteger getCategoryCount(int id_category);
	public List<BlogProduct> getBlogProductSearchByUser(String title,Integer id_category, Integer[] tags,Boolean enabled, String username);
	public int getBlogCreatedPast7Days();
	public void callDateString();
}
