package blog.main;

import java.math.BigInteger;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;



import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import blog.main.entity.BlogComment;
import blog.main.entity.BlogProduct;
import blog.main.entity.Category;
import blog.main.entity.Contact;
import blog.main.entity.Slider;
import blog.main.entity.Tag;
import blog.main.entity.User;
import blog.main.entity.VisitLog;
import blog.main.entity.Visitor;
import blog.main.entity.Message;
import blog.main.services.BlogCommentServices;
import blog.main.services.BlogProductService;
import blog.main.services.CategoryService;
import blog.main.services.ContactService;
import blog.main.services.MessageService;
import blog.main.services.SliderService;
import blog.main.services.TagService;
import blog.main.services.UserService;
import blog.main.services.VisitLogService;
 

@Controller

public class FrontController {

	@Autowired
	private SliderService sliderService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private MessageService messageService;
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
	@Autowired
	private ContactService contactService;
	@Autowired
	private VisitLogService visitLogService;
	
	//----- INDEX PAGE ----------//
	
	@RequestMapping(value={"/index","","/"})
	public String getIndexPage(Model model, Principal principal) {
		if(principal!=null) {
			User user = userService.getUserByName(principal.getName());
			model.addAttribute("user", user);
		}
		 
		 List<Slider> sliderList = sliderService.getEnabledSliderList();
		 List<Category> categoryListPriorityTop4 = categoryService.getCategoryListByPriorityTop4();
		 List<BlogProduct> top3BlogList = blogProductServices.getBlogProductLatest3();
		 List<BlogProduct> latestBlogList12 = blogProductServices.getBlogProductLatest12();
		 List<BlogProduct> latestBlogListFooter = blogProductServices.getBlogProductLatest3();
		 Contact contact = contactService.getContactInfo();
		 List<BlogProduct> latestBlogList1 = new ArrayList<BlogProduct>();
		 List<BlogProduct> latestBlogList2 = new ArrayList<BlogProduct>();
		 List<BlogProduct> latestBlogList3 = new ArrayList<BlogProduct>();
		 List<BlogProduct> latestBlogList4 = new ArrayList<BlogProduct>();
		 for(int i = 0; i<latestBlogList12.size(); i++) 
		 {
			 int res = (i)/3;
			 switch(res) 
			 {
			 	case 0: latestBlogList1.add(latestBlogList12.get(i));
			 	break;
			 	case 1: latestBlogList2.add(latestBlogList12.get(i));
			 	break;
			 	case 2: latestBlogList3.add(latestBlogList12.get(i));
			 	break;
			 	default: latestBlogList4.add(latestBlogList12.get(i));
			 }
		 }
		 
		 
		 BlogProduct blog1 = top3BlogList.get(0);
		 BlogProduct blog2 = top3BlogList.get(1);
		 BlogProduct blog3= top3BlogList.get(2);
		
			model.addAttribute("contact", contact);
			
		 model.addAttribute("sliderList",sliderList);
		 model.addAttribute("categoryListPriorityTop4",categoryListPriorityTop4);
		 
		 model.addAttribute("blog1",blog1);
		 model.addAttribute("blog2",blog2);
		 model.addAttribute("blog3",blog3);
		 
		 model.addAttribute("latestBlogList1",latestBlogList1);
		 model.addAttribute("latestBlogList2",latestBlogList2);
		 model.addAttribute("latestBlogList3",latestBlogList3);
		 model.addAttribute("latestBlogList4",latestBlogList4);
		 
		 model.addAttribute("latestBlogListFooter",latestBlogListFooter);
		 
		 return "index";
	}
	
	
	//----- BLOG PAGE ----------//
		@RequestMapping(value="/blog")
		public String getBlogPage(@RequestParam (required=false) Integer pageNumber, Model model, Principal principal) {
			if(principal!=null) {
				User user = userService.getUserByName(principal.getName());
				model.addAttribute("user", user);
			}
			 List<BlogProduct> blogList = blogProductServices.getBlogProductList();
			 List<Category> categoryList= categoryService.getCategoryList();
			 
			 
			 for(Category c: categoryList) {
				 BigInteger count = blogProductServices.getCategoryCount(c.getId_category());
				 //int res = (int)count;
				 int resCount = count.intValue();
				 c.setCategory_blog_count(resCount);
				 categoryService.updateCategory(c);
				 
			 }
			 
			 List<Category> categoryListPriorityTop4 = categoryService.getCategoryListByPriorityTop4();
			 
			 
			 List<BlogProduct> top3BlogList = blogProductServices.getBlogProductTop3();
			 List<BlogProduct> latestBlogListFooter = blogProductServices.getBlogProductLatest3();
			 List<Tag> tagListByFrequency = tagServices.getTagListByFrequency();
			 
			 int bpp = 12;
			 Integer pageCount = 0;
			 Integer blogListSize= blogList.size();
			
			 List<BlogProduct> blogList12 = blogProductServices.getBlogProductLatest12onBlogPage(pageNumber, bpp);
			 
			 
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
			 int currentPage=pageNumber==null?1:pageNumber;
			 int count = currentPage;
			 int previousPage = currentPage>1?currentPage-1:currentPage;
			 int nextPage = currentPage<pageCount?currentPage+1:currentPage;
			 
			 Contact contact = contactService.getContactInfo();
			     model.addAttribute("contact",contact);
				 model.addAttribute("pageCountArr",pageCountArr);
				 model.addAttribute("blogList12",blogList12);
				 model.addAttribute("categoryListPriorityTop4",categoryListPriorityTop4);
				 model.addAttribute("categoryList",categoryList);
				 model.addAttribute("tagList",tagListByFrequency);
				 model.addAttribute("top3BlogList",top3BlogList);
				 model.addAttribute("latestBlogListFooter",latestBlogListFooter);
				 model.addAttribute("count",count);
				 model.addAttribute("previousPage",previousPage);
				 model.addAttribute("nextPage",nextPage);
			 return "blog";
		}
		
