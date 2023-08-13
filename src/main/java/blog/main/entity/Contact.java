package blog.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="contact")
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id_contact;
	@Column
	@NotBlank
	@Size(min=3,max=300)
	private String adress;
	@Column
	@NotBlank
	@Size(min=3,max=100)
	private String phone_number;
	@Column
	@NotBlank
	@Size(min=3,max=300)
	private String email;
	
	public Contact() {}

	public Contact(int id_contact, String adress, String phone_number, String email) {
		super();
		this.id_contact = id_contact;
		this.adress = adress;
		this.phone_number = phone_number;
		this.email = email;
	}
	public Contact( String adress, String phone_number, String email) {
		super();
		this.adress = adress;
		this.phone_number = phone_number;
		this.email = email;
	}

	public int getId_contact() {
		return id_contact;
	}

	public void setId_contact(int id_contact) {
		this.id_contact = id_contact;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [id_contact=" + id_contact + ", adress=" + adress + ", phone_number=" + phone_number
				+ ", email=" + email + "]";
	}
	
	
}
