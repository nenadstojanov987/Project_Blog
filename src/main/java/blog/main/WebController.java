/*
package blog.main;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import blog.main.entity.BlogComment;
import blog.main.entity.BlogProduct;
import blog.main.entity.Category;
import blog.main.entity.Tag;
import blog.main.entity.User;
import blog.main.entity.Visitor;
import blog.main.services.BlogCommentServices;
import blog.main.services.BlogProductService;
import blog.main.services.CategoryService;
import blog.main.services.ContactService;
import blog.main.services.MessageService;
import blog.main.services.SliderService;
import blog.main.services.TagService;
import blog.main.services.UserService;

@Controller
public class WebController implements WebMvcConfigurer {

	
 
	@Autowired
	private CategoryService categoryService;
 
	@Autowired
	private BlogProductService blogProductServices;
	@Autowired
	private TagService tagServices;
	@Autowired
	private BlogCommentServices blogCommentServices;
	@Autowired
	private TagService tagService;
	@Autowired
	private UserService userService;
 
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/blog-comment-save").setViewName("blog-comment-save");
	}

	@GetMapping("/blog-comment-save")
	public String showForm(Visitor visitor, BlogComment blogComment) {
		return "blog-comment-save";
	}

	@PostMapping("/blog-comment-save")
	public String checkVisitorInfo(@RequestParam Integer id_blog_product,@Valid Visitor visitor, @ModelAttribute("blogComment") @Validated BlogComment blogComment, BindingResult bindingResult, Model model, Principal principal) {

		if (bindingResult.hasErrors()) {
			 BlogProduct blogProduct = blogProductServices.getBlogProductById(id_blog_product);
			 
		     List<Tag>blogTagList = tagService.getTagListByBlogID(id_blog_product);
		     List<BlogComment> blogCommentList = blogCommentServices.getBlogCommentListByBlogID(id_blog_product);
		  
			 List<BlogProduct> top3BlogList = blogProductServices.getBlogProductTop3();
			 List<Category> categoryList= categoryService.getCategoryList();
			 List<Category> categoryListPriorityTop4 = categoryService.getCategoryListByPriorityTop4();
			 List<BlogProduct> latestBlogListFooter = blogProductServices.getBlogProductLatest3();
			 List<Tag> tagList = tagServices.getTagList();
			 
			 
			 int currentBlogIndex=0;
		     List<BlogProduct> blogListByDate = blogProductServices.getBlogProductList();
		     for(BlogProduct bp : blogListByDate) {
		    	 if(bp.getId_blog_product()==blogProduct.getId_blog_product()) {
		    		 currentBlogIndex = blogListByDate.indexOf(bp);
		    	 }
		    	 
		     }
		     int lastBlogIndex = blogListByDate.size()-1;
		     int previousBlogIndex, nextBlogIndex;
		     
		     if(currentBlogIndex==0)
		     { 
		    	 previousBlogIndex = currentBlogIndex+1;
		    	 nextBlogIndex = currentBlogIndex;
		     }
		     else if(currentBlogIndex==lastBlogIndex) 
		     {
		    	 previousBlogIndex = currentBlogIndex;
		    	 nextBlogIndex = currentBlogIndex-1;
		     }
		     else { 
			    	 previousBlogIndex = currentBlogIndex+1;
			    	 nextBlogIndex = currentBlogIndex-1;
			  
		     }
		     
		     BlogProduct previousBlogPost = blogListByDate.get(previousBlogIndex);
		     BlogProduct nextBlogPost = blogListByDate.get(nextBlogIndex); 
		    
			 
			 model.addAttribute("categoryListPriorityTop4",categoryListPriorityTop4);
			 model.addAttribute("categoryList",categoryList);
			 model.addAttribute("tagList",tagList);
			 model.addAttribute("top3BlogList",top3BlogList);
			 model.addAttribute("latestBlogListFooter",latestBlogListFooter);
			 model.addAttribute("blogProduct",blogProduct);
			 model.addAttribute("blogTagList",blogTagList);
			 model.addAttribute("blogCommentList",blogCommentList);
			  //model.addAttribute("blogComment",new BlogComment());
			  model.addAttribute("previousBlogPost",previousBlogPost);
			  model.addAttribute("nextBlogPost",nextBlogPost);
			return "blog-post";
			
			 
		}

		Visitor newVisitor = new Visitor();
		String visitor_image="";
		if(principal!=null) {
			User user = userService.getUserByName(principal.getName());
			visitor_image = user.getImage();
			newVisitor.setVisitor_image(visitor_image);
			newVisitor.setEmail(user.getEmail());
			newVisitor.setVisitor_name(user.getName());
			newVisitor.setBanned(false);
			model.addAttribute("user", user);
		}
		else {
			
			newVisitor.setBanned(false);
		    newVisitor.setEmail(blogComment.getVisitor().getEmail());
			newVisitor.setVisitor_name(blogComment.getVisitor().getVisitor_name());
		}
		 
	  
		     blogComment.setVisitor(newVisitor); 
			 blogComment.setEnabled(true);
		     blogComment.setBlog_product_id(id_blog_product);
		     blogComment.setBlog_comment_date(LocalDateTime.now());
			 blogCommentServices.addNewBlogComment(blogComment);
			 
			  
			 BlogProduct blogProduct = blogProductServices.getBlogProductById(id_blog_product);
			 
			 
			 int currentBlogIndex=0;
		     List<BlogProduct> blogListByDate = blogProductServices.getBlogProductList();
		     for(BlogProduct bp : blogListByDate) {
		    	 if(bp.getId_blog_product()==blogProduct.getId_blog_product()) {
		    		 currentBlogIndex = blogListByDate.indexOf(bp);
		    	 }
		    	 
		     }
		     int lastBlogIndex = blogListByDate.size()-1;
		     int previousBlogIndex, nextBlogIndex;
		     
		     if(currentBlogIndex==0)
		     { 
		    	 previousBlogIndex = currentBlogIndex+1;
		    	 nextBlogIndex = currentBlogIndex;
		     }
		     else if(currentBlogIndex==lastBlogIndex) 
		     {
		    	 previousBlogIndex = currentBlogIndex;
		    	 nextBlogIndex = currentBlogIndex-1;
		     }
		     else { 
			    	 previousBlogIndex = currentBlogIndex+1;
			    	 nextBlogIndex = currentBlogIndex-1;
			  
		     }
		     
		     BlogProduct previousBlogPost = blogListByDate.get(previousBlogIndex);
		     BlogProduct nextBlogPost = blogListByDate.get(nextBlogIndex); 
			 
			 
		     List<Tag>blogTagList = tagService.getTagListByBlogID(id_blog_product);
		     List<BlogComment> blogCommentList = blogCommentServices.getBlogCommentListByBlogID(id_blog_product);
		  
			 List<BlogProduct> top3BlogList = blogProductServices.getBlogProductTop3();
			 List<Category> categoryList= categoryService.getCategoryList();
			 List<Category> categoryListPriorityTop4 = categoryService.getCategoryListByPriorityTop4();
			 List<BlogProduct> latestBlogListFooter = blogProductServices.getBlogProductLatest3();
			 List<Tag> tagList = tagServices.getTagList();
			 
			 
			 model.addAttribute("categoryListPriorityTop4",categoryListPriorityTop4);
			 model.addAttribute("categoryList",categoryList);
			 model.addAttribute("tagList",tagList);
			 model.addAttribute("top3BlogList",top3BlogList);
			 model.addAttribute("latestBlogListFooter",latestBlogListFooter);
			 model.addAttribute("blogProduct",blogProduct);
			 model.addAttribute("blogTagList",blogTagList);
			 model.addAttribute("blogCommentList",blogCommentList);
			 model.addAttribute("blogComment",new BlogComment());
			  model.addAttribute("previousBlogPost",previousBlogPost);
			  model.addAttribute("nextBlogPost",nextBlogPost);
			 return "blog-post";

	 
	}
	
}
*/