		@RequestMapping(value="/blog-post/{blog_title}/{id_blog_product}")
		public String getBlogPostPage(@PathVariable String blog_title,@PathVariable int id_blog_product, Model model, Principal principal) {
			if(principal!=null) {
				User user = userService.getUserByName(principal.getName());
				model.addAttribute("user", user);
			}
		    BlogProduct blogProduct = blogProductServices.getBlogProductById(id_blog_product);
		    if(principal==null) {
		    	int numberOfVisit = blogProduct.getVisit_count();
				numberOfVisit++;
				blogProduct.setVisit_count(numberOfVisit);
				blogProductServices.updateBlogProduct(blogProduct);
				VisitLog vl = new VisitLog(id_blog_product,LocalDateTime.now());
				visitLogService.addVisitLog(vl);
		    }
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
			 
			 Contact contact = contactService.getContactInfo();
		     model.addAttribute("contact",contact);
			 model.addAttribute("categoryListPriorityTop4",categoryListPriorityTop4);
			 model.addAttribute("categoryList",categoryList);
			 model.addAttribute("tagList",tagList);
			 model.addAttribute("top3BlogList",top3BlogList);
			 model.addAttribute("latestBlogListFooter",latestBlogListFooter);
			 model.addAttribute("blogProduct",blogProduct);
			 model.addAttribute("previousBlogPost",previousBlogPost);
			 model.addAttribute("nextBlogPost",nextBlogPost);
			 model.addAttribute("blogTagList",blogTagList);
			 
			 model.addAttribute("currentBlogIndex",currentBlogIndex);
			 model.addAttribute("lastBlogIndex",lastBlogIndex);
			  
			 
			 model.addAttribute("blogCommentList",blogCommentList);
			 model.addAttribute("blogComment",new BlogComment());
			  
			 return "blog-post";
		}
		
		@RequestMapping(value="/blog-post-category/{category_name}/{id_category}")
		public String getBlogPostPageByCategory(@PathVariable String category_name,@PathVariable int id_category, Model model, Principal principal) {
			if(principal!=null) {
				User user = userService.getUserByName(principal.getName());
				model.addAttribute("user", user);
			}
			
			 List<BlogProduct> blogListByCategory = blogProductServices.getBlogProductListByCategoryId(id_category);
		    
			 List<BlogProduct> top3BlogList = blogProductServices.getBlogProductTop3();
			 List<Category> categoryList= categoryService.getCategoryList();
			 
			  
			 
			 List<Category> categoryListPriorityTop4 = categoryService.getCategoryListByPriorityTop4();
			 
			 
			 List<BlogProduct> latestBlogListFooter = blogProductServices.getBlogProductLatest3();
			 List<Tag> tagList = tagServices.getTagList();
			 
			 Contact contact = contactService.getContactInfo();
		     model.addAttribute("contact",contact);
			 model.addAttribute("categoryListPriorityTop4",categoryListPriorityTop4);
			 model.addAttribute("categoryList",categoryList);
			 model.addAttribute("tagList",tagList);
			 model.addAttribute("top3BlogList",top3BlogList);
			 model.addAttribute("latestBlogListFooter",latestBlogListFooter);
			  
			 model.addAttribute("category_name",category_name);
			 model.addAttribute("blogListByCategory",blogListByCategory);
			
			 return "/blog-post-category";
		}
		
