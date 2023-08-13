package blog.main.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="blog_comment")
@Valid
public class BlogComment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id_blog_comment;
	
	@Column
	private int blog_product_id; 
	
	@OneToOne(cascade = CascadeType.ALL)
	//@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="visitor_id")
	@Valid
	private Visitor visitor;
	
	@Column
	@NotBlank
	@Size(min=1,max=1000)
	private String content;
	 
	@Column
	private LocalDateTime blog_comment_date;
	 @Column
	private boolean enabled;
	 
	 
	 public BlogComment() {}
	 
	 
	public BlogComment(int id_blog_comment, int blog_product_id, Visitor visitor,
			String content, LocalDateTime blog_comment_date, boolean enabled) {
		super();
		this.id_blog_comment = id_blog_comment;
		this.blog_product_id = blog_product_id;
		this.visitor = visitor;
		this.content = content;
		this.blog_comment_date = blog_comment_date;
		this.enabled = enabled;
	}
	
	public BlogComment(int blog_product_id, Visitor visitor,
			String content, LocalDateTime blog_comment_date, boolean enabled) {
		super();
		this.blog_product_id = blog_product_id;
		this.visitor = visitor;
		this.content = content;
		this.blog_comment_date = blog_comment_date;
		this.enabled = enabled;
	}

	public BlogComment(String blog_product_id, Visitor visitor,
			String content, LocalDateTime blog_comment_date, boolean enabled) {
		super();
		this.blog_product_id = Integer.parseInt(blog_product_id);
		this.visitor = visitor;
		this.content = content;
		this.blog_comment_date = blog_comment_date;
		this.enabled = enabled;
	}



	public int getId_blog_comment() {
		return id_blog_comment;
	}

	public void setId_blog_comment(int id_blog_comment) {
		this.id_blog_comment = id_blog_comment;
	}

	public int getBlog_product_id() {
		return blog_product_id;
	}

	public void setBlog_product_id(int blog_product_id) {
		this.blog_product_id = blog_product_id;
	}
	 

	public Visitor getVisitor() {
		return visitor;
	}

	public String getVisitorName() {
		return visitor.getVisitor_name();
	}
	
	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getBlog_comment_date() {
		return blog_comment_date;
	}

	public void setBlog_comment_date(LocalDateTime blog_comment_date) {
		this.blog_comment_date = blog_comment_date;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
  

	public String getDateDiffDay() 
	{
		DateTimeCalculation dtc = new DateTimeCalculation();
		String result = dtc.getdateDiffDayFromNow(this.blog_comment_date);
		return result;
	}

	@Override
	public String toString() {
		return "BlogComment [id_blog_comment=" + id_blog_comment + ", blog_product_id=" + blog_product_id + ", visitor="
				+ visitor + ", content=" + content + ", blog_comment_date=" + blog_comment_date + ", enabled=" + enabled
				+ "]";
	}
	
	
	 
	
	
}
