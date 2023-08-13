package blog.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="visitor")
@Valid
public class Visitor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id_visitor;
	@Column
	@Size(min=1,max=255)
	private String visitor_name;
	@Column
	@NotBlank
	@Size(min=6,max=255)
	@Email
	private String email;
	@Column
	private boolean banned;
	@Column
	private String visitor_image;
	
	
	public Visitor() {}
	
	
	public Visitor(int id_visitor, String visitor_name, String email, boolean banned, String visitor_image) {
		super();
		this.id_visitor = id_visitor;
		this.visitor_name = visitor_name;
		this.email = email;
		this.banned = banned;
		this.visitor_image = visitor_image;
	}
	
	
	public Visitor(String id_visitor, String visitor_name, String email, boolean banned, String visitor_image) {
		super();
		this.id_visitor = Integer.parseInt(id_visitor);
		this.visitor_name = visitor_name;
		this.email = email;
		this.banned = banned;
		this.visitor_image = visitor_image;
	}

	public int getId_visitor() {
		return id_visitor;
	}
	public void setId_visitor(int id_visitor) {
		this.id_visitor = id_visitor;
	}
	public String getVisitor_name() {
		return visitor_name;
	}
	public void setVisitor_name(String visitor_name) {
		this.visitor_name = visitor_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getBanned() {
		return banned;
	}
	public void setBanned(boolean banned) {
		this.banned = banned;
	}

	
	public String getVisitor_image() {
		return visitor_image;
	}


	public void setVisitor_image(String visitor_image) {
		this.visitor_image = visitor_image;
	}


	@Override
	public String toString() {
		return "Visitor [id_visitor=" + id_visitor + ", visitor_name=" + visitor_name + ", email=" + email + ", banned="
				+ banned + ", visitor_image=" + visitor_image + "]";
	}


	 
	
	
	
}