		@RequestMapping(value="/blog-post-author/{name}-{surname}/{username}")
		public String getBlogPostPageByAuthor(@PathVariable String name, @PathVariable String surname, @PathVariable String username, Model model, Principal principal) {
			if(principal!=null) {
				User user = userService.getUserByName(principal.getName());
				model.addAttribute("user", user);
			}
			 User user = userService.getUserByUsername(username);
			 List<BlogProduct> blogListByAuthor= blogProductServices.getBlogProductListByAuthor(user);
		     
			 
		     
			 List<BlogProduct> top3BlogList = blogProductServices.getBlogProductTop3();
			 List<Category> categoryList= categoryService.getCategoryList();
			 List<Category> categoryListPriorityTop4 = categoryService.getCategoryListByPriorityTop4();
			 List<BlogProduct> latestBlogListFooter = blogProductServices.getBlogProductLatest3();
			 List<Tag> tagList = tagServices.getTagList();
			 
			 
			 Contact contact = contactService.getContactInfo();
		     model.addAttribute("contact",contact);
			 model.addAttribute("categoryListPriorityTop4",categoryListPriorityTop4);
			 model.addAttribute("categoryList",categoryList);
			 model.addAttribute("tagList",tagList);
			 model.addAttribute("top3BlogList",top3BlogList);
			 model.addAttribute("latestBlogListFooter",latestBlogListFooter);
			 model.addAttribute("user",user);
			 model.addAttribute("author_name",name+" "+surname);
			 model.addAttribute("author_image",user.getImage());
			 model.addAttribute("blogListByAuthor",blogListByAuthor);
			 //model.addAttribute("visitor", new Visitor());
			 return "/blog-post-author";
		}
		
