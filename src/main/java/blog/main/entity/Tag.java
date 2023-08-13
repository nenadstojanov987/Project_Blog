package blog.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tag")
public class Tag {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id_tag;
	@Column
	@NotBlank
	@NotNull
	@Size(min=3,max=50)
	private String tag_name;
	
	public Tag() {}
	
	public Tag(int id_tag, String tag_name) {
		super();
		this.id_tag = id_tag;
		this.tag_name = tag_name;
	}
	
	 
	public Tag (String id_tag) {
		
		this.setId_tag(Integer.parseInt(id_tag));
		
	}
	 
	public int getId_tag() {
		return id_tag;
	}
	public void setId_tag(int id_tag) {
		this.id_tag = id_tag;
	}
	public String getTag_name() {
		
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		
		char c = tag_name.charAt(0);
		String name = c=='#'?"":"#";
		 
		for(int i=0; i<tag_name.length(); i++) 
		{
			char cn = Character.toUpperCase(tag_name.charAt(i));
			name+=cn;
		}
		this.tag_name = name;
		
	}
	
	public String getTagSeoName()
	{	String tagNameTrimmed = this.tag_name.replace("#", "");
		String seoTag = tagNameTrimmed.replace(" ", "-");
		return seoTag.toLowerCase();
	}

	@Override
	public String toString() {
		return "Tag [id_tag=" + id_tag + ", tag_name=" + tag_name + "]";
	}
	
	
	

}
