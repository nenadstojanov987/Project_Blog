package blog.main.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="blog_product")
public class BlogProduct {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id_blog_product;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name="username")
	@Valid
	private User user;
	
	@Column
	@NotBlank
	@NotNull
	@Size(min=20,max=255)
	private String blog_title;
	
	@Column
	@NotBlank
	@NotNull
	@Size(min=50,max=500)
	private String description;
	
	@Column
	@NotBlank
	@NotNull
	@Size(min=50)
	private String content;
	
	@Column
	private boolean important;
	
	@Column
	private boolean enabled;
	
	@Column
	private String image;
	
	@Column
	private int visit_count;
	
	@Column
	private int comment_count;
	
	@Column
	private LocalDateTime date_created;
	
	@Column
	private LocalDateTime date_modified;
	
	@Column
	private String date_string;
	
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name="category_id")
	@Valid
	private Category category;
	
	@ManyToMany(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="blog_product_tag",
	joinColumns = @JoinColumn(name="blog_product_id"), 
	inverseJoinColumns= @JoinColumn(name="tag_id"))
	private List<Tag> tags;
	 
	
	// CascadeType All
	//@JoinColumn(name="blog_product_id")
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy="blog_product_id")
	@Valid
	private List<BlogComment> blog_comments;
 
	 
	public BlogProduct() {}
	
	 
	public BlogProduct(int id_blog_product, User user, String blog_title, String description, String content,
			boolean important, boolean enabled, String image, int visit_count, int comment_count,
			LocalDateTime date_created, LocalDateTime date_modified, Category category, List<Tag> tags,
			List<BlogComment> blog_comments) {
		super();
		this.id_blog_product = id_blog_product;
		this.user = user;
		this.blog_title = blog_title;
		this.description = description;
		this.content = content;
		this.important = important;
		this.enabled = enabled;
		this.image = image;
		this.visit_count = visit_count;
		this.comment_count = comment_count;
		this.date_created = date_created;
		this.date_modified = date_modified;
		this.category = category;
		this.tags = tags;
		this.blog_comments = blog_comments;
	}

	public BlogProduct( User user, String blog_title, String description, String content,
			boolean important, boolean enabled, String image, int visit_count, int comment_count,
			LocalDateTime date_created, LocalDateTime date_modified, Category category, List<Tag> tags,
			List<BlogComment> blog_comments) {
		super();
 
		this.user = user;
		this.blog_title = blog_title;
		this.description = description;
		this.content = content;
		this.important = important;
		this.enabled = enabled;
		this.image = image;
		this.visit_count = visit_count;
		this.comment_count = comment_count;
		this.date_created = date_created;
		this.date_modified = date_modified;
		this.category = category;
		this.tags = tags;
		this.blog_comments = blog_comments;
	}

 
	public String getDate_string() {
		return date_string;
	}


	public void setDate_string(String date_string) {
		this.date_string = date_string;
	}


	public int getId_blog_product() {
		return id_blog_product;
	}

	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public void setId_blog_product(int id_blog_product) {
		this.id_blog_product = id_blog_product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBlog_title() {
		return blog_title;
	}

	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean getImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getVisit_count() {
		return visit_count;
	}

	public void setVisit_count(int visit_count) {
		this.visit_count = visit_count;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
 
	public LocalDateTime getDate_created() {
		return date_created;
	}


	public void setDate_created(LocalDateTime date_created) {
		this.date_created = date_created;
	}


	public LocalDateTime getDate_modified() {
		return date_modified;
	}


	public void setDate_modified(LocalDateTime date_modified) {
		this.date_modified = date_modified;
	}


	public 
	List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
 
 
	public List<BlogComment> getBlog_comments() {
		return blog_comments;
	}

	public void setBlog_comments(List<BlogComment> blog_comments) {
		this.blog_comments = blog_comments;
	}
 
	 
	@Override
	public String toString() {
		return "BlogProduct [id_blog_product=" + id_blog_product + ", user=" + user + ", blog_title=" + blog_title
				+ ", description=" + description + ", content=" + content + ", important=" + important + ", enabled="
				+ enabled + ", image=" + image + ", visit_count=" + visit_count + ", comment_count=" + comment_count
				+ ", date_created=" + date_created + ", date_modified=" + date_modified + ", category=" + category
				+ ", tags=" + tags + ", blog_comments=" + blog_comments + "]";
	}


	public String getBlogProductSeoTitle()
	{
		// proci kroz listu i traziti niz karaktera i iste zameniti sa -
		String seoTitle = this.blog_title.replace("?", "").toLowerCase();
		seoTitle = seoTitle.replace("/", "-").toLowerCase();
		seoTitle = seoTitle.replace("'\'", "-").toLowerCase();
		seoTitle = seoTitle.replace("$", "-").toLowerCase();
		seoTitle = seoTitle.replace(" ", "-").toLowerCase();
		//seoTitle = seoTitle.replaceAll("", seoTitle) moguce upotrebiti i regex
		return seoTitle;
	} 

	public String getBlogCategoryName()
	{
		 
		return this.category.getCategory_name().toUpperCase();
	}
	
	 
	public String getDateCreatedString()
	{
		 DateTimeCalculation dt = new DateTimeCalculation();
		String dateModified=  dt.getdateDiffDayFromNow(this.date_created);
		return dateModified;
	}
	
	public String getDateStringFooter()
	{
		int year = this.date_created.getYear();
		int monthNumber= this.date_created.getMonthValue();
		int dayNumber= this.date_created.getDayOfMonth();
		Date date  = new Date(year,monthNumber,dayNumber);
		String month = "";
		 
		int monthValue= this.date_created.getMonthValue();
		switch(monthValue) {
		
			case 1: month="January";
				break;
			case 2: month="February";
			break;	
			case 3: month="March";
			break;
			case 4: month="April";
			break;
			case 5: month="May";
			break;
			case 6: month="June";
			break;
			case 7: month="July";
			break;
			case 8: month="August";
			break;
			case 9: month="September";
			break;
			case 10: month="October";
			break;
			case 11: month="November";
			break;
			case 12: month="December";
			break;
		
		}
		
		String dateModified = month+" "+ dayNumber+" ,"+ year;
				
		return dateModified;
	}
	
	public int getNumberOfComments() {
		return  blog_comments.size();
	}
	
}
