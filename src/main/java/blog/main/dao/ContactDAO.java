package blog.main.dao;

 

import org.springframework.stereotype.Component;

import blog.main.entity.Contact;
 
@Component
public interface ContactDAO {
	public Contact getContactInfo();
	 
	public void updateContact(Contact contact);

	
}
