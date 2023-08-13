package blog.main;
import java.io.IOException;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;


import blog.main.entity.*;
import blog.main.services.BlogCommentServices;
import blog.main.services.BlogProductService;
import blog.main.services.CategoryService;
import blog.main.services.ContactService;
import blog.main.services.FileUploadService;
import blog.main.services.MessageService;
import blog.main.services.SliderService;
import blog.main.services.TagService;
import blog.main.services.UserService;
import blog.main.services.VisitLogService;
 
 
 

@Controller
@RequestMapping(value="admin")
public class AdminController {

	@Autowired
	private SliderService sliderService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TagService tagService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	@Autowired
	private BlogProductService blogProductService;
	@Autowired
	private BlogCommentServices blogCommentService;
	@Autowired
	private ContactService contactService;
	@Autowired
	private VisitLogService visitLogService;
	@Autowired
	private FileUploadService fileUploadService;
	
	  
	
	// --------------DASHBOARD -------------//
	@RequestMapping(value="/dashboard")
	public String getIndexPage(Principal principal, Model model) {
		User user = userService.getUserByName(principal.getName());
		long messageCount = messageService.getUnseenMessageCount();
		List<BlogProduct> blogList = blogProductService.getBlogProductLatest5Dashboard();
		 
		int totalBlogCount = blogProductService.getBlogProductList().size();
		int totalUserCount = userService.getUserList().size();
		
		List<VisitStat> visitStat = visitLogService.VisitLogStatByDate();
		String dates[] = new String[visitStat.size()];
		for(int i = 0; i<visitStat.size(); i++) {
			String dateFormat = visitStat.get(i).getVisitDate().toString();
			dateFormat = dateFormat.replace("-", "");
			dates[i]=dateFormat;
		}
		int visits[] = new int[visitStat.size()];
		for(int i = 0; i<visitStat.size(); i++) {
			visits[i]=visitStat.get(i).getVisitNumber();
		}
		String datesValue = (Arrays.toString(dates));
		String visitsValue = (Arrays.toString(visits));
		 
		int totalVisitNumber = visitLogService.getVisitLogList().size();
		long messagelistNumber = messageService.getMessageCount();
		int totalCommentNumber = blogCommentService.getBlogCommentList().size();
		int commentsPast7Days = blogCommentService.getBlogCommentNumberPast7days();
		int blogCreatedPast7Days = blogProductService.getBlogCreatedPast7Days();
		
		model.addAttribute("messageCount",messageCount);
		model.addAttribute("user", user);
		model.addAttribute("blogList", blogList);
		model.addAttribute("dates",datesValue);
		model.addAttribute("visits",visitsValue);
		model.addAttribute("totalBlogCount",totalBlogCount);
		model.addAttribute("totalUserCount",totalUserCount);
		model.addAttribute("totalVisitNumber",totalVisitNumber);
		model.addAttribute("totalVisitNumber",totalVisitNumber);
		model.addAttribute("messagelistNumber",messagelistNumber);
		model.addAttribute("totalCommentNumber",totalCommentNumber);
		model.addAttribute("commentsPast7Days",commentsPast7Days);
		model.addAttribute("blogCreatedPast7Days",blogCreatedPast7Days);
		 return "dashboard";
	}
	
	
	// ----- SLIDER ------- //
	 

	@RequestMapping(value="/slider-list")
	public String getSliderListPage(Model model, Principal principal) {
		User user = userService.getUserByName(principal.getName());
		model.addAttribute("user", user);
		List<Slider> sliderList = sliderService.getSliderList();
		model.addAttribute("sliderList",sliderList);
		return "slider-list";
	}
	 
	@RequestMapping(value="/slider-enabled")
	public String getEnabledSlider(@RequestParam int id_slider) {
		
		sliderService.enableSlider(id_slider);
		 
		return "redirect: slider-list";
	}
	
	@RequestMapping(value="/slider-delete")
	public String deleteSlider(@RequestParam int id_slider) {
		
		sliderService.deleteSlider(id_slider);
		 
		return "redirect: slider-list";
	}
	
	@RequestMapping(value="/slider-form")
	
	public String getSliderFormPage(Model model, Principal principal) {
		User user = userService.getUserByName(principal.getName());
		model.addAttribute("user", user);
		 
		model.addAttribute("slider", new Slider());
		return "slider-form";
	}
	 
