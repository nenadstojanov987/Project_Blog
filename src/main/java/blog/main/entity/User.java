package blog.main.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name="users")
@Valid
public class User {

	@Id
	@Column
	@NotBlank
	@Size(min=2, max=45)
	private String username;
	
	@Column
	@NotBlank
	@Size(min=5)
	private String password;
	
	@Column
	@NotBlank
	@Size(min=2,max=100)
	private String name;
	@Column
	@NotBlank
	@Size(min=2,max=100)
	private String surname;
	@Column
	@NotBlank
	@Size(min=6,max=200)
	@Email
	private String email;
	@Column
	@NotBlank
	@Size(min=6,max=100)
	@Pattern(regexp = "\\+\\d{6,100}",
            message = "phone number must be of 6 to 100 length with + prefix")
	private String phone_number;
	@Column
	private String image;
	@Column
	private boolean enabled;
	
	@ManyToMany(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinTable(name="authorities",joinColumns = @JoinColumn(name="username"), inverseJoinColumns = @JoinColumn(name="authority"))
	private List<Role>roles;

	
	public User() {}


	public User(String username, String password, String name, String surname, String email, String phone_number,
			String image, boolean enabled, List<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone_number = phone_number;
		this.image = image;
		this.enabled = enabled;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		 
		this.username = username;
		 
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		String nameInput="";
		char c = Character.toUpperCase(name.charAt(0));
		nameInput+=c;
		for(int i=1; i<name.length(); i++) 
		{
			char cn = Character.toLowerCase(name.charAt(i));
			nameInput+=cn;
		}
		this.name = nameInput;
	}
	

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		String surnameInput="";
		char c = Character.toUpperCase(surname.charAt(0));
		surnameInput+=c;
		for(int i=1; i<surname.length(); i++) 
		{
			char cn = Character.toLowerCase(surname.charAt(i));
			surnameInput+=cn;
		}
		this.surname = surnameInput;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	public String getEncodedPassword() {
		 
		return this.password.replace("{bcrypt}", "");
	}
	
	public void generateBCryptPassword() {
		if(!this.getPassword().contains("{bcrypt}")) 
		{
			String cpassword = new BCryptPasswordEncoder().encode(this.getPassword());
			this.setPassword("{bcrypt}"+cpassword);
		}
		
	}
	
	public String getUserRole() {
		Role role = this.roles.get(0);
		
		return role.toString();

	}
	
	 
	
	
}
