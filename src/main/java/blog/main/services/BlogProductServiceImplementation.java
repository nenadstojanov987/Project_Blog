package blog.main.services;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.main.dao.BlogProductDAO;
import blog.main.entity.BlogProduct;
import blog.main.entity.User;

@Component
public class BlogProductServiceImplementation implements BlogProductService {

	@Autowired
	private BlogProductDAO blogProductDAO;
	
	@Transactional
	@Override
	public List<BlogProduct> getBlogProductList() {
		List<BlogProduct> blogProductList = blogProductDAO.getBlogProductList();
		return blogProductList;
	}

	@Transactional
	@Override
	public void addBlogProduct(BlogProduct blogProduct) {
		blogProductDAO.addBlogProduct(blogProduct);
		
	}

	@Transactional
	@Override
	public void updateBlogProduct(BlogProduct blogProduct) {
		blogProductDAO.updateBlogProduct(blogProduct);
		
	}

	@Transactional
	@Override
	public BlogProduct getBlogProductById(int id_blog_product) {
		BlogProduct blogProduct = blogProductDAO.getBlogProductById(id_blog_product);
		return blogProduct;
	}

	@Transactional
	@Override
	public void deleteBlogProduct(int id_blog_product) {
		blogProductDAO.deleteBlogProduct(id_blog_product);
		
	}

	@Transactional
	@Override
	public List<BlogProduct> getBlogProductLatest12onBlogPage(Integer pageNumber, Integer blogsPerPage) {
		 List<BlogProduct> blogList = blogProductDAO.getBlogProductLatest12onBlogPage(pageNumber, blogsPerPage);
		 return blogList;
	}

	@Transactional
	@Override
	public List<BlogProduct> getBlogProductLatest3() {
		 List<BlogProduct> blogList = blogProductDAO.getBlogProductLatest3();
		 return blogList;
	}

	@Transactional
	@Override
	public List<BlogProduct> getBlogProductTop3() {
		 List<BlogProduct> blogList = blogProductDAO.getBlogProductTop3();
		return blogList;
	}

	@Transactional
	@Override
	public List<BlogProduct> getMostViewBlogProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<BlogProduct> getBlogProductListByCategoryId(Integer category_id) {
		List<BlogProduct> blogProductList = blogProductDAO.getBlogProductListByCategoryId(category_id);
		return blogProductList;
	}

	@Transactional
	@Override
	public List<BlogProduct> getBlogProductListByTagId(Integer tag_id)  {
		List<BlogProduct> blogProductList = blogProductDAO.getBlogProductListByTagId(tag_id);
		return blogProductList;
	}

	@Transactional
	@Override
	public List<BlogProduct> getBlogProductListByAuthor(User user) {
		List<BlogProduct> blogProductList = blogProductDAO.getBlogProductListByAuthor(user);
		return blogProductList;
	}
	
	@Transactional
	@Override
	public List<BlogProduct> getBlogProductSearch(Integer category_id, String title, Integer[] tags, String author_name, String author_surname,Boolean enabled) {
		List<BlogProduct> blogProductList = blogProductDAO.getBlogProductSearch(category_id, title,tags, author_name, author_surname, enabled);
		
		return blogProductList;
	}

	@Transactional
	@Override
	public List<BlogProduct> getBlogProductLatest12() {
		List<BlogProduct> blogProductList = blogProductDAO.getBlogProductLatest12();
		return blogProductList;
	}

	@Transactional
	@Override
	public BigInteger getCategoryCount(int id_category) {
		BigInteger count = blogProductDAO.getCategoryCount(id_category);
		return count;
	}

	@Transactional
	@Override
	public List<BlogProduct> getBlogProductSearchPage(String text) {
		List<BlogProduct> blogProductSearchList = blogProductDAO.getBlogProductSearchPage(text);
		return blogProductSearchList;
	}

	@Transactional
	@Override
	public List<BlogProduct> getBlogProductSearchByUser(String title,Integer id_category,  Integer[] tags, Boolean enabled, String username) {
		 
		List<BlogProduct> blogProductSearchByUser = blogProductDAO.getBlogProductSearchByUser(title,id_category, tags, enabled, username);
		
		return blogProductSearchByUser;
	}

	@Transactional
	@Override
	public List<BlogProduct> getBlogProductLatest5Dashboard() {
		List<BlogProduct> blogProductSearchList = blogProductDAO.getBlogProductLatest5Dashboard();
		return blogProductSearchList;
	}

	@Transactional
	@Override
	public void callDateString() {
		blogProductDAO.callDateString();
		
	}

	@Transactional
	@Override
	public int getBlogCreatedPast7Days() {
		int res = blogProductDAO.getBlogCreatedPast7Days();
		return res;
	}


	

}