	@RequestMapping(value="/slider-update")
	public String updateSlider(@RequestParam int id_slider, Model model, Principal principal) {
		User user = userService.getUserByName(principal.getName());
		model.addAttribute("user", user);
		
		Slider slider = sliderService.getSliderById(id_slider);
		model.addAttribute("slider", slider);
		 
		 
		return "slider-form";
	}
	
	@RequestMapping(value="/image-upload")
	public String ImageSliderUpload( Model model) {
	 
		 model.addAttribute("imageSlider",new ImageSlider());
		return "image-upload";
	}
	
	@RequestMapping(value="/upload-page")
	public String ImageUpload( Model model) {
	 
		return "upload-page";
	}
	
	 
	 
	@RequestMapping(value="/save-image", method = RequestMethod.POST)
	public String ImageSave(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException 
	{

		String fileUploadPath = fileUploadService.uploadFile(file);
		System.out.println(fileUploadPath);
		return "redirect: image-upload";
		
	}
 
  
	@RequestMapping(value="/slider-save", method = RequestMethod.POST)
	public String saveSlider(@ModelAttribute("slider") @Validated Slider slider, BindingResult bindingResult, @RequestParam("fileImage") MultipartFile fileImage, Principal principal, Model model) throws IOException, IllegalStateException {
	
		 if (bindingResult.hasErrors()) {
			 User user = userService.getUserByName(principal.getName());
			 model.addAttribute("user", user);
			return "slider-form";
		}
		 if (fileImage!=null&& !fileImage.getOriginalFilename().isEmpty()) {
			 	
		        String filePath = fileUploadService.uploadFile(fileImage);
		        slider.setImage(filePath.toString());
		          
		 }
		 if(slider.getImage()!=null)
			{
				String imagePath = slider.getImage();
				slider.setImage(imagePath);
			}
		 
		  
		 
		sliderService.addSlider(slider);
		 
		return "redirect: slider-list";
	}
	   		 
	
	// --------------------Category --------------- //
	@RequestMapping(value="/category-list")
	public String getCategoryListPage(Model model, Principal principal) {
		User user = userService.getUserByName(principal.getName());
		model.addAttribute("user", user);
		List<Category> categoryList = categoryService.getCategoryList();
		model.addAttribute("categoryList",categoryList);
		return "category-list";
	}
	
	@RequestMapping(value="/category-delete")
	public String deleteCategory(@RequestParam int id_category) {
		
		categoryService.deleteCategory(id_category);
		 
		return "redirect: category-list";
	}
	
	@RequestMapping(value="/category-form")
	public String getCategoryFormPage(Model model, Principal principal) {
		User user = userService.getUserByName(principal.getName());
		model.addAttribute("user", user);
		Category category = new Category();
		model.addAttribute("category", category);
		return "category-form";
	}
	
	@RequestMapping(value="/category-update")
	public String updateCategory(@RequestParam int id_category, Model model) {
		Category category = categoryService.getCategoryById(id_category);
		model.addAttribute("category", category);
		 		 
		return "category-form";
	}
	
	@RequestMapping(value="/category-save")
	public String saveCategory(@ModelAttribute("category") @Validated Category category, BindingResult bindingResult, Model model, Principal principal) {
		
		 if (bindingResult.hasErrors()) {
			 User user = userService.getUserByName(principal.getName());
			model.addAttribute("user", user);
			return "category-form";
		}

		categoryService.addCategory(category);
		return "redirect: category-list";
	}
	
	// --------------------Tag --------------- //
	
	@RequestMapping(value="/tag-list")
	public String getTagListPage(Model model, Principal principal) {
		User user = userService.getUserByName(principal.getName());
		List<Tag> tagList = tagService.getTagList();
		model.addAttribute("user", user);
		model.addAttribute("tagList",tagList);
		return "tag-list";
	}
	
	@RequestMapping(value="/tag-delete")
	public String deleteTag(@RequestParam int id_tag) {
		
		tagService.deleteTag(id_tag);
		 
		return "redirect: tag-list";
	}
	
	@RequestMapping(value="/tag-form")
	public String getTagFormPage(Model model, Principal principal) {
		Tag tag = new Tag();
		User user = userService.getUserByName(principal.getName());
		model.addAttribute("user", user);
		model.addAttribute("tag", tag);
		return "tag-form";
	}
	
	@RequestMapping(value="/tag-update")
	public String updateTag(@RequestParam int id_tag, Model model) {
		Tag tag = tagService.getTagById(id_tag);
		model.addAttribute("tag", tag);
		return "tag-form";
	}
	
	@RequestMapping(value="/tag-save")
	public String saveTag(@ModelAttribute("tag") @Validated Tag tag, BindingResult bindingResult, Principal principal, Model model) {
		
		if (bindingResult.hasErrors()) {
			User user = userService.getUserByName(principal.getName());
			model.addAttribute("user", user);
			return "tag-form";
		}
		tagService.addTag(tag);
		return "redirect: tag-list";
	}
	
	// --------------------MESSAGES --------------- //
	
	@RequestMapping(value="/message-list")
	public String getMessageListPage(Model model, Principal principal) {
		
		List<Message> messageList = messageService.getMessageList();
		long unseenCount = messageService.getUnseenMessageCount();
		long messageCount = messageService.getMessageCount();
		User user = userService.getUserByName(principal.getName());
		model.addAttribute("user", user);
		model.addAttribute("messageList",messageList);
		model.addAttribute("messageCount",messageCount);
		model.addAttribute("unseenCount",unseenCount);
		return "message-list";
	}
	
	@RequestMapping(value="/message-read")
	public String readMessage(@RequestParam int id_message, Model model, Principal principal) {
		
		Message message = messageService.getMessagebyId(id_message);
		messageService.setSeenMessage(id_message);
		 
		long messageCount = messageService.getMessageCount();
		long unseenCount = messageService.getUnseenMessageCount();
		User user = userService.getUserByName(principal.getName());
		model.addAttribute("user", user);
		model.addAttribute("messageCount",messageCount);
		model.addAttribute("unseenCount",unseenCount);
		model.addAttribute("message", message);
		return "message-read";
	}
	
	@RequestMapping(value="/message-delete")
	public String deleteMessage(@RequestParam int id_message, Model model) {
		
		messageService.deleteMessage(id_message);
		 
			 
		return "redirect: message-list";
	}
	
	
	// ----------------USER ---------------//
	
	@RequestMapping(value="/user-lista")
	public String getUserListPage(Model model, Principal principal) {
		 List<User>userList = userService.getUserList();
		 User user = userService.getUserByName(principal.getName());
		 model.addAttribute("user", user);
		 model.addAttribute("userList",userList);
		 return "user-lista";
	}
	 
	@RequestMapping(value="/user-enabled")
	public String getEnabledUser(@RequestParam String username) {
		
		userService.setEnableUser(username);
		return "redirect: user-lista";
	}
	
	
	@RequestMapping(value="/user-delete")
	public String deleteUser(@RequestParam String username) {
		
		userService.deleteUser(username);
		 
		return "redirect: user-lista";
	}
	
	
	@RequestMapping(value="/user-add")
	public String getUserFormPage(Model model, Principal principal) {
		
		List<Role> roleList = userService.getRoleList();
		User userPrincipal = userService.getUserByName(principal.getName());
		 
		model.addAttribute("newUser", new User());
		model.addAttribute("user", userPrincipal);
		model.addAttribute("roleList", roleList);
		return "user-add";
	}
	
	 
	@RequestMapping(value="/user-save", method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("newUser") @Validated User newUser, BindingResult bindingResult, @RequestParam("fileImage") MultipartFile fileImage, Principal principal, Model model) throws IOException, IllegalStateException {
	
		 if (bindingResult.hasErrors()) {
			 User user = userService.getUserByName(principal.getName());
			 model.addAttribute("user", user);
			 List<Role> roleList = userService.getRoleList();
			 model.addAttribute("roleList", roleList);
				return "user-add";
			}
		 if(fileImage!=null) {
			 String filePath = fileUploadService.uploadFile(fileImage);
			 newUser.setImage(filePath);
		 }
		 
		 newUser.generateBCryptPassword();
		userService.addUser(newUser);
		 
		return "redirect: user-lista";
	}
	
	@RequestMapping(value="/user-update-form")
	public String userUpdateForm(@RequestParam String username, Model model, Principal principal) {
		User userToUpdate = userService.getUserByUsername(username);
		List<Role> roleList = userService.getRoleList();
		User userPrincipal = userService.getUserByName(principal.getName());
		List<Role>userRoles = userToUpdate.getRoles();
		
		System.out.println("STAMPANJE ENABLED DISABLED -----------");
		for(Role r : userRoles) {
			System.out.println(r.toString());
			
		}
		System.out.println(userToUpdate.getEnabled());
		
		model.addAttribute("user", userPrincipal);
		model.addAttribute("userToUpdate", userToUpdate);
		model.addAttribute("roleList", roleList);
		 
		return "user-update-form";
	}
	 
	 
	@RequestMapping(value="/user-update", method=RequestMethod.POST)
	public String userUpdateSave(@ModelAttribute("user") @Validated User user, BindingResult bindingResult, @RequestParam("fileImage") MultipartFile fileImage, Model model, Principal principal) throws IOException, IllegalStateException {
	  
		List<Role> roleList = userService.getRoleList();
		if (bindingResult.hasErrors()) {
			model.addAttribute("roleList", roleList);
			return "user-update-form";
		}
 
		
		if(fileImage!=null&& !fileImage.getOriginalFilename().isEmpty()) {
			 String filePath = fileUploadService.uploadFile(fileImage);
			 user.setImage(filePath);
		 }
		
		if(user.getImage()!=null)
		{
			String imagePath = user.getImage();
			user.setImage(imagePath);
		}
		userService.updateExistingUser(user);
 
		 
		return "redirect: dashboard";
		 
	}
	
	// -------- Admin Header & Sidebar page ------------//
	@RequestMapping(value="/admin-header")
	public String adminHeader(Principal principal, Model model) {
		User user = userService.getUserByName(principal.getName());
		model.addAttribute("user", user);
		  
		return "admin-header";
	}
	
	@RequestMapping(value="/admin-sidebar")
	public String adminSidebar(Principal principal, Model model) {
		User user = userService.getUserByName(principal.getName());
		model.addAttribute("user", user);
		 
		return "admin-sidebar";
	
	}
	
	// -------------- PASSWORD CHANGE --------//
	@RequestMapping(value="/change-password-form")
	public String ChangePassword(Principal principal, Model model) {
		
		User user=userService.getUserByName(principal.getName()); 
		
		model.addAttribute("passwordChange", new PasswordChange());
		model.addAttribute("user",user);
		return "change-password-form";
	}
	
	@RequestMapping(value="/change-mypassword-save")
	public String SaveChangedPassword(Principal principal, @ModelAttribute("passwordChange") @Validated  PasswordChange passwordChange, BindingResult bindingResult, Model model) {
		User user = userService.getUserByName(principal.getName());
		String userPassword=user.getEncodedPassword();
		
		String message="";
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("passwordChange", new PasswordChange());
			return "change-password-form";
		}
		 
		
		if(!BCrypt.checkpw(passwordChange.getOldPassword(), userPassword)) {
			message="Old password did not match";
			model.addAttribute("message",message);
			model.addAttribute("success",2);
			 
			
		}
		else if(BCrypt.checkpw(passwordChange.getOldPassword(), userPassword)) {
			
			if(passwordChange.getNewPassword().equals(passwordChange.getConfirmPassword())) {
				user.setPassword(passwordChange.getConfirmPassword());
				user.generateBCryptPassword();
				userService.addUser(user);
				message="Password changed sucessfully";
				model.addAttribute("message",message);
				model.addAttribute("success",1);
				model.addAttribute("changePassword",new PasswordChange());
				 
			}
			else {
				message="Confirm password did not match";
				model.addAttribute("message",message);
				model.addAttribute("success",2);
				 
			}
		}
		else {
			model.addAttribute("message",message);
			message="Password didn't change";
			model.addAttribute("success",2);
			 
		}
	 
		return "change-password-form";
		 
	}
	  
 
	//  -------------- BLOG ----------------//
	