		@RequestMapping(value="/blog-post-tags/{tag_name}/{id_tag}")
		public String getBlogPostPageByTag(@PathVariable String tag_name,@PathVariable int id_tag, Model model, Principal principal) {
			if(principal!=null) {
				User user = userService.getUserByName(principal.getName());
				model.addAttribute("user", user);
			}
			
			 List<BlogProduct> blogListByTag = blogProductServices.getBlogProductListByTagId(id_tag);
			// List<BlogProduct> blogListByTag = blogProductServices.getBlogProductLatest12();
			 
			 List<BlogProduct> top3BlogList = blogProductServices.getBlogProductTop3();
			 List<Category> categoryList= categoryService.getCategoryList();
			 List<Category> categoryListPriorityTop4 = categoryService.getCategoryListByPriorityTop4();
			 List<BlogProduct> latestBlogListFooter = blogProductServices.getBlogProductLatest3();
			 List<Tag> tagList = tagServices.getTagList();
			 
			 Contact contact = contactService.getContactInfo();
		     model.addAttribute("contact",contact);
			 model.addAttribute("categoryListPriorityTop4",categoryListPriorityTop4);
			 model.addAttribute("categoryList",categoryList);
			 model.addAttribute("tagList",tagList);
			 model.addAttribute("top3BlogList",top3BlogList);
			 model.addAttribute("latestBlogListFooter",latestBlogListFooter);
			  
			 model.addAttribute("tag_name",tag_name);
			  
			 model.addAttribute("blogListByTag",blogListByTag);
		 
			 return "/blog-post-tags";
		}
	
		
		@RequestMapping(value="/blog-comment-save")
		public String getBlogComment(@RequestParam Integer id_blog_product, @ModelAttribute("blogComment") @Validated BlogComment blogComment, BindingResult bindingResult
				,Model model, Principal principal) 
		{
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
			 else {
			 
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
		
		
		
		@RequestMapping(value="/blog-search-page")
		public String getSearchPage(@RequestParam (required=false) String text, Model model, Principal principal) {
			if(principal!=null) {
				User user = userService.getUserByName(principal.getName());
				model.addAttribute("user", user);
			}
			
			 List<BlogProduct> blogListSearch = blogProductServices.getBlogProductSearchPage(text);
			 List<Category> categoryList= categoryService.getCategoryList();
			 
			 
			 for(Category c: categoryList) {
				 BigInteger count = blogProductServices.getCategoryCount(c.getId_category());
				 int resCount = count.intValue();
				 c.setCategory_blog_count(resCount);
				 categoryService.updateCategory(c);
				 
			 }
			 
			 List<Category> categoryListPriorityTop4 = categoryService.getCategoryListByPriorityTop4();
			 List<BlogProduct> top3BlogList = blogProductServices.getBlogProductTop3();
			 List<BlogProduct> latestBlogListFooter = blogProductServices.getBlogProductLatest3();
			 List<Tag> tagListByFrequency = tagServices.getTagListByFrequency();
			 
			 Contact contact = contactService.getContactInfo();
		     	 model.addAttribute("contact",contact);
				 model.addAttribute("blogListSearch",blogListSearch);
				 model.addAttribute("categoryListPriorityTop4",categoryListPriorityTop4);
				 model.addAttribute("categoryList",categoryList);
				 model.addAttribute("tagList",tagListByFrequency);
				 model.addAttribute("top3BlogList",top3BlogList);
				 model.addAttribute("latestBlogListFooter",latestBlogListFooter);
				  
			 return "blog-search-page";
		}
		
	//----- CONTACT PAGE ----------//
	@RequestMapping(value="/contact")
	public String getContactPage(Model model, Principal principal ) {
		 Message message = new Message();
		 List<Category> categoryListPriorityTop4 = categoryService.getCategoryListByPriorityTop4();
		 List<BlogProduct> top3BlogList = blogProductServices.getBlogProductTop3();
		 List<BlogProduct> latestBlogListFooter = blogProductServices.getBlogProductLatest3();
		 Contact contact = contactService.getContactInfo();
		
		if(principal!=null) {
			User user = userService.getUserByName(principal.getName());
			 model.addAttribute("user", user);
			 model.addAttribute("contact",contact);
			 model.addAttribute("top3BlogList",top3BlogList);
			 model.addAttribute("latestBlogListFooter",latestBlogListFooter);
			 model.addAttribute("categoryListPriorityTop4",categoryListPriorityTop4);
		}
		
		 
		 model.addAttribute("categoryListPriorityTop4",categoryListPriorityTop4);
		 model.addAttribute("message",message);
		 model.addAttribute("contact",contact);
		 model.addAttribute("top3BlogList",top3BlogList);
		 model.addAttribute("latestBlogListFooter",latestBlogListFooter);
		 return "contact";
	
	}
	
	@RequestMapping(value="/message-save")
	public String saveTag(@ModelAttribute("message") @Validated Message message, BindingResult bindingResult, Principal principal, Model model ) {
		 
		 List<Category> categoryListPriorityTop4 = categoryService.getCategoryListByPriorityTop4();
		 List<BlogProduct> top3BlogList = blogProductServices.getBlogProductTop3();
		 List<BlogProduct> latestBlogListFooter = blogProductServices.getBlogProductLatest3();
		 Contact contact = contactService.getContactInfo();
		 
		if (bindingResult.hasErrors()) {
			
			if(principal!=null) {
				User user = userService.getUserByName(principal.getName());
				 model.addAttribute("user", user);
				 model.addAttribute("contact",contact);
				 model.addAttribute("top3BlogList",top3BlogList);
				 model.addAttribute("latestBlogListFooter",latestBlogListFooter);
				 model.addAttribute("categoryListPriorityTop4",categoryListPriorityTop4);
				 return "contact";
			}
			else {
				
				 model.addAttribute("contact",contact);
				 model.addAttribute("top3BlogList",top3BlogList);
				 model.addAttribute("latestBlogListFooter",latestBlogListFooter);
				 model.addAttribute("categoryListPriorityTop4",categoryListPriorityTop4);
				 return "contact";
			}
			 
		 
		}
		message.setMessage_date(LocalDateTime.now());
		messageService.saveMessage(message);
		return "redirect: contact";
	}
	

	
}
