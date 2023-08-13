package blog.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="category")
@Valid
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id_category;
	@Column
	@Size(min=3, max=50)
	private String category_name;
	@Column
	@Size(min=3, max=500)
	private String category_description;
	@Column
	private int category_priority;
	@Column
	private int category_blog_count;
	
	public Category() {}
	
	 
	public Category( String category_name,String category_description, int category_priority) {
		super();
	 
		this.category_name = category_name;
		this.category_description = category_description;
		this.category_priority = category_priority;
	}
	
	public Category( String category_name,String category_description) {
		super();
	 
		this.category_name = category_name;
		this.category_description = category_description;
		 
	}
	 
	 
	public Category(int id_category, String category_name,String category_description,  int category_priority) {
		super();
		this.id_category = id_category;
		this.category_name = category_name;
		this.category_description = category_description;
		this.category_priority = category_priority;
	}
	
	
	
	public Category(int id_category, String category_name, String category_description, int category_priority,
			int category_blog_count) {
		super();
		this.id_category = id_category;
		this.category_name = category_name;
		this.category_description = category_description;
		this.category_priority = category_priority;
		this.category_blog_count = category_blog_count;
	}


	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		
		String name="";
		char c = Character.toUpperCase(category_name.charAt(0));
		name+=c;
		for(int i=1; i<category_name.length(); i++) 
		{
			char cn = Character.toLowerCase(category_name.charAt(i));
			name+=cn;
		}
		this.category_name = name;
	}
	public String getCategory_description() {
		return category_description;
	}
	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}
	public int getCategory_priority() {
		return category_priority;
	}
	public void setCategory_priority(int category_priority) {
		this.category_priority = category_priority;
	}


	public int getCategory_blog_count() {
		return category_blog_count;
	}


	public void setCategory_blog_count(int category_blog_count) {
		this.category_blog_count = category_blog_count;
	}


	@Override
	public String toString() {
		return "Category [id_category=" + id_category + ", category_name=" + category_name + ", category_description="
				+ category_description + ", category_priority=" + category_priority + ", category_blog_count="
				+ category_blog_count + "]";
	}
 
	
}