	@RequestMapping(value="/blog-list")
	public String getBlogListPage(Model model, Principal principal, 
			@RequestParam (required=false) Integer id_category, 
			@RequestParam(required=false) String title,
			@RequestParam(required=false) Integer[] tag,
			@RequestParam(required=false) String author_name,
			@RequestParam(required=false) String author_surname,
			@RequestParam(required=false) Boolean enabled
			) 
	{
		 
		User user = userService.getUserByName(principal.getName());
		List<BlogProduct> blogList = new ArrayList<BlogProduct>();
		if(user.getUserRole().equals("ROLE_admin")) 
		{
			blogList = blogProductService.getBlogProductSearch(id_category, title, tag, author_name, author_surname, enabled);
		}
		else if(user.getUserRole().equals("ROLE_user")) {
			String username = user.getUsername();
			blogList = blogProductService.getBlogProductSearchByUser(title, id_category, tag, enabled, username);
		}
		
		//List<BlogProduct> blogList = blogProductService.getBlogProductSearch(id_category, title, tag, author_name, author_surname, enabled);
		 
		List<Category> categoryList = categoryService.getCategoryList();
		
		List<User> userList = userService.getUserList();
		List<Tag> tagList = tagService.getTagList();
		
		
		model.addAttribute("user", user);
		 
		model.addAttribute("blogList",blogList);
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("userList", userList);
		model.addAttribute("tagList", tagList);
		return "blog-list";
	}
	 
	 
	@RequestMapping(value="/blog-enabled")
	public String getEnabledBlog(@RequestParam int id_blog_product) {
		
		BlogProduct blog = blogProductService.getBlogProductById(id_blog_product);
		blog.setEnabled(!blog.getEnabled());
		blogProductService.updateBlogProduct(blog);
		
		return "redirect: blog-list";
	}
	
	@RequestMapping(value="/blog-delete")
	public String deleteBlog(@RequestParam int id_blog_product) {
		
		blogProductService.deleteBlogProduct(id_blog_product);
		 
		return "redirect: blog-list";
	}
	
	@RequestMapping(value="/blog-form")
	public String getBlogFormPage(Model model, Principal principal) {
		User user = userService.getUserByName(principal.getName());
		BlogProduct blog = new BlogProduct();
		blog.setUser(user);
		List<Category> categoryList = categoryService.getCategoryList();
		List<Tag> tagList = tagService.getTagList();
		String role = user.getRoles().get(0).toString();
		 
		model.addAttribute("user", user);
		model.addAttribute("role", role);
		model.addAttribute("blog", blog);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("tagList", tagList);
		return "blog-form";
	}
	
	 
 
	@RequestMapping(value="/blog-save", method = RequestMethod.POST)
	public String saveBlog(@ModelAttribute("blog") @Validated BlogProduct blogProduct, BindingResult bindingResult, @RequestParam("fileImage") MultipartFile fileImage, Principal principal, Model model) throws IOException, IllegalStateException {
		
		if (bindingResult.hasErrors()) {
			 	User user = userService.getUserByName(principal.getName());
				List<Category> categoryList = categoryService.getCategoryList();
				List<Tag> tagList = tagService.getTagList();
 
				model.addAttribute("user", user);
				model.addAttribute("categoryList", categoryList);
				model.addAttribute("tagList", tagList);
				return "blog-form";
			}
		 
		User userObject= userService.getUserByName(principal.getName());
		blogProduct.setUser(userObject);
		List<Tag>tags=new ArrayList<Tag>();
		for(Tag t: blogProduct.getTags())
		{			
			Tag unos = tagService.getTagById(t.getId_tag());
					 
			tags.add(unos);			
		}
		blogProduct.setDate_created(LocalDateTime.now());
		blogProduct.setTags(tags); 
		
		 if (!fileImage.isEmpty()) {
			 	
		        String filePath = fileUploadService.uploadFile(fileImage);
		        blogProduct.setImage(filePath.toString());
		          
		 }
		
		
		blogProductService.addBlogProduct(blogProduct);
		blogProductService.callDateString();
		return "redirect: blog-list";
		}
	 
	@RequestMapping(value="/blog-update-form")
	public String updateBlog(@RequestParam int id_blog_product, Model model, Principal principal) {
		User user = userService.getUserByName(principal.getName());
		
		BlogProduct blog = blogProductService.getBlogProductById(id_blog_product);
		 	
		Category category = categoryService.getCategoryByBlogId(id_blog_product);
		blog.setCategory(category);
		List<Tag> tagBlogList = tagService.getTagListByBlogID(id_blog_product);
		blog.setTags(tagBlogList);
		List<BlogComment>blogCommentList = blogCommentService.getBlogCommentListByBlogID(id_blog_product);
		blog.setBlog_comments(blogCommentList);
		String role = user.getRoles().get(0).toString();
		List<Category> categoryList = categoryService.getCategoryList();
		List<Tag> tagList = tagService.getTagList();
		
		model.addAttribute("blog",blog);	
		model.addAttribute("tagList", tagList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("user", user);
		model.addAttribute("role",role);	
		 
		
		return "blog-update-form";
	}
	
 
	@RequestMapping(value="/blog-update-save", method=RequestMethod.POST)
	public String saveUpdatedBlog(@ModelAttribute("blog") @Validated BlogProduct blogProduct, BindingResult bindingResult, @RequestParam("fileImage") MultipartFile fileImage ,Principal principal, Model model) throws IOException, IllegalStateException {
		if (bindingResult.hasErrors()) {
			User user = userService.getUserByName(principal.getName());
			int id_blog_product= blogProduct.getId_blog_product();
			Category category = categoryService.getCategoryById(blogProduct.getCategory().getId_category());
			blogProduct.setCategory(category);
			List<Tag> tagBlogList = tagService.getTagListByBlogID(id_blog_product);
			blogProduct.setTags(tagBlogList);
			List<BlogComment>blogCommentList = blogCommentService.getBlogCommentListByBlogID(id_blog_product);
			blogProduct.setBlog_comments(blogCommentList);
			
			List<Category> categoryList = categoryService.getCategoryList();
			List<Tag> tagList = tagService.getTagList();
			 
		 
			model.addAttribute("categoryList", categoryList);
			model.addAttribute("tagList", tagList);
			 
			model.addAttribute("user", user);
		 
			 return "blog-update-form";
		}
		  
			User userObject = userService.getUserByBlogID(blogProduct.getId_blog_product());
			blogProduct.setUser(userObject);
			List<Tag>tags=new ArrayList<Tag>();
			List<BlogComment> blogCommentList = blogCommentService.getBlogCommentListByBlogID(blogProduct.getId_blog_product());
			 
			Category category = categoryService.getCategoryById(blogProduct.getCategory().getId_category());
	  
			for(Tag t: blogProduct.getTags())
			{			
				Tag unos = tagService.getTagById(t.getId_tag());
						 
				tags.add(unos);			
			}
			blogProduct.setTags(tags); 
			blogProduct.setDate_modified(LocalDateTime.now());
			blogProduct.setCategory(category); 
			blogProduct.setBlog_comments(blogCommentList);
			 
			if (fileImage!=null && !fileImage.getOriginalFilename().isEmpty()) {
			 	
		        String filePath = fileUploadService.uploadFile(fileImage);
		        blogProduct.setImage(filePath.toString());
		          
			}
			if(blogProduct.getImage()!=null) {
				String imagePath = blogProduct.getImage();
				blogProduct.setImage(imagePath);
			}
			
			 
			blogProductService.updateBlogProduct(blogProduct);
			blogProductService.callDateString();
			return "redirect: blog-list";
		}
	
	 

	@RequestMapping(value="/blog-read")
	public String readBlog(@RequestParam int id_blog_product, Model model, Principal principal) {
		
		BlogProduct blog = blogProductService.getBlogProductById(id_blog_product);
		List<BlogComment> commentList = blogCommentService.getBlogCommentListByBlogID(id_blog_product);
		List<Tag> tagList = tagService.getTagList();
		
		//blog.setBlog_comments(commentList);
		User user = userService.getUserByName(principal.getName());
		model.addAttribute("commentList",commentList);
		model.addAttribute("user", user);
		model.addAttribute("blog", blog);
		model.addAttribute("tagList", tagList);
		return "blog-read";
	}
	
	
	// --------- COMMENTS ----------------//
	
	@RequestMapping(value="/comment-list")
	public String getCommentListPage(Model model, Principal principal, 
			@RequestParam (required=false) Integer id_blog_comment, 
			@RequestParam(required=false) Boolean enabled
			) 
	{
		 
		User user = userService.getUserByName(principal.getName());
		List<BlogComment> blogCommentList = blogCommentService.getBlogCommentSearch(id_blog_comment, enabled);
		  
		model.addAttribute("user", user);
		model.addAttribute("blogCommentList",blogCommentList);
 
		return "comment-list";
	}
	
	@RequestMapping(value="/comment-enabled")
	public String setEnabledBlogComment(@RequestParam int id_blog_comment) {
		
		blogCommentService.setEnableBlogComment(id_blog_comment);
		 
		return "redirect: comment-list";
	}
	
	// ----------CONTACT INFO -----------//
	
	@RequestMapping(value="/contact-form")
	public String getContactFormPage(Model model, Principal principal) {
		
		User user = userService.getUserByName(principal.getName());
		Contact contact = contactService.getContactInfo();
		model.addAttribute("contact", contact);
		model.addAttribute("user", user);
		return "contact-form";
	}
	
	@RequestMapping(value="/contact-save")
	public String saveContact(@ModelAttribute Contact contact, Model model,Principal principal) {
		User user = userService.getUserByName(principal.getName());
		contactService.updateContact(contact);
		String message="Contact info changed";
		model.addAttribute("message",message);
		model.addAttribute("success",1);
		model.addAttribute("user", user);
		return "contact-form";
	}
	
	
	
}

